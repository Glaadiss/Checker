/**
 * @author Bartłomiej Gładys
 * @date 27/02/2019
 * @version 1.0
 */

class Printer {
    private PawnsManager pawnsManager;

    Printer(PawnsManager pawnsManager){
        this.pawnsManager = pawnsManager;
    }

    void printBoard() {
        System.out.println(Constants.HEADER_NUMBERS);
        System.out.println(Constants.DIVIDER);
        for(int i =0 ; i < Constants.ROWS; i++) {
            System.out.print(String.valueOf(i) + " |");
            for(int j = 0; j< Constants.ROWS; j++) {
                Pawn pawn = pawnsManager.find(new Point(j, i));
                printField(pawn);
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println(Constants.DIVIDER);
    }

    private void printField(Pawn pawn) {
        if(pawn == null) {
            System.out.print("  ");
            return;
        }
        if(pawn.getPlayer() == Constants.PLAYER.FIRST) {
            System.out.print("1 ");
            return;
        }
        System.out.print("2 ");
    }
}
