package com.NDS.ParseXml;

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

import com.NDS.Data.Data;
 
 
 
public class ClientGetAll {
	
	public static void main (String[] args) throws Exception {
		URI uri = new URIBuilder()
				.setScheme("http")
				.setHost("localhost")
				.setPort(8081)
				.setPath("/A00268806_Varun_Kunar_Tiwari/rest/publication").build();
		//http://localhost:8081/A00268806_Varun_Kunar_Tiwari/rest/publication
		System.out.println(uri.toString());
		
		HttpGet httpGet = new HttpGet(uri);
		httpGet.setHeader("Accept", "application/xml");
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = httpClient.execute(httpGet);
		
		HttpEntity entity = response.getEntity();
		String text = EntityUtils.toString(entity);
		System.out.println(text);
		
		ParseBooks.mainprint(text);

	}
}
