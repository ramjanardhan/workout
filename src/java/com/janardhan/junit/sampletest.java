/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.janardhan.junit;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

/**
 *
 * @author janardhan
 */
public class sampletest {
    @Test
     public void testReverseWord(){  
        System.out.println("test case reverse word");  
        assertEquals("ym eman si nahk", sample.reverseWord("my name is khan"));  
    }  
}
