package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    public static Number number;
    private static List<Integer> rangeList = new ArrayList<>();

    static {
        addRangeList();
    }

    public static void addRangeList() {
        for (int i = Number.NUMBER_MIN; i <= Number.NUMBER_MAX; i++) {
            rangeList.add(i);
        }
    }

    public void presentNumber() {
        List<Integer> copyRange = new ArrayList<>();
        copyRange.addAll(rangeList);
        String strNumber = "";

        for (int i = 0; i < Number.NUMBER_SIZE; i++) {
            int randomInt = Randoms.pickNumberInList(copyRange);
            strNumber += randomInt;
            copyRange.remove((Object) randomInt);
        }

        number = new Number(strNumber);
    }
}
