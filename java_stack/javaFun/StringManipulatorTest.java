public class StringManipulatorTest {
    public static void main(String[] args){
        StringManipulator sM = new StringManipulator();
        System.out.println(sM.trimAndConcat("  Hello  ", "  World  "));
        System.out.println(sM.getIndexOrNull("Hello", 'w'));
        System.out.println(sM.getIndexOrNull("Hello", 'H'));
        System.out.println(sM.getIndexOrNull("Hello", "H"));
        System.out.println(sM.getIndexOrNull("Hello", "ll"));
        System.out.println(sM.getIndexOrNull("Hello", "wll"));
        System.out.println(sM.concatSubstring("Hello", 1, 2, "world"));
    } 
}