package xogame;

public class XOBoard {


    char[] board = new char[10];

    public void set_board(){
        board = new char[]{'0',
                '1', '2', '3',
                '4', '5', '6',
                '7', '8', '9'};
    }

    public void draw(){
        System.out.println(board[1] + "   " + board[2] + "   " + board[3] + "\n");
        System.out.println(board[4] + "   " + board[5] + "   " + board[6] + "\n");
        System.out.println(board[7] + "   " + board[8] + "   " + board[9] + "\n");
    }

    public boolean isBusy(int index){
        return (Character.toLowerCase(board[index]) == 'x' || Character.toLowerCase(board[index]) == 'o');
    }


    public boolean insert(int index, char sign){
        if (isBusy(index)){
            return false;
        }
        board[index] = sign;
        return true;
    }

    public boolean isWin(){
        return (board[1] == board[2] && board[1] == board[3] ||
                board[4] == board[5] && board[4] == board[6] ||
                board[7] == board[8] && board[7] == board[9] ||
                board[1] == board[4] && board[1] == board[7] ||
                board[2] == board[5] && board[2] == board[8] ||
                board[3] == board[6] && board[3] == board[9] ||
                board[1] == board[5] && board[1] == board[9] ||
                board[3] == board[5] && board[3] == board[7]);
    }

    public boolean isFull(){
        for (int i = 1; i < board.length; i++){
            if (!isBusy(i)){
                return false;
            }
        }
        return true;
    }

    public boolean isDraw(){
        return (isFull() && !isWin());
    }

}
