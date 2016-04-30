package Objects;

import javax.swing.JComponent;

public interface Formula 
{
	JComponent getComponent();
	String solve(double[] values);
	String getFormulaName();
}
