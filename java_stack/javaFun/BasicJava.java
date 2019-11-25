import java.util.ArrayList;
import java.util.Arrays;

public class BasicJava {
    public void print1_255(){
        for (int i=1;i<256;i++){
            System.out.println(i);
        }
    }
    public void printOdd1_255(){
        for (int i=1;i<256;i++){
            if (i%2==1)
            System.out.println(i);
        }
    }
    public void printSum(){
        int sum = 0;
        for (int i=0;i<256;i++){
            sum = sum + i;
            System.out.println("New number: " + i + " Sum: "+ sum);
        }
    }
    public void iterateArray(int[] intArray){
        for (int i=0;i<intArray.length;i++){
            System.out.println(intArray[i]);
        }
    }
    public void findMax(int[] intArray){
        int max = intArray[0];
        for (int i=0;i<intArray.length;i++){
            if (intArray[i]>max){
                max = intArray[i];
            }
        }
        System.out.println(max);
    }
    public void getAverage(int[] intArray){
        int sum = 0;
        for (int i=0;i<intArray.length;i++){
            sum = sum + intArray[i];
            }
        double average = (double) sum/ (double) intArray.length;
        System.out.println(average);
    }
    public ArrayList<Integer> arrayOdd() {
    ArrayList<Integer> y = new ArrayList<Integer>();
    for (int i=0;i<256;i++){
            if (i%2==1){
                y.add(i);
            }}
        return y;   
    }
    public int greaterThan(int[] array, int i) {
        int count = 0;
        for(int element : array){
            if (element>i){
                count += 1;
            }
        }
        return count;
    }
    public ArrayList<Integer> squareValues(int[] array) {
        ArrayList<Integer> output_array = new ArrayList<Integer>();
        for(int i=0;i<array.length;i++){
            int temp_val = array[i];
            output_array.add(temp_val * temp_val);
            }
        return output_array;
        }
    public ArrayList<Integer> eliminateNegatives(int[] array) {
        ArrayList<Integer> output_array = new ArrayList<Integer>();
        for (int i=0;i<array.length;i++){
            if(array[i]<0){
                output_array.add(0);}
            else{
                output_array.add(array[i]);
            }
            }
        return output_array;

        }
    public ArrayList<Object> returnStats(int[] array) {
        ArrayList<Object> output_array = new ArrayList<Object>();
        int sum = 0;
        int max = array[0];
        int min = array[0];
        for (int i=0;i<array.length;i++){
            sum = sum + array[i];
            if(array[i]<min){
                min = array[i];}
            if (array[i]>max){
                max = array[i];}
            }
        double avg = (double) sum/(double) array.length;
        output_array.add(max);
        output_array.add(min);
        output_array.add(avg);
        return output_array;
            }
    public ArrayList<Integer> shiftArray(int[] array) {
        ArrayList<Integer> output_array = new ArrayList<Integer>();
        for (int i=1;i<array.length;i++){
            output_array.add(array[i]);
            }
        output_array.add(0);
        return output_array;

        }

    public static void main(String[] args){
        BasicJava bJ = new BasicJava();
        bJ.print1_255();
        System.out.println("Next Test");
        bJ.printOdd1_255();
        System.out.println("Next Test");
        bJ.printSum();
        System.out.println("Next Test");
        int[] myArray = {4, 8, 8, 5, 9};
        bJ.iterateArray(myArray);
        System.out.println("Next Test");
        bJ.findMax(myArray);
        System.out.println("Next Test");
        bJ.getAverage(myArray);
        System.out.println("Next Test");
        ArrayList<Integer> y = bJ.arrayOdd();
        System.out.println(y);
        System.out.println("Next Test");
        System.out.println(bJ.greaterThan(myArray, 6));
        System.out.println("Next Test");
        System.out.println(bJ.squareValues(myArray));
        System.out.println("Next Test");
        int[] arrayWithNegatives = {-4, 8, -8, 5, 9};
        System.out.println(Arrays.toString(arrayWithNegatives));
        System.out.println(bJ.eliminateNegatives(arrayWithNegatives));
        System.out.println("Next Test");
        System.out.println(Arrays.toString(myArray));
        System.out.println(bJ.returnStats(myArray));
        System.out.println("Next Test");
        System.out.println(Arrays.toString(myArray));
        System.out.println(bJ.shiftArray(myArray));}
}