package ru.job4j.stream;

import ru.job4j.record.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceExample {
    public static void main(String[] args) {
        /**
         * reduce(BinaryOperator<T> accumulator) -  стандартный вариант метода reduce()
         */
        List<Integer> numbers = List.of(1, 2, 3, 4);
        Optional<Integer> sum1 = numbers.stream()
                .reduce((left, right) -> left + right);
        System.out.println(sum1.get());
        /**
         * reduce(T identity, BinaryOperator<T> accumulator)
         * identity - задаем свой первый элемент по умолчанию
         */
        List<String> nums = List.of("Один", "Два", "Три");
        Optional<String> sum2 = nums.stream()
                .reduce((left, right) -> left + ", " + right);
        System.out.println(sum2.get());
        /**
         * reduce (U identity, BiFunction<U, ? super T,U> accumulator, BinaryOperator<U> combiner)
         * расширенная версия второй формы
         * accumulator здесь позволяет выполнить промежуточное действие над элементами потока
         */
        List<Person> people = Arrays.asList(
                new Person("Михаил", 35),
                new Person("Ольга", 26),
                new Person("Антон", 20),
                new Person("Виктор", 16),
                new Person("Анна", 29)
        );
        int sum = people.stream()
                .reduce(
                        0,
                        (left, right) -> {
                            if (right.getAge() > 25) {
                                return left + right.getAge();
                            } else {
                                return left;
                            }
                        },
                        (left, right) -> left + right
                );
        System.out.println(sum);
        /**
         * Полноценная работа этой версии метода reduce(), а точнее работа combiner
         * в многопоточности
         */
        int min = people.parallelStream()
                .reduce(
                        0,
                        (left, right) -> left + right.getAge(),
                        Integer::min
                );
        System.out.println(min);
    }
}