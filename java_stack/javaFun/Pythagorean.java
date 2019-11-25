public class Pythagorean {
    public double calculateHypotenuse(int legA, int legB) {
        double hypotenuse = Math.sqrt(legA*legA + legB*legB);
        return hypotenuse;// calculate the value of c given legA and legB
    }
}