package com.kata.tennis.domain;

import java.util.Arrays;
import java.util.List;


public class Player {

    public static final List<Integer> scores = Arrays.asList(0, 15, 30, 40);

    private String name;

    private int currentScoreInGame;
    private int currentScoreInSet;
    private int currentScoreInTieBreak;

    public Player(String name) {
        this.name = name;
        this.currentScoreInGame = 0;
        this.currentScoreInSet = 0;
        this.currentScoreInTieBreak = 0;
    }

    public int getCurrentScore() {
        return currentScoreInGame;
    }
    public int getCurrentScoreInSet() {
        return currentScoreInSet;
    }

    public int getCurrentScoreInTieBreak() {
        return currentScoreInTieBreak;
    }

    public void score(){
        this.currentScoreInGame++;
    }

    public void scoreGame(){
        this.currentScoreInSet++;
    }

    public void scorePoint(){
        this.currentScoreInTieBreak++;
    }

    public int tennisScore(){
        return scores.get(currentScoreInGame);
    }

    public String getName() {
        return name;
    }
}
