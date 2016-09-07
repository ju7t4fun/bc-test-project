package name.just4fun.bct.command;

import name.just4fun.bct.dialog.DialogManager;
import name.just4fun.bct.persistence.service.BookService;

/**
 * @author Yura Kovalik
 * @since by 9/7/2016.
 */
public abstract class AbstractCommand implements Command {
    protected DialogManager manager;
    protected BookService service;

    @Override
    public void init(DialogManager manager, BookService service) {
        this.manager = manager;
        this.service = service;
    }
}
