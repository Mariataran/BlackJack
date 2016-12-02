package com.company;

public class Main {
    public static void main(String[] args) {
        Table table = new Table();

        while (true) {
            if (table.allBankrupts() == false) {
                table.makeBet();

                table.dealCards();

                table.game();

                table.whoIsWinner();

                table.payBets();

                table.discardCards();
            }
            else {
                table.endOfGame();
                break;
            }
        }
    }
}
