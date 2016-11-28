package com.company;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by student2 on 28.11.16.
 */
public class Table {
    Player player;
    Dealer dealer;
    List<Player> players;

    public Table() {
        players = new LinkedList<>();
        this.players.add(new Computer(new LimitIntellect(14), "First"));
        this.players.add(new Computer(new LimitIntellect(20), "Second"));
        this.players.add(new Human(new ConsoleIntellect(), new ConsoleBetter(), "Me", 200));
        dealer = new Dealer();
        this.players.add(dealer);
    }

    public void dealCards() {
        for (Player player : this.players) {
            dealer.deal(player);
            dealer.deal(player);
            System.out.println(player.name+ ": " + player.hand);
        }
    }

    public void game() {
        for (Player player : this.players) {
            while (true) {
                System.out.println(player.name + " " + player.hand.getScore() + ": " + player.hand);
                Command command = player.decision();
                if (command == Command.STAND)
                    break;
                if (command == Command.HIT)
                    dealer.deal(player);
            }
        }
    }

    public void whoIsWinner(){
        for (Player player: this.players) {
            if (player != dealer) {
                if (player.hand.getScore() > 21)
                    player.condition = Condition.LOSS;
                else if (dealer.hand.getScore() > 21)
                    player.condition = Condition.WIN;
                else if (dealer.hand.getScore() > player.hand.getScore())
                    player.condition = Condition.LOSS;
                else if (player.hand.getScore() > dealer.hand.getScore())
                    player.condition = Condition.WIN;
                else if (dealer.hand.getScore() == player.hand.getScore())
                    player.condition = Condition.DRAW;
            }
            dealer.condition = Condition.ENDED;
            System.out.println(player.name + ": " + player.condition + " with " + player.hand + " and "
                    + player.hand.getScore());
        }
    }

    public void makeBet() {
        for (Player player: this.players){
            player.makeBet(player.hand);
        }
    }

    public void payBets() {

    }

    public void discardCards() {

    }
}
