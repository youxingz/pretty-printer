package io.pretty;

import io.pretty.example.Friend;
import io.pretty.example.User;
import org.junit.Test;

import java.time.*;
import java.util.Arrays;
import java.util.Date;

public class PrettyTest {
    @Test
    public void test1() {
        // string:
        Pretty.print("Hi there! This is Pretty-Printer!😉");
        // boolean:
        Pretty.print(false);
        Pretty.print(true);
        // number:
        Pretty.print(1);
        // null:
        Pretty.print(null);
        // list:
        Pretty.print(Arrays.asList(1, 2, 3, 4, 5, 6));
        // object:
        User tom = new User("Tom", "https://io.youxingz/images/avatar_a.png", 17, 1.82f, "How is it going");
        User john = new User("John", "https://io.youxingz/images/avatar_b.png", 18, 1.76f, "I am fine, thank you");
        Friend friend = new Friend(tom, john);
        Pretty.print(friend);
        // list of objects:
        Pretty.print(Arrays.asList(tom, tom, tom));
        // date:
        Pretty.print(new Date());
        Pretty.print(Clock.systemDefaultZone());
        Pretty.print(Duration.ofDays(1000));
        Pretty.print(Instant.now());
        Pretty.print(LocalDate.now());
        Pretty.print(LocalDateTime.now());
        Pretty.print(LocalTime.now());
        Pretty.print(MonthDay.now());
        Pretty.print(OffsetDateTime.now());
        Pretty.print(OffsetTime.now());
        Pretty.print(Period.ofYears(2022));
        Pretty.print(Year.now());
        Pretty.print(YearMonth.now());
        Pretty.print(ZonedDateTime.now());
        Pretty.print(ZoneId.systemDefault());
        Pretty.print(ZoneOffset.ofHours(8));
    }
}
