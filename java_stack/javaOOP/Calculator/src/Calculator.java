
public class Calculator {
	private double operandOne;
	private double operandTwo;
	private char operation;
	private double result;
	public void setOperandOne(double num1) {
		operandOne = num1;
	}
	public void setOperandTwo(double num2) {
		operandTwo = num2;
	}
	public void setOperation(char c) {
		operation = c;
	}
	public void performOperation() {
		if (operation == '+'){
			result = operandOne + operandTwo;
		}
		else if (operation == '-') {
			result = operandOne - operandTwo;
		}
	}
	public double getResults() {
		return result;
	}
}
