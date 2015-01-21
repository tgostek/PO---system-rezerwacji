
package slidersswing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.*;
import javax.swing.event.*;

public class ManagerGUI 
{
    private JFrame frame = null;
    private JPanel main_panel = null;
    
    public ManagerGUI()
    {
        this.frame = new JFrame("Sliders World");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1300, 600);
        
        this.main_panel = new JPanel();
        this.main_panel.setLayout(new BoxLayout(this.main_panel, BoxLayout.Y_AXIS));
        
        this.frame.getContentPane().add(this.main_panel);
        
        for(int i = 0; i < 10; i++)
            addSlider();
    }
    
     private List<JSlider> sliders = new ArrayList<>();
    
    public void notifyAllSliders()
    {
        Random generator = new Random();
        
        JSlider random = this.sliders.get(generator.nextInt(9));
        
        random.setInverted(true);
        int value = source.getValue();
        for (JSlider slider: this.sliders) {
            if (!slider.equals(source)) {
                slider.setValue(value);
            } 
        }
    }
    
    private JSlider source = null;
    
    void setSource(JSlider slider)
    {
        if( (source != null) && (!slider.equals(source)))
        {
            this.source.setInverted(false);
        }
        
        
        this.source = slider;
        notifyAllSliders();
    }

    public void addSlider() 
    {
        JSlider slider = new JSlider();
        
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(20);
        
        ChangeListener listener = new ChangeListener() {
                public void stateChanged(ChangeEvent e) 
                    {
                        setSource((JSlider)e.getSource());
                    }
            };
        
        slider.addChangeListener(listener);
        
        this.main_panel.add(slider);
        this.sliders.add(slider);
    }
    
    public void startGUI()
    {
        this.frame.setVisible(true);
    }
}
