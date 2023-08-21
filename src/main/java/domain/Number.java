package domain;

public class Number {
    private int threeDigitNumber;
    private int hundreds;
    private int tends;
    private int ones;

    public static final int NUMBER_MIN = 1;
    public static final int NUMBER_MAX = 9;
    public static final int NUMBER_SIZE = 3;

    public Number(String number) {
        validation(number);
    }

    private void validation(String number) {
        validateNumbers(number);
        toParseInt(number);
        validateRange();
        checkNumber();
    }

    private void toParseInt(String number) {
        try {
            threeDigitNumber = Integer.parseInt(number);
        } catch (Exception e) {
            throw new IllegalStateException("잘못된 입력값 입니다!");
        }
        hundreds = threeDigitNumber / 100;
        tends = (threeDigitNumber % 100) / 10;
        ones = (threeDigitNumber % 100) % 10;
    }

    private void checkNumber() {
        if (hundreds == tends || tends == ones || hundreds == ones) {
            throw new IllegalStateException("서로 다른 세자리수가 아닙니다.");
        }
    }

    private void validateNumbers(String number) {
        if (number.length() != NUMBER_SIZE) {
            throw new IllegalArgumentException("세자리수가 아닙니다.");
        }
    }

    private void validateRange() {
        if (checkRange(hundreds) || checkRange(tends) || checkRange(ones)) {
            throw new IllegalArgumentException("범위 내 숫자가 아닙니다.");
        }
    }

    private boolean checkRange(int number) {
        return number < NUMBER_MIN || number > NUMBER_MAX;
    }
}
