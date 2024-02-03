package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        Map<String, String> emails = new HashMap<>();
        emails.put("kodarov@gmail.com", "Kodarov Salavat");
        emails.put("kodarov@gmail.com", "Kodarov Salavat Salamatovich");
        emails.put("petrovpp@gmail.com", "Petrov Petr Petrovich");
        for (String email : emails.keySet()) {
            System.out.format("E-mail: %s - %s" + System.lineSeparator(), email, emails.get(email));
        }
        System.out.println();
        emails.remove("kodarov@gmail.com");
        for (Map.Entry<String, String> entry : emails.entrySet()) {
            System.out.format("E-mail: %s - %s" + System.lineSeparator(), entry.getKey(), entry.getValue());
        }
    }
}
