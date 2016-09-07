package name.just4fun.bct;

import name.just4fun.bct.persistence.model.Book;

import static org.apache.commons.lang3.StringUtils.split;
import static org.apache.commons.lang3.StringUtils.trim;

/**
 * @author Yura Kovalik
 * @since by 9/7/2016.
 */
public class CredentialsScanner {

    boolean correct;

    protected void throwIfNeed(){
        if(!correct){
            throw new RuntimeException("Scanner Invalid Stage!");
        }
    }

    public Book scan(String commandText) {
        correct = false;
        String authorAndTitle = trim(commandText);
        String[] split = split(authorAndTitle, '"');
        if(split.length == 2){
            correct = true;
        }
        throwIfNeed();

        String author = trim(split[0]);
        String title = trim(split[1]);
        return new Book(title, author);

    }


}
