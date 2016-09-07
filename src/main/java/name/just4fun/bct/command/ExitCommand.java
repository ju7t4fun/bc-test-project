package name.just4fun.bct.command;

import name.just4fun.bct.dialog.DialogManager;
import name.just4fun.bct.persistence.service.BookService;

/**
 * @author Yura Kovalik
 * @since by 9/7/2016.
 */
public class ExitCommand implements Command {

    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public void action(String commandText) {
        throw new RuntimeException("Easy way to exit.");
    }

    @Override
    public void init(DialogManager manager, BookService service) {

    }
}
