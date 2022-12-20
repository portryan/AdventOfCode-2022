import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
public class Day3{
    public static void main(String[] args) throws FileNotFoundException {
        // Part 1

        File f = new File("input.txt");
        Scanner input = new Scanner(f);
        int sum = 0;
        while (input.hasNextLine()){
            String l = input.nextLine();
            int len = l.length();

            String first = l.substring(0, (len/2));
            String second = l.substring((len/2));

            HashSet<Character> items = new HashSet<Character>();
            ArrayList<Character> itemsList = new ArrayList<Character>();
            for (int i = 0; i < first.length(); i++){
                items.add(first.charAt(i));
            }

            for (int i = 0; i < second.length(); i++){
                if (items.contains(second.charAt(i))){
                    itemsList.add(second.charAt(i));
                    break;
                }
            }

            for (char item : itemsList){
                if (item <= 90){
                    sum += (item-38);
                }else{
                    sum += (item-96);
                }
            }
        }
        input.close();
        System.out.println("Part 1: " + sum);

        // Part 2

        input = new Scanner(f);
        sum = 0;
        while (input.hasNextLine()){
            HashSet<Character> items = new HashSet<Character>();
            String l = input.nextLine();
            for (int i = 0; i < l.length(); i++){
                items.add(l.charAt(i));
            }

            for (int i = 0; i < 2; i++){
                HashSet<Character> itemDuplicates = new HashSet<Character>();
                l = input.nextLine();
                for (int j = 0; j < l.length(); j++){
                    if (items.contains(l.charAt(j))){
                        itemDuplicates.add(l.charAt(j));
                    }
                }
                items = itemDuplicates;
            }

            for (char item : items){
                if (item <= 90){
                    sum += (item-38);
                }else{
                    sum += (item-96);
                }
            }
        }
        input.close();
        System.out.println("Part 2: " + sum);
    }
}