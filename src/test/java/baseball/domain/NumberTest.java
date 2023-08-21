package baseball.domain;

import domain.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class NumberTest {
    @DisplayName("동일한 숫자 입력시 에러를 발생한다.")
    @Test
    void checkNumber(){
        assertThatThrownBy(()-> {Number number = new Number("111");})
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("서로 다른 세자리수가 아닙니다.");
    }

    @DisplayName("잘못된 값 입력시")
    @Test
    void checkStrNumber(){
        assertThatThrownBy(()-> {Number number = new Number("abc");})
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 입력값 입니다!");
    }

    @DisplayName("범위 내 숫자가 아닐시")
    @Test
    void checkRange(){
        assertThatThrownBy(()-> {Number number = new Number("120");})
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("범위 내 숫자가 아닙니다.");
    }

    @DisplayName("세자리수가 아닐시")
    @Test
    void checkNumberSize(){
        assertThatThrownBy(()-> {Number number = new Number("20");})
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("세자리수가 아닙니다.");
    }

    @DisplayName("올바른 입력시")
    @Test
    void properNumber(){
        Number test = new Number("123");
        Number result = new Number("123");
        assertThat(test).usingRecursiveComparison().isEqualTo(result);
    }

}
