package LibraryProject.library;

import LibraryProject.library.exceptions.*;
import LibraryProject.library.models.*;
import LibraryProject.library.services.LibraryManager;

public class LibraryApp {
    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();

        // 1. Initialize Data
        manager.addBook(new Book("101", "Java Core", "James Gosling"));
        manager.addBook(new Book("102", "Clean Code", "Robert Martin"));
        manager.registerMember(new Member(1, "Alice"));

        // 2. Execute Logic with Exception Handling
        try {
            System.out.println("--- Test 1: Successful Borrow ---");
            manager.issueBook("101", 1);
            
            System.out.println("\n--- Test 2: Borrowing same book again ---");
            manager.issueBook("101", 1); // This should throw AlreadyBorrowedException

        } catch (BookNotFoundException | AlreadyBorrowedException e) {
            System.out.println("CAUGHT ERROR: " + e.getMessage());
        }

        try {
            System.out.println("\n--- Test 3: Borrowing non-existent book ---");
            manager.issueBook("999", 1); // This should throw BookNotFoundException
        } catch (Exception e) {
            System.out.println("CAUGHT ERROR: " + e.getMessage());
        }

        manager.displayStatus();
    }
}