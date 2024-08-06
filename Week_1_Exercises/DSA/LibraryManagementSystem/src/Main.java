// Main.java
package library;

public class Main {

    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book(1, "The Great Gatsby", "F. Scott Fitzgerald");
        Book book2 = new Book(2, "1984", "George Orwell");
        Book book3 = new Book(3, "To Kill a Mockingbird", "Harper Lee");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        System.out.println("Linear Search:");
        System.out.println(library.findBookByTitleLinear("1984"));

        library.sortBooksByTitle();
        System.out.println("Binary Search:");
        System.out.println(library.findBookByTitleBinary("1984"));
    }
}
