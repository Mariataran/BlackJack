package com.company;

/**
 * Created by student2 on 14.11.16.
 */
public abstract class Player {
    Hand hand = new Hand();
    private Intellect intellect;

    public Player(Intellect intellect) {
        this.intellect = intellect;
    }

    public void take(Card current) {
        hand.add(current);
    }

    public Command decision() {
        return intellect.decide();
    }
}
