package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Активен: " + active);
        System.out.println("Номер: " + status);
        System.out.println("Описание: " + message);
    }

    public static void main(String[] args) {
        Error error = new Error(true, 404, "страница не найдена");
        error.printInfo();
    }
}
