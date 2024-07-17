package xogame;

import java.util.Scanner;

class Validation {

    static boolean sign_validation(char sign){

        return (sign == 'o' ||
                sign == 'O' ||
                sign == 'x' ||
                sign == 'X');
    }

    static boolean index_validation(int index){
        return (index >= 1 && index <= 9);
    }

    static int index_input(String player){
        int index;
        Scanner scanner = new Scanner(System.in);
        index = scanner.nextInt();
        while (!Validation.index_validation(index)){
            System.out.println("Please enter a proper index!");
            System.out.printf("Player %s turn: ", player);
            index = scanner.nextInt();
        }
        return index;
    }
}
