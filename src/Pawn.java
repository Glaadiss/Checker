/**
 * @author Bartłomiej Gładys
 * @date 27/02/2019
 * @version 1.0
 */

class Pawn {

    private PawnValidator validator;
    private Point point;
    private Constants.PLAYER player;
    public Pawn(Point point, Constants.PLAYER player){
        this.point = point;
        this.player = player;
        this.validator = new PawnValidator();
    }

    void move(Point pointTo) throws MoveException {
        validator.validate(point, pointTo);
        point = pointTo;
    }

    Constants.PLAYER getPlayer() {
        return player;
    }

    Point getPoint() {
        return point;
    }
}