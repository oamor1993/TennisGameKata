package com.kata.tennis.domain;


public class Game {

    private Player playerOne;
    private Player playerTwo;

    public Game(Player player1, Player player2) {
        this.playerOne = player1;
        this.playerTwo = player2;
    }

    public int getPlayerOneCurrentScore(){
        return playerOne.getCurrentScore();
    }

    public int getPlayerTwoCurrentScore(){
        return playerTwo.getCurrentScore();
    }

    public int getPlayerOneCurrentScoreSet(){
        return playerOne.getCurrentScoreInSet();
    }

    public int getPlayerTwoCurrentScoreSet(){
        return playerTwo.getCurrentScoreInSet();
    }

    public String getTennisScore(){
        if(playerOne.getCurrentScore()>3 && playerTwo.getCurrentScore()>3){
            if(playerOne.getCurrentScore() == playerTwo.getCurrentScore()){
                return "Deuce";
            }
            if(playerOne.getCurrentScore() - playerTwo.getCurrentScore() == 1){
                return "Advantage PlayerOne";
            }
            if(playerTwo.getCurrentScore() - playerOne.getCurrentScore() == 1){
                return "Advantage PlayerTwo";
            }
        }
        if(playerOne.getCurrentScore()>3){
            return playerOne.getName()+" Win Game" + " ; Set Score "+playerOne.getCurrentScoreInSet()+" - " +playerTwo.getCurrentScoreInSet();
        }
        if(playerTwo.getCurrentScore()>3){
            return playerTwo.getName()+" Win Game" + " ; Set Score "+playerOne.getCurrentScoreInSet()+" - " +playerTwo.getCurrentScoreInSet();
        }
        return playerOne.tennisScore()+"-"+playerTwo.tennisScore();
    }


    public void playerOneScore(){
        this.playerOne.score();
    }

    public void playerTwoScore(){
        this.playerTwo.score();
    }
}
