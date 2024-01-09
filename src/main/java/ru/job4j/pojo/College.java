package ru.job4j.pojo;

import java.time.LocalDate;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Петров Петр Петрович");
        student.setGroup("П21");
        student.setCreated(LocalDate.now());
        System.out.printf("Student %s, group %s, created %s", student.getFio(), student.getGroup(), student.getCreated());
    }
}
