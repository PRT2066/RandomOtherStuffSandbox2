package Controllers;

import Utilities.PasswordUtil;

public class PasswordController implements BaseController {

    @Override
    public void execute(){
        PasswordUtil passwordUtil = new PasswordUtil();
        int passwordLength = passwordUtil.requestLength();
        String newPassword = passwordUtil.generatePassword(passwordLength);

        if (newPassword.isEmpty())
            System.out.println("Your password is blank");
        else
            System.out.println("Your password is " + newPassword);

    }

}
