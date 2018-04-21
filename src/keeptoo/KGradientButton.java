/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keeptoo;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.beans.ConstructorProperties;
import javax.swing.Action;
import javax.swing.DefaultButtonModel;
import javax.swing.Icon;
import javax.swing.JButton;

/**
 *
 * @author terro
 */
public class KGradientButton extends JButton implements KGradient {

    public Color StartColor = Color.MAGENTA;
    public Color EndColor = Color.BLUE;
    public boolean TransparentControls = true;
    public int gradientFocus = 500;
  //  private boolean resizablelabel = false;
    public static final String DEFAULT_TEXT = "Button";
    public static final Font DEFAULT_FONT = new Font("Serif", Font.BOLD, 14);
    private String text = DEFAULT_TEXT;
    private ResizeLabelFont rlbf= new ResizeLabelFont(text);
    public Font font = DEFAULT_FONT;
    private Color ForegroundColor = new Color(0);
   
    
    //*****************CONSTRUCTORS*****************//
    /**
     * Creates a button with no set text.
     */
    public KGradientButton() {}

  

    /**
     * Creates a button with text.
     *
     * @param text  the text of the button
     */
    @ConstructorProperties({"text"})
    public KGradientButton(String text) {
        setText(text);
    }

    /**
     * Creates a button where properties are taken from the
     * <code>Action</code> supplied.
     *
     * @param a the <code>Action</code> used to specify the new button
     *
     * @since 1.3
     */
    public KGradientButton(Action a) {
        this();
        setAction(a);
    }

    //*****************END CONSTRUCTORS*****************//
    
    @Override
    public void setText(String text){
       this.text = text;
       revalidate();
       repaint();
    }
    
    
    public void setFont(String name,int style, int size){
        font = new Font(name,style,size);
    }
    
    @Override
    public Font getFont(){
        return font;
    }

    public Color getStartColor() {
        return StartColor;
    }

    public void setStartColor(Color StartColor) {
        this.StartColor = StartColor;
        invalidate();
    }

    public Color getEndColor() {
        return EndColor;
    }

    public void setEndColor(Color EndColor) {
        this.EndColor = EndColor;
        invalidate();
    }

    public int getGradientFocus() {
        return gradientFocus;
    }

    public void setGradientFocus(int gradientFocus) {
        this.gradientFocus = gradientFocus;
        invalidate();
    }

    public boolean isTransparentControls() {
        return TransparentControls;
    }

    public void setTransparentControls(boolean TransparentControls) {
        this.TransparentControls = TransparentControls;
        invalidate();
    }
    
    public void setForeground(Color color){
        ForegroundColor = color;
        revalidate();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int w = getWidth();
        int h = getHeight();
        GradientPaint gp = new GradientPaint(0, 0, StartColor, gradientFocus, h, EndColor);;
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        //if(!resizablelabel)
            drawCenteredText(g, this.getBounds().width/2, this.getBounds().height/2, text);
    }
    
    private void drawCenteredText(Graphics g, int x, int y, String texto){
        g.setFont(font);
        FontMetrics fm = g.getFontMetrics();
        java.awt.geom.Rectangle2D rect = fm.getStringBounds(texto, g);
        g.setColor(ForegroundColor);
        int textHeight = (int) (rect.getHeight());
        int textWidth = (int) (rect.getWidth());
        int cornerX = x - (textWidth / 2);
        int cornerY = y - (textHeight / 2) + fm.getAscent();
        g.drawString(texto, cornerX, cornerY);  
    }   
}
