package com.example.osgi.felix.scr.cli.arg;

import com.example.osgi.felix.scr.api.SampleService;
import com.example.osgi.felix.scr.cli.util.CommandUtility;
import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Argument;
import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.Option;
import org.apache.karaf.shell.api.action.lifecycle.Reference;
import org.apache.karaf.shell.api.action.lifecycle.Service;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by resulav on 13.08.2018.
 */
@Command(scope = CommandUtility.SCOPE, name = EchoCommand.COMMAND, description = "Returns sample service name")
@Service
public class EchoCommand implements Action {

    private final Logger logger = getLogger(getClass());

    static final String COMMAND = "echo";

    @Argument(index = 0, name = "name", description = "Name arg value", required = true)
    private String name;

    @Argument(index = 1,name = "surname", description = "Surname arg value (optional)")
    private String surname;

    @Option(name = "profession", aliases = "-p", required = true, description = "profession value")
    private String profession;

    @Option(name = "age", aliases = "-a", description = "age value (Optinal)")
    private Integer age;

    @Reference
    private SampleService service;

    @Override
    public Object execute() throws Exception {
        try {
            CommandUtility.calledCommand(logger, COMMAND);
            return service.getEcho(name,surname,profession,age);
        } finally {
            CommandUtility.finishedCommand(logger, COMMAND);
        }
    }
}
