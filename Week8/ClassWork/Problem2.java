import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Problem2{
    public static final LocalDate CURRENT_DATE = LocalDate.of(2023, 10, 26);
    public static final DateTimeFormatter DATE_FORMAT =
            DateTimeFormatter.ISO_LOCAL_DATE;

    private static class Library {
        final String type;
        final String title;

        Library(String type, String title) {
            this.type = type;
            this.title = title;
        }
    }

    public static void main(String[] args) {
        Library[] borrowedItems = {
            new Library("BOOK", "1984"),
            new Library("DVD", "The Matrix"),
            new Library("MAGAZINE", "Forbes Issue 500")
        };

        for (Library item : borrowedItems) {
            int days;

            switch (item.type) {
                case "BOOK":
                    days = 14;
                    break;
                case "DVD":
                    days = 7;
                    break;
                case "MAGAZINE":
                    days = 3;
                    break;
                default:
                    days = 0;
            }

            LocalDate dueDate = CURRENT_DATE.plusDays(days);
            System.out.println(item.title + ": " + dueDate.format(DATE_FORMAT));
        }
    }
}
