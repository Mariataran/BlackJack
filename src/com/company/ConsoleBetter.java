package com.company;

import java.util.Scanner;

/**
 * Created by student2 on 28.11.16.
 */
public class ConsoleBetter extends Better {
    private Scanner in = new Scanner(System.in);

    @Override
    public int makeBet(int balance) {
        System.out.println("MAKE YOUR CHOICE (BET)! YOUR BALANCE IS " + balance);
        Integer c = in.nextInt();
        return c;
    }
}
