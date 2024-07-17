package xogame;

import java.util.Scanner;

public class XOGame {

    private Player one, two;

    private XOBoard board = new XOBoard();

    private Scanner scanner = new Scanner(System.in);
    void get_info(){
        one = new Player();
        two = new Player();
        //Player one data
        System.out.print("Please enter player's one name: ");
        one.name = scanner.nextLine();
        System.out.print("Please choose a sign (x/o): ");
        String one_sign = scanner.nextLine();
        one.sign = Character.toLowerCase(one_sign.charAt(0));

        //validation on sign
        while (!Validation.sign_validation(one.sign)){
            System.out.println("Please choose a proper sign!");
            System.out.print("Please choose a sign: ");
            one_sign = scanner.nextLine();
            one.sign = Character.toLowerCase(one_sign.charAt(0));
        }

        //player two data
        System.out.print("Please enter player's two name: ");
        two.name = scanner.nextLine();

        two.sign = (one.sign == 'x' ? 'o' : 'x');


    }


    boolean player_turn(Player player){
        int index;
        //Player's one turn

        //take index
        System.out.printf("Player's %s turn: ", player.name);
        index = Validation.index_input(player.name);

        //insert the move
        while (!board.insert(index, player.sign)){
            System.out.println("Busy!");
            System.out.print("Choose another place: ");
            index = Validation.index_input(player.name);
        }

        //draw board
        board.draw();

        //check isWin
        if (board.isWin()){
            System.out.printf("Player %s won!\n", player.name);
            return true;
        }
        //check isDraw
        if (board.isDraw()){
            System.out.println("Draw!");
            return true;
        }
        return false;
    }

    public void play(){
        boolean firstTurn = true;
        char flag = 'y';
        while (flag == 'y' || flag == 'Y'){

            if (firstTurn){
                //setup for the game
                get_info();
                board.set_board();
                board.draw();
                firstTurn = false;
            }

            boolean done = false;
            while (!board.isFull() && !done){
                int index;
                //Player's one turn

                done = player_turn(one);

                if (done){
                    break;
                }

                //Player's two turn

                done = player_turn(two);

            }

            System.out.print("Do you want to play again? (y/n): ");
            String Flag = scanner.nextLine();
            flag = Flag.charAt(0);
            firstTurn = true;
        }
    }
}
