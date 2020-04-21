package com.NDS.ParseXml;
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

import com.NDS.Data.Data;

public class ParseBooks {

	public static void mainprint(String xmlRecords) {
		
        Data data = null;
        ArrayList<Data> pubList = null;

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
                            pubList = new ArrayList<Data>();
                        }

                        if ("NDS".equals(xmlPullParser.getName())) {
                            data = new Data();
                           // book.setISBN(xmlPullParser.getAttributeValue(XmlPullParser.NO_NAMESPACE, "ISBN"));
                        }
                        if ("id".equals(xmlPullParser.getName())) {
                            String id = xmlPullParser.nextText();
                            data.setId(Integer.parseInt(id));
                        }
                        if ("name".equals(xmlPullParser.getName())) {
                            String name = xmlPullParser.nextText();
                            data.setName(name);
                        }

                        if ("frequency".equals(xmlPullParser.getName())) {
                            String frequency = xmlPullParser.nextText();
                            data.setFrequecny(frequency);
                        }

                        if ("amount".equals(xmlPullParser.getName())) {
                            String amount = xmlPullParser.nextText();
                            data.setAmount(Integer.parseInt(amount));
                        }
                        
                        if ("price".equals(xmlPullParser.getName())) {
                            String price = xmlPullParser.nextText();
                            data.setPrice(Integer.parseInt(price));
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if ("NDS".equals(xmlPullParser.getName())) {
                            pubList.add(data);
                        }
                        break;
                    default:
                        break;
                } // end switch

                // Move forward the parsing "cursor", or you can stop parsing
                eventType = xmlPullParser.next();

            } // end whiles
            
            if (pubList != null) {
                for (Data bb : pubList) {
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
	
	


	
