/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.janardhan.jaxb;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author janardhan
 */
public class xml2obj2 {

    public static void main(String[] args) throws JAXBException {
        try {
            File f = new File("jana.xml");
            JAXBContext jaxb = JAXBContext.newInstance(jaxb.class);
            Unmarshaller unmar = jaxb.createUnmarshaller();
            jaxb j = (jaxb) unmar.unmarshal(f);
            System.out.println(j.getId() + "$$$" + j.getName() + "$$$" + j.getAdderess() + "$$$" + j.getBlog());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
