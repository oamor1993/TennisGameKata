package com.kata.tennis.domain;

public class TieBreak {

    private Player playerOne;
    private Player playerTwo;

    public TieBreak(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public String getTennisScoreTieBreak(){
        if (playerOne.getCurrentScoreInTieBreak() >=7 && (playerOne.getCurrentScoreInTieBreak() - playerTwo.getCurrentScoreInTieBreak())>=2){
            return playerOne.getName() + " Win Tie Break and Match";
        }
        else if (playerTwo.getCurrentScoreInTieBreak() >=7 && (playerTwo.getCurrentScoreInTieBreak() - playerOne.getCurrentScoreInTieBreak())>=2){
            return playerTwo.getName() + " Win Tie Break and Match";
        }
        return playerOne.getCurrentScoreInTieBreak() + " - " + playerTwo.getCurrentScoreInTieBreak();
    }

    public void playerOneScorePoint(){
        this.playerOne.scorePoint();
    }

    public void playerTwoScorePoint(){
        this.playerTwo.scorePoint();
    }
}
