package com.example.blog.config;

        import org.springframework.context.annotation.Configuration;
        import org.springframework.format.Formatter;

        import java.text.FieldPosition;
        import java.text.Format;
        import java.text.ParseException;
        import java.text.ParsePosition;
        import java.time.LocalDate;
        import java.time.format.DateTimeFormatter;
        import java.time.format.DateTimeParseException;
        import java.util.Locale;

@Configuration
public class LocalDateFormatString implements Formatter<LocalDate> {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    @Override
    public LocalDate parse(String text, Locale locale) throws ParseException {
        try {
            return LocalDate.parse(text, formatter);
        } catch (DateTimeParseException e) {
            throw new ParseException("Invalid date format", e.getErrorIndex());
        }
    }
    @Override
    public String print(LocalDate object, Locale locale) {
        return object.format(formatter);
    }

}
