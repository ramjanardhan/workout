/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.janardhan.jaxb;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author janardhan
 */
public class jaxb1 {

    public static void main(String[] args) throws JAXBException, FileNotFoundException {

        JAXBContext jaxb = JAXBContext.newInstance(jaxb.class);
        Marshaller mar = jaxb.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxb jax = new jaxb(10, "janardhan", "psr puram", "techgig");
        mar.marshal(jax, new FileOutputStream("jana.xml"));
    }

}
