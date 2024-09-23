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
            "rnbqkbnr";  //56-63

    public int coordinateToIndex(String coordinate) {
        //The coordinate is xy format
        //x is a letter(a-h)
        //y is a number(1-8)
        char xValue = coordinate.charAt(0);
        char yValue = coordinate.charAt(1);
        //x: a b c d e f g h
        //   1 2 3 4 5 6 7 8
        int colNum = xValue - 'a';
        //y: '1' '2' '3' '4' '5' '6' '7' '8'
        //    0   1   2   3   4   5   6   7
        int rowNum = yValue - '1';
        return rowNum * 8 + colNum;
    }

    public void move(String from, String to) {
        //pieces is the current state of the chessboard
        //move a5 to b6

        int fromIndex = coordinateToIndex(from);
        int toIndex = coordinateToIndex(to);

        //change the character in toIndex to be the character in fromIndex
        //change the character in toIndex to an 'x'

        //first half of the String up until toIndex will be the same
        //put the fromIndex's character
        //second half of the String will be the same

        pieces = pieces.substring(0, toIndex) +
                 pieces.charAt(fromIndex) +
                 pieces.substring(toIndex + 1);

        pieces = pieces.substring(0, fromIndex) +
                'x' +
                pieces.substring(fromIndex + 1);
    }

    public void printGame() {
//        System.out.println(pieces.substring(56, 64));
//        System.out.println(pieces.substring(48, 56));
//        System.out.println(pieces.substring(40, 48));
//        System.out.println(pieces.substring(32, 40));
//        System.out.println(pieces.substring(24, 32));
//        System.out.println(pieces.substring(16, 24));
//        System.out.println(pieces.substring(8, 16));
//        System.out.println(pieces.substring(0, 8));

        for (int i =56; i >= 0; i -= 8) {
            System.out.println(pieces.substring(i, i + 8));
        }
    }
}

//Strings are immutable: an object whose internal values (instance variables) cannot be changed after being created.
