package name.just4fun.bct.command.real;

import name.just4fun.bct.command.ChooseCommand;
import name.just4fun.bct.persistence.model.Book;

/**
 * @author Yura Kovalik
 * @since by 9/7/2016.
 */
public class RemoveCommand extends ChooseCommand {


    @Override
    public String getName() {
        return "remove";
    }

    protected void onChooseTarget(Book book){
        service.remove(book);
        manager.output("book "+book+" was removed." );
    }
}
