package com.bdonor.ParseXml;
import java.io.*;
import java.util.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xmlpull.v1.*;

import com.bdonor.Data.Data;

public class ParseBooks {

	public static void mainprint(String xmlRecords) {
		
        Data bdonor = null;
        ArrayList<Data> donorList = null;

        try {
            // Initialize XmlPullParser
            XmlPullParserFactory xppFactory = XmlPullParserFactory.newInstance();
            XmlPullParser xmlPullParser = xppFactory.newPullParser();
            xmlPullParser.setInput(new StringReader(xmlRecords));

            int eventType = xmlPullParser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if ("datas".equals(xmlPullParser.getName())) {
                            donorList = new ArrayList<Data>();
                        }

                        if ("BDonor".equals(xmlPullParser.getName())) {
                            bdonor = new Data();
                           // book.setISBN(xmlPullParser.getAttributeValue(XmlPullParser.NO_NAMESPACE, "ISBN"));
                        }
                        if ("id".equals(xmlPullParser.getName())) {
                            String id = xmlPullParser.nextText();
                            bdonor.setId(Integer.parseInt(id));
                        }
                        if ("name".equals(xmlPullParser.getName())) {
                            String name = xmlPullParser.nextText();
                            bdonor.setName(name);
                        }

                        if ("bgroup".equals(xmlPullParser.getName())) {
                            String bgroup = xmlPullParser.nextText();
                            bdonor.setBgroup(bgroup);
                        }

                        if ("gender".equals(xmlPullParser.getName())) {
                            String gender = xmlPullParser.nextText();
                            bdonor.setGender(gender);
                        }
                        
                        if ("age".equals(xmlPullParser.getName())) {
                            String age = xmlPullParser.nextText();
                            bdonor.setAge(Integer.parseInt(age));
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if ("BDonor".equals(xmlPullParser.getName())) {
                            donorList.add(bdonor);
                        }
                        break;
                    default:
                        break;
                } // end switch

                // Move forward the parsing "cursor", or you can stop parsing
                eventType = xmlPullParser.next();

            } // end whiles
            
            if (donorList != null) {
                for (Data bb : donorList) {
                    System.out.println(bb);
                }
            }
            else
            {
            	System.out.println("empty");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
	
	


	
