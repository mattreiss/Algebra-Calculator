import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Objects.Formula;
import Objects.Quadratic;

public class Model
{
    private ArrayList<ChangeListener> listeners = new ArrayList<ChangeListener>();
    public Formula formula;
    
    public Model()
    {
    	formula = new Quadratic();
    }
   
    public void attach(ChangeListener c)
    {
        listeners.add(c);
    }
    
    public void update()
    {
        for (ChangeListener l : listeners)
        {
            l.stateChanged(new ChangeEvent(this));
        }
    }
    
    public void update(Formula formula)
    {
    	this.formula = formula;
        for (ChangeListener l : listeners)
        {
            l.stateChanged(new ChangeEvent(this));
        }
    }
}