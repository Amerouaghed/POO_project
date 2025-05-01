import java.time.LocalDate;

// صنف يمثل عملية الإعارة
public class BorrowingProcess {
    private Book book;             // الكتاب الذي تم استعارته
    private Borrower borrower;     // المستعير
    private LocalDate borrowDate;  // تاريخ الإعارة
    private LocalDate returnDate;  // تاريخ الاسترجاع

    public BorrowingProcess(Book book, Borrower borrower) {
        this.book = book;
        this.borrower = borrower;
        this.borrowDate = LocalDate.now();
    }

    public void returnBook() {
        this.returnDate = LocalDate.now();
        borrower.returnBook(book);
    }
}