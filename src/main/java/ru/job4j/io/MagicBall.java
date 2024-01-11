package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int answer = new Random().nextInt(3);
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        console.nextLine();
        String answerText = switch (answer) {
            case 1 -> "Да";
            case 2 -> "Нет";
            default -> "Может быть";
        };
        System.out.println(answerText);
    }
}
