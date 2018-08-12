package com.example.osgi.cli;

import org.slf4j.Logger;

/**
 * Created by resulav on 11.08.2018.
 */
public class CommandUtility {

	static final String SCOPE = "osgi-demo";

	public static void calledCommand(Logger logger, String command) {
		logger.debug("{}:{} is called", SCOPE, command);
	}

	public static void finishedCommand(Logger logger, String command) {
		logger.debug("{}:{} is finished", SCOPE, command);
	}
}
