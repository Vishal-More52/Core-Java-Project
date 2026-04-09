package LibraryProject.library.models;

import java.util.ArrayList;
import java.util.List;

public class Member {
  private int id;
  private String name;
  private List<Book> borrowedBooks;

    public Member(int id, String name) {
        this.id = id;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    @Override
    public String toString(){
      return "Member [id=" + id + ", name=" + name + ", borrowedBooks=" + borrowedBooks + "]";
    }
    




}
