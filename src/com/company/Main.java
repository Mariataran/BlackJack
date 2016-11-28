package com.company;

public class Main {
    public static void main(String[] args) {
        Table table = new Table();

        table.makeBet();

        table.dealCards();

        table.game();

        table.whoIsWinner();

        table.payBets();

        table.discardCards();
    }
}
