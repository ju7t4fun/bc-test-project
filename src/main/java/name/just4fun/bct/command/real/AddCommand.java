package name.just4fun.bct.command.real;


import name.just4fun.bct.CredentialsScanner;
import name.just4fun.bct.command.AbstractCommand;
import name.just4fun.bct.persistence.model.Book;

/**
 * @author Yura Kovalik
 * @since by 9/7/2016.
 */
public class AddCommand extends AbstractCommand {
    CredentialsScanner scanner = new CredentialsScanner();

    @Override
    public String getName() {
        return "add";
    }

    @Override
    public void action(String commandText) {
        try {
            Book book = scanner.scan(commandText);
            service.save(book);
            this.manager.output(String.format("book %s \"%s\" was added", book.getAuthor(), book.getTitle()));
        }catch (RuntimeException e){
            manager.output("Error during add command: "+ e.getMessage());
        }
    }
}
