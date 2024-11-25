import java.sql.*;

import java.util.Scanner;

public class Library {

    private static String dbUrl = "jdbc:mysql://localhost:3306/library";
    private static String dbUser = "root";
    private static String dbPassword = "P@ssw0rd";
    private static String className = "com.mysql.cj.jdbc.Driver";

    static Scanner scan = new Scanner(System.in);

    public static void addBookRequest() throws SQLException, ClassNotFoundException {

        System.out.println();

        System.out.print("Enter the book title: ");
        String title = scan.nextLine();

        System.out.print("Enter the author: ");
        String author = scan.nextLine();

        System.out.print("Enter the genre: ");
        String genre = scan.nextLine();

        System.out.println("Book added successfully!\n");

        Class.forName(className);

                String dbUrl = "jdbc:mysql://localhost:3306/library";
                String dbUser = "root";
                String dbPassword = "P@ssw0rd";

        String query = "INSERT INTO book_info(book_title, book_auther, book_genre)" +
                "VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Set parameters for the prepared statement
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, author);
            preparedStatement.setString(3, genre);

            // Execute the query
            preparedStatement.executeUpdate();
        }
    }

    public static void removeBookRequest() throws SQLException, ClassNotFoundException {
        System.out.println("Enter Title: ");
        String title = scan.nextLine();

        Class.forName(className);

        String query = "DELETE FROM book_info WHERE book_title='" + title + "'";

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Set parameters for the prepared statement


            // Execute the query
            preparedStatement.executeUpdate();
        }
    }

    public static void editDetails(){

    }

    public static void getByGenre(String genre) throws SQLException, ClassNotFoundException {
        Class.forName(className);

        String query = "SELECT book_genre, book_title, book_auther FROM book_info WHERE book_genre='" + genre + "'";



        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            ResultSet results = preparedStatement.executeQuery(query);

            System.out.println("Books from genre: " + genre);
            while (results.next()) {
                String title = results.getString("book_title");
                String author = results.getString("book_auther");
                String bookGenre = results.getString("book_genre");
                System.out.println(title + " | " + author + " | " + bookGenre);
            }
        }
    }
    public static void getByAuthor(String name) {

    }
}