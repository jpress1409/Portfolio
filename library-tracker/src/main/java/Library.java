import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {

    static Scanner scan = new Scanner(System.in);

    public static Book addBookRequest(){

        System.out.println();

        System.out.print("Enter the book title: ");
        String title = scan.nextLine();

        System.out.print("Enter the author: ");
        String author = scan.nextLine();

        System.out.print("Enter the genre: ");
        String genre = scan.nextLine();

        Book book = new Book(title, author, genre);

        System.out.println("Book added successfully!\n");

        return book;
    }

    public static void removeBookRequest(List<Book> library){
        System.out.println("Enter Title: ");
        String title = scan.nextLine();

        boolean found = false;

        for(Book book : library){
            if(book.getTitle().equalsIgnoreCase(title)){
                System.out.println(book.getTitle() + " removed");
                library.remove(book);
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("Book not found");
        }
    }

    public static void getByGenre(String genre){

        List<Book> library = LibraryFileMan.readBooksFromFile();

        for(Book book : library){
            if(book.getGenre().contains(genre)){
                System.out.println(book);
            }
        }
    }
    public static void getByAuthor(String name){

        List<Book> library = LibraryFileMan.readBooksFromFile();

        for(Book book : library){
            if(book.getAuthor().contains(name)){
                System.out.println(book);
            }
        }
    }
}