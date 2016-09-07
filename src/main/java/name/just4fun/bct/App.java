package name.just4fun.bct;

import name.just4fun.bct.dialog.Dialog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Yura Kovalik
 * @since by 9/7/2016.
 */
public class App {
    private static final Logger LOG = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        LOG.info("App Success started!");
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        Dialog dialog = context.getBean(Dialog.class);
        while (true){
            dialog.processCommand();
        }

    }
}
