package com.company;

/**
 * Created by student2 on 21.11.16.
 */
public class ConsoleIntellect extends Intellect {
    @Override
    public Command decide(int score) {
        return Command.STAND;
    }
}
