import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Controller implements ChangeListener
{
	private View view;
	private JFrame frame;
	private Component calculator, menu;

	public Controller(View v)
	{
		frame = new JFrame();
		view = v;
	}

	public void setFrame()
	{
		calculator = new JScrollPane(view.getCalculatorPanel());
		menu = new JScrollPane(view.getMenuPanel());
		frame.setLayout(new BorderLayout());
		frame.add(calculator, BorderLayout.CENTER);
		frame.add(menu, BorderLayout.WEST);
	}

	public void startFrame()
	{
		frame.setSize(500, 150);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	@Override
	public void stateChanged(ChangeEvent arg0)
	{
		frame.remove(calculator);
		frame.remove(menu);
		setFrame();
//		startFrame();
		frame.setVisible(true);
	}

}
