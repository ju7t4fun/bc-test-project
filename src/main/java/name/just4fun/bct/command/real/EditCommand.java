package name.just4fun.bct.command.real;

import name.just4fun.bct.command.ChooseCommand;
import name.just4fun.bct.persistence.model.Book;

/**
 * @author Yura Kovalik
 * @since by 9/7/2016.
 */
public class EditCommand extends ChooseCommand {
    @Override
    public String getName() {
        return "edit";
    }

    @Override
    protected void onChooseTarget(Book book) {
        String newName = manager.inputWithInvite("Please, enter new name: ");
        try {
            Book newBookCredentials = super.scanner.scan(newName);
            String result = ("Book "+book+" was renamed to "+newBookCredentials+"." );

            book.setAuthor(newBookCredentials.getAuthor());
            book.setTitle(newBookCredentials.getTitle());

            service.save(book);
            manager.output(result);

        }catch (RuntimeException ex){
            manager.output("Incorrect new Name.");
        }
    }
}
