/*******************************************************************************
 * File Name:		PercussionLab.java	
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

public class PercussionLab extends PApplet
{
    public static void main(String[] args)
    {
        PApplet.main("percussionLab.PercussionLab");
    }
    
    /** array of <tt>Button</tt> objects */
    Button[] buttons = new Button[2];
    
    public void settings()
    {
        size(400,300);
    }
    
    public void setup()
    {
        /** audio library object */
        Minim minim = new Minim(this);
        
        /** cymbal sound */
        AudioSample cymbal = minim.loadSample("data/cymbal.wav");
        /** drum sound */
        AudioSample drum = minim.loadSample("data/drum.wav");

        fill(255,0,0);
        noStroke();
        smooth();
        
        buttons[0] = new Button(50, 120, drum, "Drum", this);
        buttons[1] = new Button(250, 120, cymbal, "Cymbal", this);
    }
    
    public void draw()
    {
        background(255);
        for (int i = 0; i < buttons.length; ++i)
        {
            buttons[i].display();
        }
    }
    
    public void mouseMoved()
    {
        for (int i = 0; i < buttons.length; ++i)
        {
            if (buttons[i].isInside(mouseX, mouseY))
            {
                buttons[i].hover = true;
            }
            else
            {
                buttons[i].hover = false;
            }
        }
    }
    
    public void mousePressed()
    {
        for (int i = 0; i < buttons.length; ++i)
        {
            if (buttons[i].isInside(mouseX, mouseY))
            {
                buttons[i].press();
            }
        }
    }
    
    public void stop()
    {
        for (int i = 0; i < buttons.length; ++i)
        {
            buttons[i].quit();
        }
        super.stop();
    }
}
