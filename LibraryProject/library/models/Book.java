package LibraryProject.library.models;

public class Book {
  
  private final String isbn;
  private final String title;
  private final String author;
  private boolean isAvailable;

  public Book(String isbn, String title, String author){
    this(isbn, title, author, true);
  }

  public Book(String isbn, String title, String author,boolean isAvailable){
    this.isbn = isbn;
    this.title = title;
    this.author = author;
    this.isAvailable = isAvailable;
  }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
