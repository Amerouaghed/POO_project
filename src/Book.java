// صنف يمثل الكتاب داخل نظام المكتبة
public class Book {
    private String title;         // عنوان الكتاب
    private String author;        // اسم المؤلف
    private String ISBN;          // رقم التعريف الدولي
    private boolean isBorrowed;   // هل هو معار؟
    private String type;          // نوع الكتاب (ورقي أو إلكتروني)

    public Book(String title, String author, String ISBN, String type) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.type = type;
        this.isBorrowed = false;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrowBook() {
        this.isBorrowed = true;
    }

    public void returnBook() {
        this.isBorrowed = false;
    }

    public String getInfo() {
        return title + " - " + author + " (ISBN: " + ISBN + ") - " + (isBorrowed ? "معار" : "متوفر") + " - " + type;
    }

    public String getISBN() {
        return ISBN;
    }
}