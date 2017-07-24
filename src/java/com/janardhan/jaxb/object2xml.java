/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.janardhan.jaxb;

import java.io.FileOutputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

/**
 *
 * @author janardhan
 */
public class object2xml {

    public static void main(String[] args) throws Exception {
        JAXBContext contextObj = JAXBContext.newInstance(samplejaxb.class);
        Marshaller marshallerObj = contextObj.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        samplejaxb emp1 = new samplejaxb(1, "janardhan randhi", 50000);
        marshallerObj.marshal(emp1, new FileOutputStream("sample.xml"));
        
        

    }

}
