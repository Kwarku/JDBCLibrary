package pl.narodzinyprrogramsity.model;

public class Author extends BaseModel {
    public static final String AUTHOR_TABLE = ".AUTHORS";
    public static final String AUTHOR_ID_COLUMN = "AUTHOR_ID";
    public static final String FIRST_NAME_COLUMN = "FIRST_NAME";
    public static final String LAST_NAME_COLUMN = "LAST_NAME";
    public static final String YEAR_OF_BIRTH_COLUMN = "YEAR_OF_BIRTH";

    private String firstName;
    private String lastName;
    private int yearOfBirth;

    public Author(String authorId, String firstName, String lastName, int yearOfBirth) {
        super(authorId);
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    @Override
    public String toString() {
        return "Author{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", id='" + id + '\'' +
                '}';
    }
}

