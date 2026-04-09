package LibraryProject.library.services;

import LibraryProject.library.exceptions.*;
import LibraryProject.library.models.*;
import java.util.*;


public class LibraryManager {
    private final Map<String, Book> books = new HashMap<>(); // O(1) Search
    private final List<Member> members = new ArrayList<>();

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    public void registerMember(Member member) {
        members.add(member);
    }

    // The Logic: Issue a book
    public void issueBook(String isbn, int memberId) 
            throws BookNotFoundException, AlreadyBorrowedException {
        
        Book book = books.get(isbn);
        if (book == null) throw new BookNotFoundException("Book ISBN " + isbn + " not found.");

        if (!book.isAvailable()) {
            throw new AlreadyBorrowedException("Book '" + book.getTitle() + "' is already out.");
        }

        Member member = findMemberById(memberId);
        if (member == null) {
            System.out.println("Member ID " + memberId + " not found.");
            return;
        }

        // State Change Logic
        book.setIsAvailable(false);
        member.getBorrowedBooks().add(book);
        System.out.println("LOGIC SUCCESS: " + book.getTitle() + " issued to " + member.getName());
    }

    public void returnBook(String isbn, int memberId) 
            throws BookNotFoundException {
        
        Book book = books.get(isbn);
        if (book == null) throw new BookNotFoundException("Book ISBN " + isbn + " not found.");

        Member member = findMemberById(memberId);
        if (member == null) {
            System.out.println("Member ID " + memberId + " not found.");
            return;
        }

        if (!member.getBorrowedBooks().contains(book)) {
            System.out.println("Book not borrowed by this member.");
            return;
        }

        // State Change Logic
        book.setIsAvailable(true);
        member.getBorrowedBooks().remove(book);
        System.out.println("LOGIC SUCCESS: " + book.getTitle() + " returned by " + member.getName());
    }

    private Member findMemberById(int id) {
        for (Member m : members) {
            if (m.getId() == id) return m;
        }
        return null;
    }

    public void displayStatus() {
        System.out.println("\n--- Current Library Status ---");
        books.values().forEach(System.out::println);
    }
}