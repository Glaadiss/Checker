import java.util.Scanner;

/**
 * @author Bartłomiej Gładys
 * @date 27/02/2019
 * @version 1.0
 */

class Input {
    private static int X = -1;
    private static int Y = -1;
    private static Scanner scanner = new Scanner(System.in);
    private PawnsManager pawnsManager;

    Input(PawnsManager pawnsManager){
        this.pawnsManager = pawnsManager;
    }

    private static int getNumberFromUser() {
        while (!scanner.hasNextInt()) scanner.next();
        return scanner.nextInt();
    }

    private static void askPlayerForCordinates() {
        System.out.print(Constants.ENTER_X);
        X = getNumberFromUser();
        System.out.println();
        System.out.print(Constants.ENTER_Y);
        Y = getNumberFromUser();
    }

    void askPlayerForPointer(Constants.PLAYER player) {
        System.out.println(Constants.WHOSE_TURN + String.valueOf(player));
        System.out.println(Constants.ASK_PAWN);
        askPlayerForCordinates();
        try {
            pawnsManager.choosePawn(new Point(X, Y));
        } catch (MoveException e) {
            System.out.println(Constants.ASK_PAWN_ERROR + e.getMessage());
            askPlayerForPointer(player);
        }

    }

    void askPlayerForMove(Constants.PLAYER player) {
        System.out.println(Constants.ASK_MOVE);
        askPlayerForCordinates();
        try {
            pawnsManager.movePawn(new Point(X, Y));
        } catch (MoveException e) {
            System.out.println(Constants.ASK_MOVE_ERROR + e.getMessage());
            askPlayerForPointer(player);
        };
    }
}
