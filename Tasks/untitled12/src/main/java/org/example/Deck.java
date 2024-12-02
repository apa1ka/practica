package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Integer> cards;

    public Deck() {
        cards = new ArrayList<>();
        for (int i = 1; i <= 13; i++) {
            for (int j = 0; j < 4; j++) {
                cards.add(i);
            }
        }
        Collections.shuffle(cards);
    }

    public int drawCard() {
        return cards.remove(0);
    }

    public boolean hasNext() {
        return !cards.isEmpty();
    }
}

