package name.just4fun.bct.dialog;

import name.just4fun.bct.command.ExitCommand;
import name.just4fun.bct.command.real.AddCommand;
import name.just4fun.bct.command.Command;
import name.just4fun.bct.command.real.AllCommand;
import name.just4fun.bct.command.real.EditCommand;
import name.just4fun.bct.command.real.RemoveCommand;
import name.just4fun.bct.persistence.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.substring;
import static org.apache.commons.lang3.StringUtils.trim;
import static org.apache.commons.lang3.StringUtils.trimToEmpty;

/**
 * @author Yura Kovalik
 * @since by 9/7/2016.
 */
@Component
public class Dialog {
    private static final Logger LOG = LoggerFactory.getLogger(Dialog.class);

    @Autowired
    DialogManager dm;

    @Autowired
    BookService bookService;
    private List<Command> commands = new ArrayList<>();
    {
        commands.add(new AddCommand());
        commands.add(new AllCommand());
        commands.add(new EditCommand());
        commands.add(new ExitCommand());
        commands.add(new RemoveCommand());
    }


    public void processCommand(){
        String input = trimToEmpty(dm.input());
        for (Command command : commands) {
            String commandName = command.getName();
            if( input.startsWith(commandName)){
                String arg = substring(input, commandName.length());
                command.action(trim(arg));
                return;
            }
        }
        dm.output("Current command has not been registered.");
    }

    @PostConstruct
    public void init(){
        commands.forEach(command -> command.init(dm, bookService));

        if(LOG.isDebugEnabled()) {
            String collect = commands.stream().map(Command::getName).collect(Collectors.joining(", ","","."));
            LOG.debug("Available commands: {}.",collect);
        }
        dm.output("Hello, user! Please, enter the command.");
    }
}
