package com.bdonor.ParseXml;

import java.net.URI;
import java.util.List;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.bdonor.Data.Data;
 
 
 
public class ClientGetAll {
	
	public static void main (String[] args) throws Exception {
		URI uri = new URIBuilder()
				.setScheme("http")
				.setHost("localhost")
				.setPort(8080)
				.setPath("/A00268806_Varun_Kunar_Tiwari/rest/books").build();
		
		System.out.println(uri.toString());
		
		HttpGet httpGet = new HttpGet(uri);
		httpGet.setHeader("Accept", "application/xml");
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = httpClient.execute(httpGet);
		
		HttpEntity entity = response.getEntity();
		String text = EntityUtils.toString(entity);
		System.out.println(text);
		
		ParseBooks.mainprint(text);
		/*System.out.println("-------------------------");
		for(Data book : bookList) {
			System.out.println("ID: " + book.getId());
			System.out.println("Title: " + book.getName());
			System.out.println("Author: " + book.getBgroup());
			System.out.println("Year: " + book.getGender());
			System.out.println("Year: " + book.getAge());
			System.out.println("-------------------------");
		}*/
		/* DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		 DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		    org.w3c.dom.Document doc = dBuilder.parse(text);
		    doc.getDocumentElement().normalize();
		    System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
		    NodeList nList = doc.getElementsByTagName("passenger");
		    System.out.println("-----------------------");
		    for (int temp = 0; temp < nList.getLength(); temp++) {
		        Node nNode = nList.item(temp);
		        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		            System.out.println("Passenger id : " + e.getAttribute("id"));
		            System.out.println("Name : " + e.getElementsByTagName("name").item(0).getTextContent());
		        }
		    }*/
	}
}
