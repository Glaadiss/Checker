import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author Bartłomiej Gładys
 * @Date: 06/03/2019
 * @Version: 1.0
 */

public class PawnsManagerTest {

    private PawnsManager generatePawnsManger(){
        PawnsManager pawnsManager = new PawnsManager();
        Pawn pawn1 = new Pawn(new Point(2,3), Constants.PLAYER.FIRST);
        Pawn pawn2 = new Pawn(new Point(4,3), Constants.PLAYER.FIRST);
        Pawn pawn3 = new Pawn(new Point(6,3), Constants.PLAYER.FIRST);
        Pawn pawn4 = new Pawn(new Point(5,4), Constants.PLAYER.SECOND);
        pawnsManager.add(pawn1);
        pawnsManager.add(pawn2);
        pawnsManager.add(pawn3);
        pawnsManager.add(pawn4);
        return pawnsManager;
    }

    @Test
    public void find() {
        PawnsManager pawnsManager = generatePawnsManger();

        Pawn pawn = pawnsManager.find(new Point(4, 3));
        assertTrue(pawn.getPoint().equals(new Point(4, 3)));

        Pawn pawnNull = pawnsManager.find(new Point(4,4));
        assertNull(pawnNull);
    }

    @Test
    public void removeEnemyPawnBetween() throws MoveException {
        PawnsManager pawnsManager = generatePawnsManger();
        pawnsManager.setCurrentPlayer(Constants.PLAYER.FIRST);
        pawnsManager.choosePawn(new Point(4,3));

        boolean removed = pawnsManager.removeEnemyPawnBetween(new Point(6,5));
        boolean notRemoved = pawnsManager.removeEnemyPawnBetween(new Point(2,5));
        assertTrue(removed);
        assertFalse(notRemoved);
    }

    @Test(expected = MoveException.class)
    public void chooseEnemyPawn() throws MoveException {
        PawnsManager pawnsManager = generatePawnsManger();
        pawnsManager.setCurrentPlayer(Constants.PLAYER.SECOND);
        pawnsManager.choosePawn(new Point(2,3));
    }

    @Test
    public void chooseCorrectPawn() throws MoveException {
        PawnsManager pawnsManager = generatePawnsManger();
        pawnsManager.setCurrentPlayer(Constants.PLAYER.FIRST);
        pawnsManager.choosePawn(new Point(2,3));
    }

    @Test(expected = MoveException.class)
    public void movePawnToOccupiedField() throws MoveException {
        PawnsManager pawnsManager = generatePawnsManger();
        pawnsManager.movePawn(new Point(2,3));
    }
}