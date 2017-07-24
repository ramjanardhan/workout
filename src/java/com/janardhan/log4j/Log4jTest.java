/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.janardhan.log4j;

import java.io.IOException;
import org.apache.log4j.Appender;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.SimpleLayout;
import org.jboss.logging.Logger;

/**
 *
 * @author janardhan
 */
public class Log4jTest {
    
    static Logger l=Logger.getLogger(Log4jTest.class);
  
    public static void main(String[] args) throws IOException {
          BasicConfigurator.configure();
        System.out.println("log4j demo");
        
        l.debug("jana");
        l.info("jana");
        l.warn("jana");
        l.error("jana");
        l.fatal("jana");
        
//        Layout  l1= new SimpleLayout();
//        Appender a=new FileAppender(l1,"jana.txt",false);
//     l.Appender(a);       
    }
    
    
}
