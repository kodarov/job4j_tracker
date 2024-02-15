package ru.job4j.stream;

import java.util.stream.Stream;

public class Card implements Comparable<Card> {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public static void main(String[] args) {
        Stream.of(Suit.values())
                .flatMap(suit -> Stream.of(Value.values())
                        .map(value -> new Card(suit, value)))
                .sorted()
                .forEach(System.out::println);
    }

    @Override
    public int compareTo(Card o) {
        return value.compareTo(o.value);
    }

    @Override
    public String toString() {
        return "Card{"
                + "suit="
                + suit + ", value="
                + value
                + '}';
    }
}
