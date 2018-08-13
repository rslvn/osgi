package com.example.osgi.ds.cli.util;

import org.slf4j.Logger;

/**
 * Created by resulav on 11.08.2018.
 */
public class CommandUtility {

	public static final String SCOPE = "osgi-ds";

	public static void calledCommand(Logger logger, String command) {
		logger.debug("{}:{} is called", SCOPE, command);
	}

	public static void finishedCommand(Logger logger, String command) {
		logger.debug("{}:{} is finished", SCOPE, command);
	}
}
