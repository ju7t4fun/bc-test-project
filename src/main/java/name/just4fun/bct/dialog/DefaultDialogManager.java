package name.just4fun.bct.dialog;

import java.util.Scanner;

/**
 * @author Yura Kovalik
 * @since by 9/7/2016.
 */
public class DefaultDialogManager implements DialogManager {
    Scanner scanner = new Scanner(System.in);


    @Override
    public String input() {
        return scanner.nextLine();
    }

    @Override
    public String inputWithInvite(String inviteText) {
        System.out.print(inviteText);
        return scanner.nextLine();
    }

    @Override
    public void output(String text) {
        System.out.println(text);
    }
}
