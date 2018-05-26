package pl.narodzinyprrogramsity.model;

public enum BookType {
    FANTASY("fantasy"), COMICS("comics"), DEFAULT("default");

    private String type;

    BookType(String name) {
        this.type = name;
    }

    public static BookType parseType(String type) {
        if (type.equals(FANTASY.type)) {
            return FANTASY;
        } else if (type.equals(COMICS.type)) {
            return COMICS;
        }else {
            return DEFAULT;
        }
    }

    @Override
    public String toString() {
        return "BookType{" +
                "type='" + type + '\'' +
                '}';
    }
}
