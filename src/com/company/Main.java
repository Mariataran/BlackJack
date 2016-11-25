package com.company;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Player> players = new LinkedList<>();
        players.add(new Computer(new LimitIntellect(14), "First"));
        players.add(new Computer(new LimitIntellect(20), "Second"));
        players.add(new Human(new ConsoleIntellect(), "Me"));
        Dealer dealer = new Dealer();
        players.add(dealer);

        for (Player player : players) {
            dealer.deal(player);
            dealer.deal(player);
            System.out.println(player.name+ ": " + player.hand);
        }

        for (Player player : players) {

            while (true) {
                    System.out.println(player.name + " " + player.hand.getScore() + ": " + player.hand);
                    Command command = player.decision();
                    if (command == Command.STAND)
                        break;
                    if (command == Command.HIT)
                        dealer.deal(player);
            }
        }
        for (Player player: players) {
            if (player != dealer) {
                if (player.hand.getScore() > 21)
                    player.condition = Condition.LOSS;
                else if (dealer.hand.getScore() > 21)
                    player.condition = Condition.WIN;
                else if (dealer.hand.getScore() > player.hand.getScore())
                    player.condition = Condition.DRAW;
                else if (player.hand.getScore() > dealer.hand.getScore())
                    player.condition = Condition.WIN;
            }
            dealer.condition = Condition.ENDED;
            System.out.println(player.name + ": " + player.condition + " with " + player.hand + " and "
                    + player.hand.getScore());
        }
    }
}
