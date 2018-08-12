package com.example.osgi.cli;

import static org.slf4j.LoggerFactory.getLogger;


import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.lifecycle.Reference;
import org.apache.karaf.shell.api.action.lifecycle.Service;
import org.slf4j.Logger;

import com.example.osgi.api.SampleService;

/**
 * Created by resulav on 11.08.2018.
 */
@Command(scope = CommandUtility.SCOPE, name = SampleCommand.COMMAND, description = "Returns sample service name")
@Service
public class SampleCommand implements Action {

	private final Logger logger = getLogger(getClass());

	static final String COMMAND = "sample";

	@Reference
	private SampleService service;

	@Override
	public Object execute() throws Exception {
		try {
            CommandUtility.calledCommand(logger, COMMAND);
            return service.getName();
        }finally {
            CommandUtility.finishedCommand(logger, COMMAND);
        }
	}
}
