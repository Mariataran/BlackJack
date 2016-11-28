package com.company;

/**
 * Created by student2 on 14.11.16.
 */
public abstract class Player {
    Hand hand = new Hand();
    private Intellect intellect;
    private Better better;
    String name;
    Condition condition = Condition.PLAYING;
    Integer balance;

    public Player(Intellect intellect, Better better, String name, Integer balance) {
        this.intellect = intellect;
        this.name = name;
        this.better = better;
        this.balance = balance;
    }

    public void take(Card current) {
        hand.add(current);
    }

    public Command decision() {
        int score = hand.getScore();
        if (score > 21) {
            return Command.STAND;
        }
        return this.intellect.decide(score);
    }

    public void makeBet(Hand hand) {
        hand.bet += this.better.makeBet();
    }
}
