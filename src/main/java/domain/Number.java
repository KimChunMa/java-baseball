package domain;

public class Number {
    private int threeDigitNumber;
    private int hundreds;
    private int tends;
    private int ones;

    public Number(String number) {
        validation(number);
    }

    public void validation(String number) {
        try {
            toParseInt(number);
            checkNumber();
        } catch (Exception e) {
            throw new IllegalStateException("잘못된 입력값 입니다!");
        }
    }

    public void toParseInt(String number) {
        threeDigitNumber = Integer.parseInt(number);
        hundreds = threeDigitNumber / 100;
        tends = (threeDigitNumber % 100) / 10;
        ones = (threeDigitNumber % 100) % 10;
    }

    public void checkNumber() {
        if (hundreds == tends || tends == ones || hundreds == ones) {
            throw new IllegalStateException("2개 이상의 동일한 숫자가 입력되었습니다!");
        }
    }
}
