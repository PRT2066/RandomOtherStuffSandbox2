package Controllers;

import Utilities.FizzBuzzUtil;

public class FizzBuzzController implements BaseController {

    @Override
    public void execute() {
        FizzBuzzUtil fizzBuzzUtil = new FizzBuzzUtil();
        int fizzBuzzLength = fizzBuzzUtil.requestLength();
        fizzBuzzUtil.startFizzBuzz(fizzBuzzLength);
    }
}
