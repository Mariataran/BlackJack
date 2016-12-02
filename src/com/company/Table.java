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
        this.players.add(new Computer(new LimitIntellect(14), new HalfBetter(), "First", 200));
        this.players.add(new Computer(new LimitIntellect(20), new HalfBetter(), "Second", 200));
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
            if(player!=dealer)
            player.makeBet(player.hand);
        }
    }

    public void payBets() {
        for (Player player: this.players){
            if(player!=dealer) {
                if (player.condition == Condition.WIN)
                    player.balance += player.hand.bet;
                else
                    player.balance -= player.hand.bet * 2;
                System.out.println(player.name + ": " + player.balance);
            }
        }
    }

    public void discardCards() {
        for (Player player: this.players) {
            player.hand.clear();
        }
    }

    public boolean allBankrupts() {
        int count = 0;
        for (Player player: this.players){
            if (player!=dealer) {
                if (player.condition == Condition.BANKRUPT){
                    count += 1;
                }
            }
        }
        if (count == 3)
            return true;
        else
            return false;
    }

    public void endOfGame() {
    }
}
