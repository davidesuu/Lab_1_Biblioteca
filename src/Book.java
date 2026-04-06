public class Book {
    private String name;
    private String author;
    private String edition;
    private boolean isBorrowed;

    public Book(String name, String author, String edition) {
        this.name = name;
        this.author = author;
        this.edition = edition;
        this.isBorrowed = false;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getEdition() {
        return edition;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }

    @Override
    public String toString() {
        return "Titulo: " + this.name +
                "\nAutor: " + this.author +
                "\nEdicao: " + this.edition +
                "\nEmprestado: " + this.isBorrowed;
    }
}