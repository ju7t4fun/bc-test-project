package name.just4fun.bct.command.real;

import name.just4fun.bct.command.AbstractCommand;
import name.just4fun.bct.persistence.model.Book;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Yura Kovalik
 * @since by 9/7/2016.
 */
public class AllCommand extends AbstractCommand {
    @Override
    public String getName() {
        return "all book";
    }

    @Override
    public void action(String commandText) {
        List<Book> all = service.findAll();
        String collect = all.stream().map(Book::toString).collect(Collectors.joining("\n\t", "Our books :\n\t", ""));
        manager.output(collect);
    }
}
