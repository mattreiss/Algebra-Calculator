import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Objects.Pythagorean;
import Objects.Quadratic;

public class View implements ChangeListener
{
	private Model model;
	private JPanel menuPanel;
	private JPanel calculatorPanel;

	public View(Model m)
	{
		model = m;
		initialize();
	}

	private void initialize() 
	{
		//initialize menu
		menuPanel = new JPanel();
		menuPanel.setLayout(new GridLayout(3,1));
		JLabel menuHeader = new JLabel();
		menuHeader.setText("Calculator Menu");
		menuPanel.add(menuHeader);

		
		//initialize calculator
		calculatorPanel = new JPanel();
		calculatorPanel.setLayout(new BorderLayout());
		
		final JLabel calculatorHeader = new JLabel();
		calculatorHeader.setText(model.formula.getFormulaName());
		calculatorPanel.add(calculatorHeader, BorderLayout.NORTH);
		
		JButton menuItem = new JButton();
		menuItem.setText("Quadratic");
		menuItem.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				model.update(new Quadratic());
				calculatorHeader.setText(model.formula.getFormulaName());
			}
		});
		menuPanel.add(menuItem);
		
		menuItem = new JButton();
		menuItem.setText("Pythagorean");
		menuItem.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				model.update(new Pythagorean());
				calculatorHeader.setText(model.formula.getFormulaName());
			}
		});
		menuPanel.add(menuItem);
		
		
		final JComponent formulaComponent = model.formula.getComponent();
		calculatorPanel.add(formulaComponent, BorderLayout.WEST);

		final JLabel calculatorAnswer = new JLabel();
		calculatorAnswer.setText("0");
		JPanel answerPanel = new JPanel();
		answerPanel.add(calculatorAnswer);
		calculatorPanel.add(answerPanel, BorderLayout.EAST);
		
		JButton calculateButton = new JButton("=");
		calculateButton.setPreferredSize(new Dimension(50, 25));
		calculateButton.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				int inputCount = formulaComponent.getComponentCount();
				double[] inputs = new double[inputCount];
				for (int i = 0; i < inputCount; i++)
				{
					double input = 0;
					try
					{	
						JTextField tf = (JTextField) formulaComponent.getComponent(i);
						input = Double.parseDouble(tf.getText());
					}
					catch (Exception exception)
					{
						System.out.println("Can't parse component's input");
					}
					inputs[i] = input;
				}
				System.out.println("Solving: " + inputs[0] +", " + inputs[1] +", " + inputs[2]);
				calculatorAnswer.setText(model.formula.solve(inputs));
			}
		});
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(calculateButton);
		calculatorPanel.add(buttonPanel, BorderLayout.CENTER);
		
		
		
	}

	@Override
	public void stateChanged(ChangeEvent arg0)
	{
	}

	public JPanel getMenuPanel() 
	{
		return menuPanel;
	}

	public JPanel getCalculatorPanel() 
	{
		return calculatorPanel;
	}

}
