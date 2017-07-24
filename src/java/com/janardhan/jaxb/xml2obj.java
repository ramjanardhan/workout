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
public class xml2obj {

    public static void main(String[] args) {
        try {
            File file = new File("sample.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(samplejaxb.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            samplejaxb e = (samplejaxb) jaxbUnmarshaller.unmarshal(file);
            System.out.println(e.getId() + " " + e.getName() + " " + e.getSalary());
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

}
