package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder onePartText = new StringBuilder();
        boolean flag = true;
        while (!evenElements.isEmpty()) {
            if (flag) {
                onePartText.append(evenElements.pollFirst());
            } else {
                evenElements.pollFirst();
            }
            flag = !flag;
        }
        System.out.println(onePartText);
        return onePartText.toString();
    }

    private String getDescendingElements() {
        StringBuilder twoPartText = new StringBuilder();
        int size = descendingElements.size();
        for (int i = 0; i < size; i++) {
            twoPartText.append(descendingElements.pollLast());
        }
        return twoPartText.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}