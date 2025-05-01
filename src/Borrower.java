import java.util.ArrayList;

// صنف يمثل المستعير
public class Borrower {
    private String name;                 // اسم المستعير
    private String studentID;            // رقم الطالب الجامعي
    private ArrayList<Book> borrowedBooks; // قائمة الكتب المستعارة

    public Borrower(String name, String studentID) {
        this.name = name;
        this.studentID = studentID;
        this.borrowedBooks = new ArrayList<>();
    }

    public void borrowBook(Book book) {
        if (!book.isBorrowed()) {
            borrowedBooks.add(book);
            book.borrowBook();
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.returnBook();
        }
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return studentID;
    }

    public void listBorrowedBooks() {
        System.out.println("الكتب المستعارة من طرف " + name + ":");
        for (Book book : borrowedBooks) {
            System.out.println("- " + book.getInfo());
        }
    }
}