package lib.validators2;

import common.validators.OptionValidator;
import common.validators2.OptionValidator2;

import java.util.Date;

public class DateBorderValidator2 implements OptionValidator2 {

    public String check(String optionValue){
        String checkResult = null;
        System.out.println("check of the data value");

        Date date = new Date();
        if (1900 + date.getYear() < Integer.valueOf(optionValue))
            checkResult = "Data value is out of range";

        return checkResult;
    }
}
