package name.just4fun.bct.command;

import name.just4fun.bct.dialog.DialogManager;
import name.just4fun.bct.persistence.service.BookService;

/**
 * @author Yura Kovalik
 * @since by 9/7/2016.
 */
public interface Command {
    String getName();

    void action(String commandText);

    void init(DialogManager manager, BookService service);

}
