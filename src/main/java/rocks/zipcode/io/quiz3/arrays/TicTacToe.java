package rocks.zipcode.io.quiz3.arrays;

import java.util.*;

/**
 * @author leon on 09/12/2018.
 */
public class TicTacToe {

    private String[][] gameBoard;
    private String topLeft;
    private String topRight;
    private String topMid;
    private String botLeft;
    private String botRight;
    private String botMid;
    private String midLeft;
    private String midMid;
    private String midRight;
    private ArrayList<String> linesToCheck = new ArrayList<>();

    public TicTacToe(String[][] board) {
        this.gameBoard = board;
        this.linesToCheck = new ArrayList<>();
        this.topLeft = this.gameBoard[0][0].toString();
        this.topRight = this.gameBoard[0][2].toString();
        this.topMid = this.gameBoard[0][1].toString();
        this.botLeft = this.gameBoard[2][0].toString();
        this.botRight = this.gameBoard[2][2].toString();
        this.botMid = this.gameBoard[2][1].toString();
        this.midLeft = this.gameBoard[1][0].toString();
        this.midMid = this.gameBoard[1][1].toString();
        this.midRight = this.gameBoard[1][2].toString();
        this.linesToCheck.add(topLeft + topMid + topRight);
        this.linesToCheck.add(midLeft + midMid + midRight);
        this.linesToCheck.add(botLeft + botMid + botRight);
        this.linesToCheck.add(topLeft + midLeft + botLeft);
        this.linesToCheck.add(topMid + midMid + botMid);
        this.linesToCheck.add(topRight + midRight + botRight);
        this.linesToCheck.add(topLeft + midMid + botRight);
        this.linesToCheck.add(botLeft + midMid + topRight);
    }

    public String[] getRow(Integer value) {
        String[] toRet = new String[gameBoard.length];
        for (int i = 0; i < gameBoard.length; i++) {
            toRet[i] = gameBoard[value][i];
        }
        return toRet;
    }

    public String[] getColumn(Integer value) {
        String[] toRet = new String[gameBoard.length];
        for (int i = 0; i < gameBoard.length; i++) {
            toRet[i] = gameBoard[i][value];
        }
        return toRet;
    }

    public Boolean isRowHomogenous(Integer rowIndex) {
        String[] row = getRow(rowIndex);
        if (row.length > 0) {
            String lastString = row[0];
            for (String s : row) {
                if (!s.equals(lastString)) {
                    return false;
                }
                lastString = s;
            }
        }
        return true;
    }

    public Boolean isColumnHomogeneous(Integer columnIndex) {
        String[] col = getColumn(columnIndex);
        if (col.length > 0) {
            String lastString = col[0];
            for (String s : col) {
                if (!s.equals(lastString)) {
                    return false;
                }
                lastString = s;
            }
        }
        return true;
    }

    public String getWinner() {for (String line : linesToCheck) {
        if (checkLine(line)) {
            return checkWhichLine(line);
        }
    }
        return "";
    }

    public boolean checkLine(String line) {
        if (line.equals("XXX") || line.equals("OOO")) { return true; }
        return false;
    }

    public String checkWhichLine(String line) {
        if (line.equals("XXX")) { return "X"; }
        else { return "O"; }
    }

    public String[][] getBoard() {
        return gameBoard;
    }
}
