import java.util.ArrayList;
import java.util.Scanner;

// هذا هو الصنف الرئيسي الذي يحتوي على واجهة المستخدم
public class LibraryApp {
    private static ArrayList<Book> books = new ArrayList<>();
    private static ArrayList<Borrower> borrowers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean run = true;

        while (run) {
            System.out.println("\n--- نظام إدارة المكتبة ---");
            System.out.println("1. إضافة كتاب");
            System.out.println("2. إضافة مستعير");
            System.out.println("3. إعارة كتاب");
            System.out.println("4. استرجاع كتاب");
            System.out.println("5. عرض الكتب المستعارة من طرف مستعير");
            System.out.println("6. خروج");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("العنوان: ");
                    String title = input.nextLine();
                    System.out.print("المؤلف: ");
                    String author = input.nextLine();
                    System.out.print("ISBN: ");
                    String isbn = input.nextLine();
                    System.out.print("النوع (ورقي/إلكتروني): ");
                    String type = input.nextLine();
                    books.add(new Book(title, author, isbn, type));
                    System.out.println("تمت إضافة الكتاب.");
                }
                case 2 -> {
                    System.out.print("اسم المستعير: ");
                    String name = input.nextLine();
                    System.out.print("رقمه الجامعي: ");
                    String id = input.nextLine();
                    borrowers.add(new Borrower(name, id));
                    System.out.println("تمت إضافة المستعير.");
                }
                case 3 -> {
                    System.out.print("رقم ISBN للكتاب: ");
                    String isbn = input.nextLine();
                    System.out.print("رقم المستعير: ");
                    String id = input.nextLine();

                    Book book = findBook(isbn);
                    Borrower borrower = findBorrower(id);
                    if (book != null && borrower != null && !book.isBorrowed()) {
                        borrower.borrowBook(book);
                        System.out.println("تمت عملية الإعارة.");
                    } else {
                        System.out.println("فشل في الإعارة.");
                    }
                }
                case 4 -> {
                    System.out.print("رقم ISBN للكتاب: ");
                    String isbn = input.nextLine();
                    Book book = findBook(isbn);
                    if (book != null && book.isBorrowed()) {
                        book.returnBook();
                        System.out.println("تم الاسترجاع.");
                    } else {
                        System.out.println("الكتاب غير معار.");
                    }
                }
                case 5 -> {
                    System.out.print("رقم المستعير: ");
                    String id = input.nextLine();
                    Borrower borrower = findBorrower(id);
                    if (borrower != null) {
                        borrower.listBorrowedBooks();
                    } else {
                        System.out.println("لم يتم العثور على المستعير.");
                    }
                }
                case 6 -> run = false;
            }
        }
    }

    public static Book findBook(String isbn) {
        for (Book book : books)
            if (book.getISBN().equals(isbn))
                return book;
        return null;
    }

    public static Borrower findBorrower(String id) {
        for (Borrower b : borrowers)
            if (b.getID().equals(id))
                return b;
        return null;
    }
}