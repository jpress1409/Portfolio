import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Book {
    private String title;
    private String author;
    private String genre;
    private LocalDate today;
    private String date;
    private int id;

    public Book(String title, String author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.id = id;

    }

    public int setId(){


        return id;
    }
    public String getDate(){
        LocalDate today = LocalDate.now();
        SimpleDateFormat format = new SimpleDateFormat("MMM d, yyyy");
        date = format.format(today);

        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }



    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre +

                '}';
    }
}
