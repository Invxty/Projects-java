
import java.util.Scanner;

public class Tictactoe{

    public static void table(String[][] charac){ //PRINTS THE TABLE
        for(int i = 0; i<charac.length; i++){
            for(int j = 0; j<charac[i].length;j++){
                System.out.print("|" + charac[i][j] + "|");
           
        }
        System.out.println("");
        }
    }

    public static boolean CheckBoard(int[] chosen){ //CHECKS IF THE TABLE IS FILLED(ONLY USED WHEN THERE ISNT A WINNER)
        int counter = 0;
        boolean fill = false;
        for(int i = 0; i<chosen.length; i++){
            if(chosen[i] != 0){
                counter++;
                fill = false;
            }
        }
        if(counter ==9){
        fill = true;
        }
        return fill;
    }

    public static boolean Winners(String[][] charac, boolean winner){ //CHECKS IF THERE IS A WINNING COMBINATION BASED ON THE 8 WIN COMBINATIONS
        boolean winconsX = false;
        boolean winconsO = false;
        for(int i = 0; i < 8;i++){
            String line ="";
            switch(i){
                case 0:
                line = charac[0][1] + charac[0][0] + charac[0][2];
                break;

                case 1:
                line = charac[1][1] + charac[1][0] + charac[1][2];
                break;

                case 2:
                line = charac[2][1] + charac[2][0] + charac[2][2];
                break;

                case 3:
                line = charac[1][0] + charac[0][0] + charac[2][0];
                break;

                case 4:
                line = charac[1][1] + charac[0][1] + charac[2][1];
                break;

                case 5:
                line = charac[0][2] + charac[1][2] + charac[2][2];
                break;

                case 6:
                line = charac[0][0] + charac[1][1] + charac[2][2];
                break;

                case 7:
                line = charac[0][2] + charac[1][1] + charac[2][0];
                break;
            }
            if(line.equals("XXX")){
                winconsX = true;
            }

            else if(line.equals("OOO")){
                winconsO = true;
            }
        }
        if(winconsO || winconsX){
            winner = true;
            if(winconsX){
                System.out.println("Player 1 wins!");
            }
            else if(winconsO){
                System.out.println("Player 2 wins!");
            }
        }
        return winner;
    }

 public static void players(String[][] charac, int n, int rounds){ //INPUTS FOR PLAYER
        String symbol;
        if(rounds % 2 == 0){
            symbol = "X";
        }
        else{
            symbol = "O";
        }
         if(n < 10){
        switch(n){
            case 1:
                charac[0][0] = symbol;
                break;
            case 2:
                charac[0][1] = symbol;
                break;
            case 3:
                charac[0][2] = symbol;
                break;
            case 4:
                charac[1][0] = symbol;
                break;
            case 5:
                charac[1][1] = symbol;
                break;
            case 6:
                charac[1][2] = symbol;
                break;
            case 7:
                charac[2][0] = symbol;
                break;
            case 8:
                charac[2][1] = symbol;
                break;
            case 9:
                charac[2][2] = symbol;
                break;
            default:
                System.out.println("Not a valid number");               

        }
    }
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] charac = {{"1","2","3"}, {"4","5","6"}, {"7","8","9"}};
        int[] chosen = new int[9]; //used to store already chosen slots so it doenst repeat
        int y = 0; //used for index in already chosen numbers array
        int rounds = 0; //used to determine the number of rounds(also used to determine if the current player is X or O)
        boolean isContained = false;
        boolean winner = false;
        boolean filled;
        boolean played;
        System.out.println("Welcome to Tictactoe");
        table(charac);

    while(winner != true){
        played = false;
        while(!played){
            System.out.print("Player 1(X), please select a number(1-9): ");
            int n = sc.nextInt();

            if(n<=9){
                for(int i = 0; i <chosen.length;i++){
                    if(n==chosen[i]){
                        isContained = true;
                        break;
                    }
                }

                    if(isContained){
                        System.out.println("Slot has been filled, please choose another.");
                        isContained = false;
                    }
                    else{
                    players(charac, n, rounds);
                    table(charac);
                    winner = Winners(charac, winner);
                    chosen[y] = n;
                    y++;
                    rounds++;
                    played = true;
                }   
            }
            
            else{
                System.out.println("Please choose a valid number.");
            }
        }

        filled = CheckBoard(chosen);
        played = false;
        if(filled || winner)
        {break;}

        while(!played){
            System.out.print("Player 2(O), please select a number(1-9): ");
            int n = sc.nextInt();
            if(n<=9){
                for(int i = 0; i <chosen.length;i++){
                    if(n==chosen[i]){
                        isContained = true;
                        break;
                    }
                }

                if(isContained){
                    System.out.println("Slot has been filled, please choose another.");
                    isContained = false;
                }
                else{
                    players(charac, n, rounds);
                    table(charac);
                    winner = Winners(charac, winner);
                    chosen[y] = n;
                    y++;
                    rounds++;
                    played = true;
                    }
            }
            else{
                    System.out.println("Please choose a valid number.");
            }
        }
    }    
    if(!winner){
    System.out.println("The game is tied!");
    }
    sc.close();
    }

}
