import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class PuzzleJava {
    public ArrayList<Integer> printReturn(){
        int[] array = {3,5,1,2,7,9,8,13,25,32};
        int sum = 0;
        ArrayList<Integer> output_array = new ArrayList<Integer>();
        for (int i=0;i<array.length;i++){
            sum += array[i];
            if (array[i]>10){
                output_array.add(array[i]);
            }
        }
        System.out.println(sum);
        return output_array;

    }
    public ArrayList<String> nameShuffle(){
        ArrayList<String> array = new ArrayList<String>(Arrays.asList("Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"));
        ArrayList<String> output_array = new ArrayList<String>();
        Collections.shuffle(array);
        for (String item:array){
            System.out.println(item);
            if (item.length()>5){
            output_array.add(item);
            }

        }
        return output_array;
    }    
    public void alphabetShuffle(){
        ArrayList<Character> alpha_array = new ArrayList<Character>();
        ArrayList<Character> vowels = new ArrayList<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        char c;
        for(c = 'a'; c <= 'z'; ++c){
            alpha_array.add(c);}
        Collections.shuffle(alpha_array);
        System.out.println("The last letter is now: "+ alpha_array.get(25));
        System.out.println("The first letter is now: "+ alpha_array.get(0));
        // boolean test = Arrays.asList(vowels).contains('o');
        if ("aeiou".contains(String.valueOf(alpha_array.get(0)))){
        System.out.println("First letter is a vowel.");}


    }
    public ArrayList<Integer> returnRandArray(){
        ArrayList<Integer> output_array = new ArrayList<Integer>();
        Random r = new Random();
        for (int i=0;i<10;i++){
        output_array.add(r.nextInt(45)+55);}
        return output_array;
    }
    public void returnRandSort(){
        ArrayList<Integer> output_array = new ArrayList<Integer>();
        Random r = new Random();
        for (int i=0;i<10;i++){
        output_array.add(r.nextInt(45)+55);}
        Collections.sort(output_array);
        System.out.println(output_array);
        System.out.println("The min number is: " + output_array.get(0));
        System.out.println("The max number is: " + output_array.get(9));
    }
    public String returnRandStr(){
        ArrayList<Character> alpha_array = new ArrayList<Character>();
        String output_str = "";
        char c;
        for(c = 'a'; c <= 'z'; ++c){
            alpha_array.add(c);}
        Random r = new Random();
        for (int i=0;i<5;i++){
        output_str += Character.toString(alpha_array.get(r.nextInt(26)));}
        return output_str;
    }
    public ArrayList<String> returnRandStrArray(){
        ArrayList<String> output_array = new ArrayList<String>();
        PuzzleJava pJ = new PuzzleJava();
        // ArrayList<Character> alpha_array = new ArrayList<Character>();
        // String output_str = "";
        // char c;
        // for(c = 'a'; c <= 'z'; ++c){
        //     alpha_array.add(c);}
        // Random r = new Random();
        // for (int i=0;i<5;i++){
        // output_str += Character.toString(alpha_array.get(r.nextInt(26)));}
        for (int i=0;i<10;i++){
            output_array.add(pJ.returnRandStr());}
        return output_array;
    }
    public static void main(String[] args){
        PuzzleJava pJ = new PuzzleJava();
        System.out.println("Next Test");
        ArrayList<Integer> output = pJ.printReturn();
        System.out.println(output);
        System.out.println("Next Test");
        ArrayList<String> output_name = pJ.nameShuffle();
        System.out.println(output_name);
        System.out.println("Next Test");
        pJ.alphabetShuffle();
        System.out.println("Next Test");
        System.out.println(pJ.returnRandArray());
        System.out.println("Next Test");
        pJ.returnRandSort();
        System.out.println("Next Test");
        System.out.println(pJ.returnRandStr());
        System.out.println("Next Test");
        System.out.println(pJ.returnRandStrArray());
       
    }
}