/**
 * @author Bartłomiej Gładys
 * @date 27/02/2019
 * @version 1.0
 */

public class Checker {
    private PawnsManager pawnsManager = new PawnsManager();
    private Printer printer = new Printer(pawnsManager);
    private Input input = new Input(pawnsManager);

    private  void generatePawns() {
        for(int i =0 ; i < Constants.ROWS; i++) {
            for(int j = 0; j< Constants.ROWS; j++) {
                Constants.PLAYER player = Constants.boardDraw[i][j];
                Pawn pawn = new Pawn(new Point(j, i), player);
                pawnsManager.add(pawn);
            }
        }
    }

    public Checker() {
        generatePawns();
        printer.printBoard();
        gameLoop(Constants.PLAYER.FIRST);
    }

    private int getPawnsNumber(Constants.PLAYER player) {
        return (int) pawnsManager
                .getPawns()
                .stream()
                .filter(e -> e.getPlayer() == player)
                .count();
    }

    private boolean isFinish() {
        int firstCount = getPawnsNumber(Constants.PLAYER.FIRST);
        int secondCount = getPawnsNumber(Constants.PLAYER.SECOND);
        return firstCount == 0 || secondCount == 0;
    }

    private void gameLoop(Constants.PLAYER player) {
        pawnsManager.setCurrentPlayer(player);
        input.askPlayerForPointer(player);
        input.askPlayerForMove(player);
        printer.printBoard();
        if(isFinish()) {
            new Checker();
        }else {
            gameLoop(player == Constants.PLAYER.FIRST ? Constants.PLAYER.SECOND : Constants.PLAYER.FIRST);
        }
    }
}
