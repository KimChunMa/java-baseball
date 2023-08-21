package domain;

import camp.nextstep.edu.missionutils.Console;

public class Human {
    private  Number number;

    public void predictNumber(){
        String strNumber = Console.readLine();
        number = new Number(strNumber);
    }
}
