package pl.narodzinyprrogramsity.model;

public class Book extends BaseModel {
    public static final String BOOK_TABLE = ".BOOK";
    public static final String BOOK_NAME_COLUMN = "BOOK_NAME";
    public static final String BOOK_TYPE_COLUMN = "BOOK_TYPE";
    public static final String AUTHOR_ID_COLUMN= "AUTHOR_ID_COLUMN";

    private String name;
    private String authorId;
    private BookType bookType;

    public Book(String bookID, String name, String authorId, BookType bookType) {
        super(bookID);
        this.name = name;
        this.authorId = authorId;
        this.bookType = bookType;
    }

    public String getName() {
        return name;
    }

    public String getAuthorId() {
        return authorId;
    }

    public BookType getBookType() {
        return bookType;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", authorId='" + authorId + '\'' +
                ", bookType=" + bookType +
                ", id='" + id + '\'' +
                '}';
    }
}
