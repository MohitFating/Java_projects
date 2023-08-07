import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\nAuthor: " + author;
    }
}

class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }

    public void showAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books found!");
        } else {
            for (Book book : books) {
                System.out.println(book);
                System.out.println("-----------------------");
            }
        }
    }

    public void removeBook(String bookTitle) {
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(bookTitle)) {
                books.remove(book);
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Book removed successfully!");
        } else {
            System.out.println("Book not found!");
        }
    }
}

public class LibraryApp {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Book");
            System.out.println("2. Show All Books");
            System.out.println("3. Remove Book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character after reading the integer.

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String bookTitle = scanner.nextLine();
                    System.out.print("Enter author name: ");
                    String authorName = scanner.nextLine();
                    Book book = new Book(bookTitle, authorName);
                    library.addBook(book);
                    break;
                case 2:
                    library.showAllBooks();
                    break;
                case 3:
                    System.out.print("Enter book title to remove: ");
                    String bookToRemove = scanner.nextLine();
                    library.removeBook(bookToRemove);
                    break;
                case 4:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
            System.out.println();
        }
    }
}
