import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Bartłomiej Gładys
 * @date 27/02/2019
 * @version 1.0
 */

class PawnsManager{
    private List<Pawn> pawns = new ArrayList<>();
    private Constants.PLAYER currentPlayer;
    private Pawn currentPawn;

    List<Pawn> getPawns() {
        return pawns;
    }

    void add(Pawn pawn) {
        if(pawn.getPlayer() != null) {
            pawns.add(pawn);
        }
    }

    Pawn find(Point point) {
        Optional<Pawn> pawn = pawns
                .stream()
                .filter(e -> e.getPoint().equals(point))
                .findFirst();
        return pawn.orElse(null);

    }

    void setCurrentPlayer(Constants.PLAYER player) {
        currentPlayer = player;
    }

    void choosePawn(Point point) throws MoveException {
        Pawn pawn = find(point);
        if(pawn == null || pawn.getPlayer() != currentPlayer) {
            throw new MoveException("No pawn or enemy's pawn on this position!");
        }
        currentPawn = pawn;
    }


    boolean removeEnemyPawnBetween(Point point){
        Pawn enemyPawn = find(currentPawn.getPoint().getPointBetweenJump(point));
        if(enemyPawn == null || enemyPawn.getPlayer() == currentPlayer) {
            return false;
        }
        pawns.remove(enemyPawn);
        return true;
    }

    void movePawn(Point point) throws MoveException {
        Pawn pawn = find(point);
        if(pawn != null) {
            throw new MoveException("Other pawn is already there!");
        }
        if(currentPawn.getPoint().isJumpByTwo(point)) {
            boolean isEnemyRemoved = removeEnemyPawnBetween(point);
            if(!isEnemyRemoved) {
                throw new MoveException("Can't jump by two, if there is no enemy pawn!");
            }
        }
        currentPawn.move(point);
    }
}