/**
 * @author Bartłomiej Gładys
 * @date 27/02/2019
 * @version 1.0
 */

class Constants{
    public enum PLAYER {
        FIRST,
        SECOND
    }
    private static final PLAYER FIRST = PLAYER.FIRST;
    private static final PLAYER SECOND = PLAYER.SECOND;
    static int ROWS = 8;
    static String ENTER_X = "Enter X:";
    static String ENTER_Y = "Enter Y:";
    static String WHOSE_TURN = "Turn of player no. ";
    static String ASK_PAWN = "Coordinate of piece to move";
    static String ASK_PAWN_ERROR = "Bad input during chosing the Pawn, please repeat action.";
    static String ASK_MOVE = "Coordinate of new position";
    static String ASK_MOVE_ERROR = "Forbidden movement, please repeat action.";
    static String HEADER_NUMBERS = "   0 1 2 3 4 5 6 7  ";
    static String DIVIDER = "  +---------------+ ";

    static Constants.PLAYER[][] boardDraw = {
            {null, FIRST, null, FIRST, null, FIRST, null, FIRST},
            {FIRST, null, FIRST, null, FIRST, null, FIRST, null},
            {null, FIRST, null, FIRST, null, FIRST, null, FIRST},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {SECOND, null, SECOND, null, SECOND, null, SECOND, null},
            {null, SECOND, null, SECOND, null, SECOND, null, SECOND},
            {SECOND, null, SECOND, null, SECOND, null, SECOND, null}
    };
}




