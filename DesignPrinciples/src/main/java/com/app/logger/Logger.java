package com.app.logger;


public class Logger {

	private static final String LOGFILE_NAME = "log.txt";

	// Strings
	private static final String DEBUG_PREFIX = "[Debug]";
	private static final String ERROR_PREFIX = "[Error]";
	private static final String LOGGER_STARTED_UP = "Logger started up.";
	private static final String LOGGER_SHUTTING_DOWN = "Logger shutting down.";

	private static Logger instance = null;
	
}
