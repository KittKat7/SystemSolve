package edu.appstate.cs.codequest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class LevelTest {

    @Test
    public void TestGetIsAtGoalLevel0() throws IOException{
        assertTrue(new Level(0).getIsAtGoal());
    }

    @Test
    public void TestGetIsAtGoalLevel1() throws IOException{
        assertTrue(!(new Level(1).getIsAtGoal()));
    }

    @Test
    public void TestGetIsAtGoalLevel2() throws IOException{
        assertTrue(!(new Level(2).getIsAtGoal()));
    }

    @Test
    public void TestGetIsAtGoalLevel3() throws IOException{
        assertTrue(!(new Level(3).getIsAtGoal()));
    }

    @Test
    public void TestGetIsAtGoalLevel4() throws IOException{
        assertTrue(!(new Level(3).getIsAtGoal()));
    }

    @Test
    public void TestGetIsAtGoalLevel5() throws IOException{
        assertTrue(!(new Level(5).getIsAtGoal()));
    }

    @Test
    public void testLevel1BoardHasGoal() throws IOException{
        assertTrue(new Level(1).getBoard().getHasGoal());
    }

    @Test
    public void testLevel2BoardHasGoal() throws IOException{
        assertTrue(new Level(2).getBoard().getHasGoal());
    }

    @Test
    public void testLevel3BoardHasGoal() throws IOException{
        assertTrue(new Level(3).getBoard().getHasGoal());
    }

    @Test
    public void testLevel4BoardHasGoal() throws IOException{
        assertTrue(new Level(4).getBoard().getHasGoal());
    }

    @Test
    public void testLevel5BoardHasGoal() throws IOException{
        assertTrue(new Level(5).getBoard().getHasGoal());
    }

    @Test
    public void testRunCode() throws IOException{
        Level l = new Level(0);
        int x = l.getPlayerObject().getPlayerX();
        int y = l.getPlayerObject().getPlayerY();
        l.runCode("moveU");
        assertTrue(((l.getPlayerObject().getPlayerX() == x) && (l.getPlayerObject().getPlayerY() == y-1)));
    }
}
