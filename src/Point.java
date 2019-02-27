/**
 * @author Bartłomiej Gładys
 * @date 27/02/2019
 * @version 1.0
 */

class Point {
    private int x;
    private int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    private int getX() {
        return x;
    }

    private int getY() {
        return y;
    }

    boolean isNotOnBoard(){
        return x < 0 || x >= Constants.ROWS || y < 0 || y >= Constants.ROWS;
    }

    boolean equals(Point pointTo) {
        return x == pointTo.getX() && y == pointTo.getY();
    }

    boolean isToLongJump(Point pointTo){
        return Math.abs(x - pointTo.x) > 2;
    }

    boolean isJumpByTwo(Point pointTo) {
        return Math.abs(x - pointTo.getX()) == 2;
    }

    boolean isDiagonalMove(Point pointTo){
        return Math.abs(x - pointTo.getX()) == Math.abs(y - pointTo.getY());
    }

    Point getPointBetweenJump(Point point){
        int enemyX = x < point.getX() ? x - 1 : x + 1;
        int enemyY = y < point.getY() ? y - 1 : y + 1;
        return new Point(enemyX, enemyY);
    }
}
