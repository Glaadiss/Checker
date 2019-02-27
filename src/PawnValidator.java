/**
 * @author Bartłomiej Gładys
 * @date 27/02/2019
 * @version 1.0
 */

class PawnValidator {

    void validate(Point pointFrom, Point pointTo) throws MoveException {
        if(pointTo.isNotOnBoard()){
            throw new MoveException("Point not on board");
        }
        if(!pointFrom.isDiagonalMove(pointTo)){
            throw new MoveException("Move is not diagonal");
        }
        if(pointFrom.isToLongJump(pointTo)){
            throw new MoveException("Jump is too big");
        }
        if(pointFrom.equals(pointTo)){
            throw  new MoveException("Can't stay in same place");
        }
    }

}
