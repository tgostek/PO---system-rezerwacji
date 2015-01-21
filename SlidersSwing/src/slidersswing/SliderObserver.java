/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package slidersswing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JSlider;

/**
 *
 * @author tomaszgostek
 */
public class SliderObserver {
    
    private List<JSlider> sliders;
    
    public SliderObserver() {
        this.sliders = new ArrayList<>();
    }
          
    public void addSlider(JSlider slider) {
        if (!this.sliders.contains(slider)) {
            this.sliders.add(slider);
        }
    }
    
    public void update(JSlider source) {
        Random generator = new Random(); 
        int ran = generator.nextInt(9) + 1;  
      
        do {
            ran = generator.nextInt(9) + 1;
        } while (this.sliders.get(ran).equals(source));
      
        JSlider random = this.sliders.get(ran);
        random.setInverted(true);
        int value = source.getValue();
        for (JSlider slider: this.sliders) {
            if (!slider.equals(source)) {
                slider.setValue(value);
            } 
        }
    }
}
