package Controllers;

import Utilities.PasswordUtil;

public class ExitController implements BaseController {

    @Override
    public void execute(){
        System.out.println("Exiting program...");
    }
}
