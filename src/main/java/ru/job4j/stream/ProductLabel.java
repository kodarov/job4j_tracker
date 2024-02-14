package ru.job4j.stream;

import java.util.List;

public class ProductLabel {
    public List<String> generateLabels(List<Product> products) {
        return products.stream()
                .filter(e -> e.getStandard() - e.getActual() >= 0)
                .filter(e -> e.getStandard() - e.getActual() <= 3)
                .map(e -> new Label(e.getName(), e.getPrice() / 2))
                .map(Label::toString)
                .toList();
    }
}