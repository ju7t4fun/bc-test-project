package name.just4fun.bct.dialog;

/**
 * @author Yura Kovalik
 * @since by 9/7/2016.
 */
public interface DialogManager {

    String input();

    String inputWithInvite(String inviteText);

    void output(String text);

}
