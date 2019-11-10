/**
 * CS 152 Lab 7 - Book
 * 2019/4/14
 * Ilham Babajanov
 */

public class Book {


    private int publicationYear;
    private String title, isbn;
    private Author auth;

    /**
     * The default (no parameters) constructor, creates a new Book with no
     * title, year of publication, Author, or ISBN set.
     */
    public Book() {
        this.title = AuthorBookConstants.UNKNOWN_TITLE;
        this.publicationYear = AuthorBookConstants.UNKNOWN_YEAR;
        this.auth = AuthorBookConstants.UNKNOWN_AUTHOR;
        this.isbn = AuthorBookConstants.UNKNOWN_ISBN;
    }

    /**
     * Creates a new Book with a title, but no year of publication, Author,
     * or ISBN set.
     * @param title
     */
    public Book(String title) {
        this.title = title;
        this.publicationYear = AuthorBookConstants.UNKNOWN_YEAR;
        this.auth = AuthorBookConstants.UNKNOWN_AUTHOR;
        this.isbn = AuthorBookConstants.UNKNOWN_ISBN;
    }

    /**
     * Creates a new Book with a title and an Author (as an Author object)
     * but no year of publication or ISBN set.
     * @param title
     * @param author
     */
    public Book(String title, Author author) {
        this.title = title;
        this.auth = author;
        this.publicationYear = AuthorBookConstants.UNKNOWN_YEAR;
        this.isbn = AuthorBookConstants.UNKNOWN_ISBN;
    }

    /**
     * Sets the book’s title. Title must not be empty.
     * @param title
     */
    public void setTitle(String title) {
        if (title.isEmpty()){
            System.out.println("Invalid title.");
        } else {
            this.title = title;
        }
    }

    /**
     * Returns a String representing the book’s title.
     * @return a String for the book's title.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Sets the Author object.
     * @param author
     */
    public void setAuthor(Author author) {
        this.auth = author;
    }

    /**
     * Returns the Author object for the author who wrote the book.
     * @return the Author.
     */
    public Author getAuthor() {
        return this.auth;
    }

    /**
     * Sets the year the book was written/published. It must be a valid year.
     * @param year
     */
    public void setPublicationYear(int year) {
        if (year > -2000  && year <2024 && year != 0) {
            this.publicationYear = year;
        } else {
            System.out.println("Invalid Publication Year.");
        }
    }

    /**
     * Returns the publication year of the book.
     * @return publication year.
     */
    public int getPublicationYear() {
        return this.publicationYear;
    }

    /**
     * Sets the ISBN for the book. This must be of length 13 or length 10.
     * @param isbn
     */
    public void setIsbn(String isbn) {
        if (isbn.length() == 10 || isbn.length() == 13){
            this.isbn = isbn;
        } else {
            System.out.println("Invalid ISBN.");
        }
    }

    /**
     * Returns a String representing the ISBN of the book.
     * @return a String for the ISBN.
     */
    public String getIsbn() {
        return this.isbn;
    }

    /**
     * Returns true if this book has the same Author as the book
     * that was passed in in the arguments, otherwise returns false.
     * @param other
     * @return true or false.
     */
    public boolean sameAuthor(Book other) {
        if (this.auth.hasSameName(other.auth)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns true if this book is equal to the other book.
     * We will say that two Book objects are equal if their ISBNs are equal.
     * @param other
     * @return true or false.
     */
    public boolean equals(Book other) {
        if (this.isbn.equals(other.isbn))  {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns a String representation of this Book.
     * If only a title has been set, returns a string of the form:
     * "The Arcades Project."
     * If a title and author are set:
     * "The Arcades Project. Benjamin, Walter."
     * If a title and author and year have been set:
     * "The Arcades Project (2002). Benjamin, Walter."
     * @return a String representation of this Book.
     */
    public String toString() {
        if (this.auth != AuthorBookConstants.UNKNOWN_AUTHOR &&
            this.publicationYear != AuthorBookConstants.UNKNOWN_YEAR) {
            return (this.title + " ("+ this.publicationYear+ "). " +
                    this.auth.toString() + ".");
        } else if (this.auth != AuthorBookConstants.UNKNOWN_AUTHOR) {
            return (this.title + ". " + this.auth.toString() + ".");
        } else {
            return (this.title + ".");
        }
    }

}
