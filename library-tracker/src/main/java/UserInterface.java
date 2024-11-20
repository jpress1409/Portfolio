import java.util.List;
import java.util.Scanner;

public class UserInterface {

    public static void display(Scanner scan) {

        List<Book> library = LibraryFileMan.readBooksFromFile();
        int choice = 0;

        while(choice != 5) {
        System.out.println("What would you like to do: ");
        System.out.println("(1) Add Book");
        System.out.println("(2) Remove Book");
        System.out.println("(3) Search by Genre");
        System.out.println("(5) Exit");

        choice = scan.nextInt();

        switch (choice) {
            case 1 -> {
                int loop = 0;
                while(loop != 1) {

                    Book book = Library.addBookRequest();
                    library.add(book);
                    System.out.println("(1) Exit");
                    System.out.println("(2) Add Another");
                    loop = scan.nextInt();

                }
                LibraryFileMan.createFile(library);
            }
            case 2 -> {
                Library.removeBookRequest(library);
                LibraryFileMan.overwriteFile(library);
            }
            case 3 -> {
                System.out.println("Enter Genre: ");
                String genre = scan.nextLine();
                Library.getByGenre(genre);
            }
            case 4 -> {
                System.out.println("Enter Author: ");
                String name = scan.nextLine();
                Library.getByAuthor(name);
            }
            case 5 -> System.out.println("Bye");
            default -> System.out.println("Invalid Selection");
        }
        }
    }


}
