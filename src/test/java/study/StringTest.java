package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @DisplayName("split 테스트")
    @Test
    void split_test1() {
        String str = "1,2";
        assertThat(str.split(",")).containsExactly("1", "2");

        String str2 = "1";
        assertThat(str2.split(",")).containsExactly("1");
    }

    @DisplayName("subString 테스트")
    @Test
    void substring_test1() {
        String str = "(1,2)";
        assertThat(str.substring(1, str.length() - 1)).isEqualTo("1,2");
    }

    @DisplayName("charAt 테스트")
    @Test
    void charAt_test1() {
        String str = "abc";
        assertThat(str.charAt(0)).isEqualTo('a');
        assertThat(str.charAt(1)).isEqualTo('b');
        assertThat(str.charAt(2)).isEqualTo('c');
        assertThatThrownBy( () -> str.charAt(3)).isInstanceOf(StringIndexOutOfBoundsException.class);
    }


}
