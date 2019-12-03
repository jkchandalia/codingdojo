
public class CalculatorTest {
	public static void main(String[] args) {
		Calculator c = new Calculator();
		c.setOperandOne(8.8);
		c.setOperandTwo(3.2);
		c.setOperation('-');
		c.performOperation();
		System.out.println(c.getResults());
	}

}
