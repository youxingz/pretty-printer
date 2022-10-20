package io.pretty.core;

import java.time.*;
import java.util.Date;
import java.util.List;

public class CommonDoc extends Doc {

    public CommonDoc(Object value, boolean flatten, int depth) {
        super(value, flatten, depth);
    }

    @Override
    public String toText() throws IllegalAccessException {
        if (value == null) {
            return new NullDoc(flatten, depth + 1).toText();
        } else if (value instanceof String) {
            return new StringDoc(value.toString(), flatten, depth + 1).toText();
        } else if (value instanceof Boolean) {
            return new BooleanDoc((Boolean) value, flatten, depth + 1).toText();
        } else if (value instanceof Number) {
            return new NumberDoc((Number) value, flatten, depth + 1).toText();
        } else if (value instanceof List) {
            return new ListDoc((List<Object>) value, flatten, depth + 1).toText();
        } else if (value instanceof Date
                || value instanceof LocalDate
                || value instanceof LocalDateTime
                || value instanceof LocalTime
                || value instanceof Instant
                || value instanceof Clock
                || value instanceof Duration
                || value instanceof MonthDay
                || value instanceof OffsetDateTime
                || value instanceof OffsetTime
                || value instanceof Period
                || value instanceof Year
                || value instanceof YearMonth
                || value instanceof ZonedDateTime
                || value instanceof ZoneId
                || value instanceof ZoneOffset) {
            return new DateDoc(value, flatten, depth + 1).toText();
        } else {
            return new ObjectDoc(value, flatten, depth + 1).toText();
        }
    }
}
