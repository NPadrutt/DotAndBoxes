/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotandboxes;

import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author Nino
 */
public class BoxTest {

    @Test
    public void TestBoxLineContstructor_PositionLeft() {
        Line line = new Line();
        
        Box box = new Box(line, Line.POSITION_LEFT);
        
        Assert.assertEquals(line, box.getLeftLine());
    }

    @Test
    public void TestBoxLineContstructor_PositionUpper() {
        Line line = new Line();
        
        Box box = new Box(line, Line.POSITION_UPPER);
        
        Assert.assertEquals(line, box.getUpperLine());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void TestBoxLineContstructor_InvalidPosition() {
        Line line = new Line();     
        Box box = new Box(line, "Bottom");
    }
}
