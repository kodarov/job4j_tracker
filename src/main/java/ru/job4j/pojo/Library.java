package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Head First Java", 500);
        Book book2 = new Book("Effective Java", 400);
        Book book3 = new Book("Thinking in Java", 1000);
        Book book4 = new Book("Clean code ", 450);
        Book[] books = {book1, book2, book3, book4};
        String ln = System.lineSeparator();
        for (Book book : books) {
            System.out.printf("Book - %s, pages - %d" + ln, book.getName(), book.getPages());
        }
        System.out.println();
        Book tmp = books[0];
        books[0] = books[3];
        books[3] = tmp;
        for (Book book : books) {
            System.out.printf("Book - %s, pages - %d" + ln, book.getName(), book.getPages());
        }
        System.out.println();
        for (Book book : books) {
            if ("Clean code".equals(book.getName())) {
                System.out.println(book);
            }
        }
    }
}
