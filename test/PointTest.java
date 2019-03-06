import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author Bartłomiej Gładys
 * @Date: 06/03/2019
 * @Version: 1.0
 */

public class PointTest {

    @Test
    public void isNotOnBoard() {
        Point point = new Point(-1, 4);
        assertTrue(point.isNotOnBoard());

        point = new Point(3, -1);
        assertTrue(point.isNotOnBoard());

        point = new Point(0, Constants.ROWS - 1);
        assertFalse(point.isNotOnBoard());

        point = new Point(Constants.ROWS - 2, 0);
        assertFalse(point.isNotOnBoard());
    }

    @Test
    public void equals() {
        Point point = new Point(4, 5);
        Point point2 = new Point(4, 5);
        Point point3 = new Point(5, 4);

        assertTrue(point.equals(point2));
        assertFalse(point.equals(point3));
    }

    @Test
    public void isToLongJump() {
        Point point = new Point(4, 5);
        Point point2 = new Point(6, 7);
        Point point3 = new Point(7, 8);

        assertTrue(point.isToLongJump(point3));
        assertFalse(point.isToLongJump(point2));
    }

    @Test
    public void isJumpByTwo() {
        Point point = new Point(4, 5);
        Point point2 = new Point(6, 7);
        Point point3 = new Point(7, 8);
        Point point4 = new Point(5, 6);

        assertTrue(point.isJumpByTwo(point2));
        assertFalse(point.isJumpByTwo(point3));
        assertFalse(point.isJumpByTwo(point4));
    }

    @Test
    public void isDiagonalMove() {
        Point point = new Point(4, 5);
        Point point2 = new Point(5, 6);
        Point point3 = new Point(5, 7);

        assertTrue(point.isDiagonalMove(point2));
        assertFalse(point.isDiagonalMove(point3));
    }

    @Test
    public void getPointBetweenJump() {
        Point point = new Point(4, 5);
        Point point2 = new Point(6, 7);

        Point middlePoint = point.getPointBetweenJump(point2);
        assertTrue(middlePoint.equals(new Point(5, 6)));
    }
}