import java.util.ArrayList;
public class CalculatorTwo {
	ArrayList<Object> operands;
	private double result;
	public void performOperation(Object operand) {
		operands.add(operand);
	}
	public double getResults() {
		return result;
	}
}
