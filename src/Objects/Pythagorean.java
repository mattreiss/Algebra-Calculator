package Objects;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Pythagorean implements Formula
{
	private static final int VALUES_NEEDED = 2;
	
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
	public String solve(double[] values) 
	{
		if (values == null || values.length < VALUES_NEEDED)
		{
			throw new UnsupportedOperationException();
		}

		double a = values[0];
		double b = values[1];
		double c = values[2];

		String answer = "no real solution";
		if (a == 0)
		{
			//solve for a
			double a2 = c*c - b*b;
			if (a2 > 0) answer = "" + Math.sqrt(a2);
		} else if (b == 0)
		{
			//solve for b
			double b2 = c*c - a*a;
			if (b2 > 0) answer = "" + Math.sqrt(b2);
		} else
		{
			//solve for c
			double c2 = a*a + b*b;
			if (c2 > 0) answer = "" + Math.sqrt(c2);
		}
		
		return answer;
	}

	@Override
	public String getFormulaName() {
		return "Pythagorean Theorem";
	}

}
