/*******************************************************************************
 * File Name:		Button.java
 * Project:			Percussion Lab
 * 
 * Designer(s):		Garrett Cross
 * 					Omar Kermiche
 * 					Autumn Nguyen
 * 					Thomas Pridy
 * 
 * Copyright © 2019. All rights reserved.
 ******************************************************************************/
package percussionLab;

import ddf.minim.*;
import processing.core.*;

/** The <tt>Button</tt> class represents a visual button with
 *  on mouseClick features.
 * 
 * @author  Thomas Pridy,
 *          Autumn Nguyen,
 *          Garrett Cross,
 *          Omar Kermiche
 * @version 0.1.0
 * @since   10/03/2019
 *
 */
public class Button 
{
    /** parent PApplet that will be rendered */
    PApplet parent;
    
    /** CONSTANT width of <tt>Button</tt> */
    private static final char WIDTH  = 100; 
    /** CONSTANT height of <tt>Button</tt> */
    private static final char HEIGHT =  50;

    /** x-coord of <tt>Button</tt> */
    private int  x;
    /** y-coord of <tt>Button</tt> */
    private int  y;
    /** width of <tt>Button</tt> */
    private char w;
    /** height of <tt>Button</tt> */
    private char h;
    
    /** sound of <tt>Button</tt> */
    private AudioSample sound;
    /** label of <tt>Button</tt> */
    private String label;
    
    public Boolean hover = false;
    
    /** Creates a <tt>Button</tt>
     * @param x : x-coord of the <tt>Button</tt>
     * @param y : y-coord of the <tt>Button</tt>
     * @param filename : the filename of an audio file
     * @param label : the label of the <tt>Button</tt>
     */
    public Button(int x, int y, AudioSample sound, String label, PApplet p)
    {
        this.parent = p;
        this.x      = x;
        this.y      = y;
        this.w      = WIDTH;
        this.h      = HEIGHT;
        this.label  = label;
        this.sound  = sound;
    }
    
    //************************************************************************//
    //  Methods                                                               //
    //************************************************************************//
    
    /** Determines whether or not the cursor is within the <tt>Button</tt>
     * @param mx : mouse x-coord
     * @param my : mouse y-coord
     * @return <b>boolean</b> : true if the cursor is within the <tt>Button</tt>
     */
    Boolean isInside(int mx, int my)
    {
        // Variable to hold flag
        Boolean inside = false; 
        
        // is the mouse within x-coords
        if ((mx >= this.x) && (mx <= this.x + this.w))
        {
         // is the mouse within y-coords
            if ((my >= this.y) && (my <= this.y + this.h)) 
            {
                inside = true;
            }
        }
        return inside;
    }
    
    /** Displays the <tt>Button</tt> rectangles and label */
    public void display()
    {
        // Rectangles
        if (this.hover)
        {
            parent.fill(100,100,100);
        } 
        else
        {
            parent.fill(0, 0, 0);
        }
        parent.rect(this.x, this.y, this.w, this.h);
        
        // Labels
        parent.fill(255,255,255);
        parent.text(this.label, this.x + (this.w/4), this.y + (this.h/2) + 5);
    }
    
    /** Plays the sound when this method is called */
    public void press()
    {   
        this.sound.trigger();
    }
    
    /** Closes the audio object that was opened */
    public void quit()
    {
        this.sound.close();
    }
}
