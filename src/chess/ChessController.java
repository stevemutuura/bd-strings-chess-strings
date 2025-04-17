package chess;

public class ChessController {
    public static String pieces =
            "RNBQKBNR" + //0-7
            "PPPPPPPP" + //8-15
            "xxxxxxxx" + //16-23
            "xxxxxxxx" + //24-31
            "xxxxxxxx" + //32-39
            "xxxxxxxx" + //40-47
            "pppppppp" + //48-55
            "rnbqkbnr"; //56-63

    public int coordinateToIndex(String coordinate) {
        // THe coordinate is in xy format
        // x is a letter, a-h
        // y is a number, 1 -8
        char xValue = coordinate.charAt(0);
        char yValue = coordinate.charAt(1);

        // x: a b c d e f g h
        //  : 0 1 2 3 4 5 6 7
        int colNum = xValue -'a';

        // y: '1' '2' '3' '4' '5' '6' '7' '8'
        //     0   1   2   3   4   5   6   7
        int rowNum = yValue - '1';

        return rowNum * 8 + colNum;
    }

    public void move(String from, String to) {
        // pieces is the current state of the chess board

        int fromIndex = coordinateToIndex(from);
        int toIndex = coordinateToIndex(to);

        // change the character in toIndex to be the character in fromIndex.
        // change the character to an 'x'

        pieces = pieces.substring(0, toIndex) +
                pieces.charAt(fromIndex) +
                pieces.substring(toIndex + 1);

        pieces = pieces.substring(0, fromIndex) +
                'x' +
                pieces.substring(fromIndex + 1);


        // first half of the String up until the toIndex will be the same
        // put the fromIndex's character
        // second half of the String will be the same

        // ".......b........P............................................"
        //         ^........^
        // ".......x........b............................................"

    }

    public void printGame() {
        for (int i = 56; i >= 0; i -= 8) {
            System.out.println(pieces.substring(i, i + 8));
        }
    }
}
