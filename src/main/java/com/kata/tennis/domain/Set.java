package com.kata.tennis.domain;

public class Set {

    private Player playerOne;
    private Player playerTwo;

    public Set(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public String getTennisScoreSet(){
        if (playerOne.getCurrentScoreInSet() == 6 && playerTwo.getCurrentScoreInSet() <= 4){
            return playerOne.getName() + " Win Match";
        }
        else if (playerTwo.getCurrentScoreInSet() == 6 && playerOne.getCurrentScoreInSet() <= 4){
            return playerTwo.getName() + " Win Match";
        }
        else if (playerTwo.getCurrentScoreInSet() == 7 && playerOne.getCurrentScoreInSet() == 5){
            return playerTwo.getName() + " Win Match";
        }
        else if (playerOne.getCurrentScoreInSet() == 7 && playerTwo.getCurrentScoreInSet() == 5){
            return playerOne.getName() + " Win Match";
        }
        else if (playerOne.getCurrentScoreInSet() == 6 && playerTwo.getCurrentScoreInSet() == 6){
            return "Tie Break To Be Played";
        }
        return playerOne.getCurrentScoreInSet() + " - " + playerTwo.getCurrentScoreInSet();
    }

    public void playerOneScoreGame(){
        this.playerOne.scoreGame();
    }

    public void playerTwoScoreGame(){
        this.playerTwo.scoreGame();
    }
}
