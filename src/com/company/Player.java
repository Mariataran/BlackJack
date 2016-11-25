package com.company;

/**
 * Created by student2 on 14.11.16.
 */
public abstract class Player {
    Hand hand = new Hand();
    private Intellect intellect;
    String name;
    Condition condition = Condition.PLAYING;

    public Player(Intellect intellect, String name) {
        this.intellect = intellect;
        this.name = name;
    }

    public void take(Card current) {
        hand.add(current);
    }

    public Command decision() {
        int score = hand.getScore();
        if (score > 21) {
            return Command.STAND;
        }
        return intellect.decide(score);
    }
}
