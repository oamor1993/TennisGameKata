package com.kata.tennis.domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GameTest {

    private Player playerOne;
    private Player playerTwo;
    private Game game;
    private Set set;
    private TieBreak tieBreak;

    @Before
    public void setup() {
        playerOne = new Player("PlayerOne");
        playerTwo = new Player("PlayerTwo");
        set = new Set(playerOne,playerTwo);
        game = new Game(playerOne,playerTwo);
        tieBreak = new TieBreak(playerOne,playerTwo);
    }

    @Test
    public void game_should_start_with_score_of_0_0(){
        assertThat( game.getPlayerOneCurrentScore(), is(equalTo(0)));
        assertThat( game.getPlayerTwoCurrentScore(), is(equalTo(0)));
    }

    @Test
    public void game_should_start_with_scoreSet_of_0_0(){
        assertThat( game.getPlayerOneCurrentScoreSet(), is(equalTo(0)));
        assertThat( game.getPlayerTwoCurrentScoreSet(), is(equalTo(0)));
    }

    @Test
    public void game_should_be_with_score_of_1_0_when_playerOne_scores(){
        game.playerOneScore();
        assertThat( game.getPlayerOneCurrentScore(), is(equalTo(1)));
        assertThat( game.getPlayerTwoCurrentScore(), is(equalTo(0)));
    }

    @Test
    public void game_should_have_score_of_1_1_when_playerOne_scores_and_playerTwo_scores(){
        game.playerOneScore();
        game.playerTwoScore();
        assertThat( game.getPlayerOneCurrentScore(), is(equalTo(1)));
        assertThat( game.getPlayerTwoCurrentScore(), is(equalTo(1)));
    }

    @Test
    public void game_should_have_tennis_score_15_15(){
        game.playerOneScore();
        game.playerTwoScore();
        assertThat( game.getTennisScore(), is(equalTo("15-15")));
    }

    @Test
    public void game_should_have_tennis_score_15_30(){
        game.playerOneScore();
        game.playerTwoScore();
        game.playerTwoScore();
        assertThat( game.getTennisScore(), is(equalTo("15-30")));
    }

    @Test
    public void game_should_have_tennis_score_15_40(){
        game.playerOneScore();
        game.playerTwoScore();
        game.playerTwoScore();
        game.playerTwoScore();
        assertThat( game.getTennisScore(), is(equalTo("15-40")));
    }

    @Test
    public void game_should_have_tennis_score_30_40(){
        game.playerOneScore();
        game.playerOneScore();
        game.playerTwoScore();
        game.playerTwoScore();
        game.playerTwoScore();
        assertThat( game.getTennisScore(), is(equalTo("30-40")));
    }

    @Test
    public void game_should_have_tennis_score_40_40(){
        game.playerOneScore();
        game.playerOneScore();
        game.playerOneScore();
        game.playerTwoScore();
        game.playerTwoScore();
        game.playerTwoScore();
        assertThat( game.getTennisScore(), is(equalTo("40-40")));
    }

    @Test
    public void game_should_have_tennis_score_playerOne_Win(){
        game.playerOneScore();
        game.playerOneScore();
        game.playerOneScore();
        game.playerOneScore();
        set.playerOneScoreGame();
        assertThat( game.getTennisScore(), is(equalTo("PlayerOne Win Game ; Set Score 1 - 0")));
    }

    @Test
    public void game_should_have_tennis_score_playerTwo_Win(){
        game.playerTwoScore();
        game.playerTwoScore();
        game.playerTwoScore();
        game.playerTwoScore();
        set.playerTwoScoreGame();
        assertThat( game.getTennisScore(), is(equalTo("PlayerTwo Win Game ; Set Score 0 - 1")));
    }

    @Test
    public void game_should_have_tennis_score_deuce(){
        game.playerOneScore();
        game.playerOneScore();
        game.playerOneScore();
        game.playerOneScore();
        game.playerTwoScore();
        game.playerTwoScore();
        game.playerTwoScore();
        game.playerTwoScore();
        assertThat( game.getTennisScore(), is(equalTo("Deuce")));
    }

    @Test
    public void game_should_have_tennis_score_advantage_PlayerOne(){
        game.playerOneScore();
        game.playerOneScore();
        game.playerOneScore();
        game.playerOneScore();
        game.playerOneScore();
        game.playerTwoScore();
        game.playerTwoScore();
        game.playerTwoScore();
        game.playerTwoScore();
        assertThat( game.getTennisScore(), is(equalTo("Advantage PlayerOne")));
    }

    @Test
    public void game_should_have_tennis_score_advantage_PlayerTwo(){
        game.playerOneScore();
        game.playerOneScore();
        game.playerOneScore();
        game.playerOneScore();
        game.playerTwoScore();
        game.playerTwoScore();
        game.playerTwoScore();
        game.playerTwoScore();
        game.playerTwoScore();
        assertThat( game.getTennisScore(), is(equalTo("Advantage PlayerTwo")));
    }

    @Test
    public void set_should_have_tennis_score_3_2(){
        set.playerOneScoreGame();
        set.playerTwoScoreGame();
        set.playerOneScoreGame();
        set.playerOneScoreGame();
        set.playerTwoScoreGame();
        assertThat( set.getTennisScoreSet(), is(equalTo("3 - 2")));
    }

    @Test
    public void set_should_have_tennis_score_PlayerOne_Win(){
        set.playerOneScoreGame();
        set.playerOneScoreGame();
        set.playerOneScoreGame();
        set.playerOneScoreGame();
        set.playerTwoScoreGame();
        set.playerTwoScoreGame();
        set.playerOneScoreGame();
        set.playerOneScoreGame();
        assertThat( set.getTennisScoreSet(), is(equalTo("PlayerOne Win Match")));
    }

    @Test
    public void set_should_have_tennis_score_6_5(){
        set.playerOneScoreGame();
        set.playerTwoScoreGame();
        set.playerOneScoreGame();
        set.playerOneScoreGame();
        set.playerTwoScoreGame();
        set.playerTwoScoreGame();
        set.playerOneScoreGame();
        set.playerTwoScoreGame();
        set.playerOneScoreGame();
        set.playerTwoScoreGame();
        set.playerOneScoreGame();
        assertThat( set.getTennisScoreSet(), is(equalTo("6 - 5")));
    }

    @Test
    public void set_should_have_tennis_score_Tie_Break_To_Be_Played(){
        set.playerOneScoreGame();
        set.playerTwoScoreGame();
        set.playerOneScoreGame();
        set.playerOneScoreGame();
        set.playerTwoScoreGame();
        set.playerTwoScoreGame();
        set.playerOneScoreGame();
        set.playerTwoScoreGame();
        set.playerOneScoreGame();
        set.playerTwoScoreGame();
        set.playerOneScoreGame();
        set.playerTwoScoreGame();
        assertThat( set.getTennisScoreSet(), is(equalTo("Tie Break To Be Played")));
    }

    @Test
    public void tie_break_should_have_tennis_score_3_2(){
        tieBreak.playerOneScorePoint();
        tieBreak.playerTwoScorePoint();
        tieBreak.playerOneScorePoint();
        tieBreak.playerTwoScorePoint();
        tieBreak.playerOneScorePoint();
        assertThat( tieBreak.getTennisScoreTieBreak(), is(equalTo("3 - 2")));
    }

    @Test
    public void tie_break_should_have_tennis_score_9_8(){
        tieBreak.playerOneScorePoint();
        tieBreak.playerTwoScorePoint();
        tieBreak.playerOneScorePoint();
        tieBreak.playerTwoScorePoint();
        tieBreak.playerOneScorePoint();
        tieBreak.playerTwoScorePoint();
        tieBreak.playerOneScorePoint();
        tieBreak.playerTwoScorePoint();
        tieBreak.playerOneScorePoint();
        tieBreak.playerTwoScorePoint();
        tieBreak.playerOneScorePoint();
        tieBreak.playerTwoScorePoint();
        tieBreak.playerOneScorePoint();
        tieBreak.playerTwoScorePoint();
        tieBreak.playerOneScorePoint();
        tieBreak.playerTwoScorePoint();
        tieBreak.playerOneScorePoint();
        assertThat( tieBreak.getTennisScoreTieBreak(), is(equalTo("9 - 8")));
    }

    @Test
    public void tie_break_should_have_tennis_playerOne_Win_Tie_Break_and_Match(){
        tieBreak.playerOneScorePoint();
        tieBreak.playerTwoScorePoint();
        tieBreak.playerOneScorePoint();
        tieBreak.playerTwoScorePoint();
        tieBreak.playerOneScorePoint();
        tieBreak.playerTwoScorePoint();
        tieBreak.playerOneScorePoint();
        tieBreak.playerTwoScorePoint();
        tieBreak.playerOneScorePoint();
        tieBreak.playerTwoScorePoint();
        tieBreak.playerOneScorePoint();
        tieBreak.playerTwoScorePoint();
        tieBreak.playerOneScorePoint();
        tieBreak.playerTwoScorePoint();
        tieBreak.playerOneScorePoint();
        tieBreak.playerOneScorePoint();
        assertThat( tieBreak.getTennisScoreTieBreak(), is(equalTo("PlayerOne Win Tie Break and Match")));
    }
}
