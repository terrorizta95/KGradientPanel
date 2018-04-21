/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keeptoo;

import java.awt.Color;

/**
 *
 * @author terro
 */
public interface KGradient {
    
    public Color getStartColor();

    public void setStartColor(Color StartColor);
    
    public Color getEndColor() ;

    public void setEndColor(Color EndColor);

    public int getGradientFocus();

    public void setGradientFocus(int gradientFocus) ;

    public boolean isTransparentControls() ;

    public void setTransparentControls(boolean TransparentControls);

}
