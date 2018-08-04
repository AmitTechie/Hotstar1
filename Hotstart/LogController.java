package Hotstart;

import java.util.Map;

public class LogController {
	
	private Sink sink;
	private Map<String, String> config;
	private static LogController logControllerInstance = new LogController(); //early initialization
	
	private LogController() {
		
	}
	
	public static LogController getInstance() {
		return logControllerInstance;
	}
	
	public void setLogConfig(Map<String, String> config){
		if(config == null) {
			//get default sink..
			this.sink = SinkFactory.getSink(SINK_TYPE.CONSOLE, null);
			return;
		}
		
		this.config = config;
		this.sink = SinkFactory.getSink(SINK_TYPE.valueOf(config.get("SinkType")), config);
	}

	public void setSink(Sink sink) {
		if(sink != null) {
			this.sink = sink;
		}
	}

	public void writeLog(LOG_LEVEL log_level, String msg, Object object) {
		Message message = new Message(log_level, msg, object.getClass().getName());
		
		sink.writeLog(message);
	}

	public void writeLog(LOG_LEVEL log_level, String msg) {
		if(this.sink == null) {
			sink = SinkFactory.getSink(SINK_TYPE.CONSOLE, null);
		}
		
		
		Message message = new Message(log_level, msg, null);
		
		sink.writeLog(message);
	}

}
