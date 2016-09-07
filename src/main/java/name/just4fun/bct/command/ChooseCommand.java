package name.just4fun.bct.command;

import name.just4fun.bct.CredentialsScanner;
import name.just4fun.bct.persistence.model.Book;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author Yura Kovalik
 * @since by 9/7/2016.
 */
public abstract class ChooseCommand extends AbstractCommand {
    private static final Logger LOG = LoggerFactory.getLogger(ChooseCommand.class);

    protected CredentialsScanner scanner = new CredentialsScanner();

    @Override
    public void action(String commandText) {
        Book book;
        List<Book> books;
        try {
            book = scanner.scan(commandText);
            books = service.find(book.getTitle(), book.getAuthor());
        }catch (RuntimeException e){
            LOG.debug("Error during find book.", e);
            books = service.find(commandText);
        }
        if(books != null && !books.isEmpty()){
            Book target;
            if(books.size() == 1){
                target = books.get(0);
            }else {
                StringBuilder sb = new StringBuilder("we have few books with such name please choose one by typing a number of book:");
                for (int i = 0; i < books.size(); i++) {
                    Book currentBook = books.get(i);
                    sb.append("\n\t").append(i + 1).append(".\t").append(currentBook);
                }
                manager.output(sb.toString());
                String input = manager.input();
                if(NumberUtils.isNumber(input)){
                    int pos = NumberUtils.toInt(input) - 1;
                    if(pos < books.size()){
                        target = books.get(pos);
                    }else target = null;

                }else target = null;
            }

            if(target != null){
                onChooseTarget(target);
            }
        }else {
            manager.output("Book \""+commandText+"\" has not found." );
        }
    }

    protected abstract void onChooseTarget(Book book);
}
