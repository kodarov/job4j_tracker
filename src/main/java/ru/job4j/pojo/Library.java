package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Head First Java", 500);
        Book book2 = new Book("Effective Java", 400);
        Book book3 = new Book("Thinking in Java", 1000);
        Book book4 = new Book("Clean code ", 450);
        Book[] books = {book1, book2, book3, book4};
        for (int i = 0; i < books.length; i++) {
            System.out.printf("Book - %s, pages - %d \n", books[i].getName(), books[i].getPages());
        }
        System.out.println();
        Book tmp = books[0];
        books[0] = books[3];
        books[3] = tmp;
        for (int i = 0; i < books.length; i++) {
            System.out.printf("Book - %s, pages - %d \n", books[i].getName(), books[i].getPages());
        }
        System.out.println();
        for (int i = 0; i < books.length; i++) {
            if ("Clean code".equals(books[i].getName())) {
                System.out.println(books[i]);
            }
        }
    }
}
