package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PhoneDictionary {
    private List<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     *
     * @param key Ключ поиска.
     * @return Список пользователей, которые прошли проверку.
     */
    public List<Person> find(String key) {
        var result = new ArrayList<Person>();
        Predicate<Person> predicateName = e -> e.getName().contains(key);
        Predicate<Person> predicateSurname = e -> e.getSurname().contains(key);
        Predicate<Person> predicatePhone = e -> e.getPhone().contains(key);
        Predicate<Person> predicateAddress = e -> e.getAddress().contains(key);
        Predicate<Person> combine = predicateName
                .or(predicateSurname)
                .or(predicatePhone)
                .or(predicateAddress);
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}