package Hotstart;

import java.util.Map;

public class SinkFactory {
	
	public static Sink getSink(SINK_TYPE sink_TYPE, Map<String, String> config) {
		
		switch(sink_TYPE) {
		
		case DB:
			break;
		case FILE:
			break;
		case CONSOLE:
		default:
			Sink sink = new CosoleSink();
			sink.configSink(config);
			return sink;
		}
		
		return null;
	}
}
