package Hotstart;

import java.util.HashSet;
import java.util.Map;

public class CosoleSink extends Sink{

	@Override
	public void configSink(Map<String, String> config) {
		sink_type = SINK_TYPE.CONSOLE;
		logLevelSet = new HashSet<>();
		
		if(config == null) {
			//default config..
			logLevelSet.add(LOG_LEVEL.DEBUG);
			logLevelSet.add(LOG_LEVEL.INFO);
			logLevelSet.add(LOG_LEVEL.WARNING);
			logLevelSet.add(LOG_LEVEL.ERROR);
			logLevelSet.add(LOG_LEVEL.FATAL);
		}else {
			//get the log levels from config map and put into the set, key = "LogLevel" => "DEBUG,INFO,WARNING,ERROR,FATAL"
		}
		
	}
	
	@Override
	public void writeLog(Message message) {
	
		if(!logLevelSet.contains(message.getLogLevel())){
			return;
		}
		
		System.out.println(message.toString());
	}
}
