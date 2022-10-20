package io.pretty.core;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateDoc extends Doc {
    private static final DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.ms");
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

    public DateDoc(Object value, boolean flatten, int depth) {
        super(value, flatten, depth);
    }

    @Override
    public String toText() {
        if (value instanceof Date) {
            return Color.YELLOW_BOLD_BRIGHT + formatter.format(value) + Color.RESET;
        } else if (value instanceof LocalDate) {
            return Color.YELLOW_BOLD_BRIGHT + dateFormatter.format((LocalDate) value) + Color.RESET;
        } else if (value instanceof LocalDateTime) {
            return Color.YELLOW_BOLD_BRIGHT + dateTimeFormatter.format((LocalDateTime) value) + Color.RESET;
        } else if (value instanceof LocalTime) {
            return Color.YELLOW_BOLD_BRIGHT + timeFormatter.format((LocalTime) value) + Color.RESET;
        } else if (value instanceof Instant) {
            return Color.YELLOW_BOLD_BRIGHT + value + Color.RESET;
        } else if (value instanceof Duration) {
            return Color.YELLOW_BOLD_BRIGHT + "Duration[" + value + "]" + Color.RESET;
        } else if (value instanceof MonthDay) {
            return Color.YELLOW_BOLD_BRIGHT + "MonthDay[" + value + "]" + Color.RESET;
        } else if (value instanceof Period) {
            return Color.YELLOW_BOLD_BRIGHT + "Period[" + value + "]" + Color.RESET;
        } else if (value instanceof Year) {
            return Color.YELLOW_BOLD_BRIGHT + "Year[" + value + "]" + Color.RESET;
        } else if (value instanceof YearMonth) {
            return Color.YELLOW_BOLD_BRIGHT + "YearMonth[" + value + "]" + Color.RESET;
        } else if (value instanceof ZoneOffset) {
            return Color.YELLOW_BOLD_BRIGHT + "ZoneOffset[" + value + "]" + Color.RESET;
        } else if (value instanceof ZoneId) {
            return Color.YELLOW_BOLD_BRIGHT + "Zone[" + value + "]" + Color.RESET;
        }
        // default: unknown date type
        return Color.YELLOW_BOLD_BRIGHT + value.toString() + Color.RESET;
    }
}
