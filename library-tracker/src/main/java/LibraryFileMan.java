
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class LibraryFileMan {
    private static String FILE_NAME = "library.csv";
    private int id;

    public static void overwriteFile(List<Book> library) {
        File file = new File(FILE_NAME);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, false))) {
            if (!file.exists() || file.length() == 0) {
                // Write the header row first
                writer.write("Title | Author | Genre ");
                writer.newLine();
            }

            for (Book book : library) {
                StringBuilder builder = new StringBuilder();
                builder.append(book.getTitle()).append(" | ");
                builder.append(book.getAuthor()).append(" | ");
                builder.append(book.getGenre());

                String result = builder.toString();
                writer.write(result);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void createFile(List<Book> library) {
        File file = new File(FILE_NAME);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            if (!file.exists() || file.length() == 0) {
                // Write the header row first
                writer.write("Title | Author | Genre ");
                writer.newLine();
            }

            for (Book book : library) {
                StringBuilder builder = new StringBuilder();
                builder.append(book.getTitle()).append(" | ");
                builder.append(book.getAuthor()).append(" | ");
                builder.append(book.getGenre());


                String result = builder.toString();
                writer.write(result);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static List<Book> readBooksFromFile() {

        List<Book> library = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            for(int i = 0; i < 1; i++){
                reader.readLine();
            }
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 3) {
                    String title = parts[0].trim();
                    String author = parts[1].trim();
                    String genre = parts[2].trim();

                    Book book = new Book(title, author, genre);
                    library.add(book);

                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return new ArrayList<>(); // Return an empty list in case of error
        }
        return library;
    }


}
