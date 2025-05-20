package xyz.kittkat.systemsolve;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import xyz.kittkat.systemsolve.DisplayBoard;

public class DisplayBoardTest {
    @Test
    public void testUpdate() throws IOException {
        DisplayBoard gameBoard = new DisplayBoard();
        gameBoard.setIndex(0);
        gameBoard.setButton(true);
        gameBoard.update();
        assertEquals(gameBoard.levelButton.getText(), "Next Level");
        gameBoard.setIndex(1);
        gameBoard.setButton(true);
        gameBoard.update();
        assertEquals(gameBoard.levelButton.getText(), "Reset");
    }

    @Test
    public void testUpdateNextLevel() throws IOException {
        DisplayBoard gameBoard = new DisplayBoard();
        gameBoard.setIndex(0);
        gameBoard.setButton(true);
        gameBoard.update();
        assertEquals(gameBoard.levelButton.getText(), "Next Level");
        gameBoard.setButton(true);
        gameBoard.setIndex(gameBoard.getIndex() + 1);
        gameBoard.update();
        assertEquals(gameBoard.levelButton.getText(), "Reset");
    }
}
