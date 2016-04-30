package Objects;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Quadratic implements Formula
{
	private static final int VALUES_NEEDED = 3;
	
	@Override
	/**
	 *  Solves the quadratic equation.
	 *  
	 *  @param values an array containing the inputed values.
	 *  @return the solution to the quadratic equation as a String.
	 */
	public String solve(double[] values) 
	{
		if (values == null || values.length < VALUES_NEEDED)
		{
			throw new UnsupportedOperationException();
		}

		double a = values[0];
		double b = values[1];
		double c = values[2];

		String answer = "no solution";
		double determinant = b*b - 4*a*c;
		if (determinant > 0)
		{
			double solution1 = (-b + Math.sqrt(determinant)) / (2*a);
			double solution2 = (-b - Math.sqrt(determinant)) / (2*a);
			answer = "" + solution1 +" or " + solution2;
		} else if (determinant == 0 && a != 0)
		{
			double solution = -b / (2*a);
			answer = "" + solution;
		}
		
		return answer;
	}

	@Override
	public JComponent getComponent() 
	{
		JComponent quadraticComponent = new JPanel();
		JTextField input1 = new JTextField("A");
		JTextField input2 = new JTextField("B");
		JTextField input3 = new JTextField("C");
		quadraticComponent.add(input1);
		quadraticComponent.add(input2);
		quadraticComponent.add(input3);
		return quadraticComponent;
	}

	@Override
	public String getFormulaName() {
		return "Quadratic Formula";
	}

	
}
