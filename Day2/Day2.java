import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Day2{
    public static void main(String[] args) throws FileNotFoundException{
        // Part 1

        /*  
        A = Rock        X = Rock
        B = Paper       Y = Paper
        C = Scissors    Z = Scissors
         */

        File f = new File("input.txt");
        Scanner input = new Scanner(f);
        int totalScore = 0;
        while (input.hasNextLine()){
            String l = input.nextLine();
            char opponent = l.charAt(0);
            char player = l.charAt(2);
            player -= 23;

            if (opponent == player){
                totalScore += 3;
            }else if(playerWins(opponent,player)){
                totalScore += 6;
            }

            if (player == 'A'){
                totalScore += 1;
            }else if (player == 'B'){
                totalScore += 2;
            }else{
                totalScore += 3;
            }
        }
        input.close();
        System.out.println("Part 1: " + totalScore);

        // Part 2

        totalScore = 0;

        /*  
        A = Rock        X = Lose
        B = Paper       Y = Draw
        C = Scissors    Z = Win
         */

        input = new Scanner(f);

        while (input.hasNextLine()){
            String l = input.nextLine();
            char opponent = l.charAt(0);
            char roundEnd = l.charAt(2);

            if (roundEnd == 'Y'){
                totalScore += 3;
                totalScore += scoreFromChoice(opponent);
            }else if (roundEnd == 'Z'){
                totalScore += 6;
                if (opponent == 'A'){
                    totalScore += scoreFromChoice('B');
                }else if (opponent == 'B'){
                    totalScore += scoreFromChoice('C');
                }else{
                    totalScore += scoreFromChoice('A');
                }
            }else{
                if (opponent == 'A'){
                    totalScore += scoreFromChoice('C');
                }else if (opponent == 'B'){
                    totalScore += scoreFromChoice('A');
                }else{
                    totalScore += scoreFromChoice('B');
                } 
            }
        }
        input.close();
        System.out.println("Part 2: " + totalScore);
    }

    public static boolean playerWins(char o, char p){
        if (o == 'A'){
            return p == 'B';
        }else if (o == 'B'){
            return p == 'C';
        }else{
            return p == 'A';
        }
    }

    public static int scoreFromChoice(char c){
        if (c == 'A'){
            return 1;
        }else if (c == 'B'){
            return 2;
        }else{
            return 3;
        }
    }
}