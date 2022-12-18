import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class Day1{
    public static void main(String[] args) throws FileNotFoundException {
        // Part 1

        File f = new File("input.txt");
        Scanner input = new Scanner(f);
        ArrayList<Integer> elfList = new ArrayList<Integer>();
        
        int sumofCals = 0;
        while (input.hasNextLine()){
            String l = input.nextLine();
            if (l.equals("") && input.hasNextLine()){
                elfList.add(sumofCals);
                sumofCals = 0;
            }else{
                int cal = Integer.parseInt(l);
                sumofCals += cal;
            }
        }
        elfList.add(sumofCals);
        input.close();
        
        Collections.sort(elfList);
        System.out.println("Part 1: " + elfList.get(elfList.size()-1));

        // Part 2

        sumofCals = 0;
        for (int i = 1; i <= 3; i++){
            sumofCals += elfList.get(elfList.size()-i);
        }

        System.out.println("Part 2: " + sumofCals);
    }
}