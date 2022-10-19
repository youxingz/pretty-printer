package io.pretty;

import io.pretty.example.Friend;
import io.pretty.example.User;
import org.junit.Test;

import java.util.Arrays;

public class PrettyTest {
    @Test
    public void test1() {
        User tom = new User("Tom", "https://io.xx/images/avatar_123.png", 17, 1.82f, "How is it going");
        User john = new User("John", "https://io.xx/images/avatar_123.png", 18, 1.76f, "I am fine, thank you");
        Friend friend = new Friend(tom, john);
        Pretty.print(friend);
        Pretty.print("demo");
        Pretty.print(false);
        Pretty.print(true);
        Pretty.print(1);
        Pretty.print(null);
        Pretty.print(Arrays.asList(1, 2, 3));
        Pretty.print(Arrays.asList(tom, tom, tom));
    }
}
