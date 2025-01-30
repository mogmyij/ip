import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.LocalDateTime;

public class DateTimeUtil {
    private static DateTimeFormatter formater = new DateTimeFormatterBuilder()
            .parseCaseInsensitive()                              // Allows "T" or "t" in ISO format
            .appendPattern("[dd/MM/yyyy][yyyy-MM-dd][dd-MM-yyyy][yyyy/MM/dd]")          // Supports both date formats
            .optionalStart()                                     // Everything after this is optional
            .appendLiteral(' ')                                 // Space between date and time
            .appendPattern("HH:mm")                            // Hours and minutes
            .optionalStart()
            .appendLiteral(':')                                // Optional seconds separator
            .appendPattern("ss")                               // Optional seconds
            .optionalEnd()
            .optionalEnd()
            .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)      // If time is missing, use 00
            .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)   // If minutes missing, use 00
            .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0) // If seconds missing, use 00
            .toFormatter();

    public static  DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public static LocalDateTime parseDateTime(String dateTime) {
        return LocalDateTime.parse(dateTime.trim(), formater);
    }

    public static String localDateTimeToString(LocalDateTime dateTime) {
        return dateTime.format(outputFormatter);
    }

}
