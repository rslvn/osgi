/**
 * 
 */
package com.example.osgi.felix.scr.cli;

import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.lifecycle.Reference;
import org.apache.karaf.shell.api.action.lifecycle.Service;

import com.example.osgi.felix.scr.api.SampleService;
import com.example.osgi.felix.scr.cli.util.CommandUtility;

import lombok.extern.slf4j.Slf4j;

/**
 * @author resulav
 *
 */
@Slf4j
@Command(scope = CommandUtility.SCOPE, name = PrintSampleConfig.COMMAND, description = "Returns sample service config")
@Service
public class PrintSampleConfig implements Action {

	static final String COMMAND = "print-sample-config";

	@Reference
	private SampleService service;

	@Override
	public Object execute() throws Exception {
		try {
			CommandUtility.calledCommand(log, COMMAND);
			System.out.println(service.getConfig().toString());
		} finally {
			CommandUtility.finishedCommand(log, COMMAND);
		}
		return null;
	}
}
