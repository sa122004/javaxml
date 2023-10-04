package urlbinary;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.awt.Desktop;
import java.io.*;
public class main {

	public static void main(String[] args)throws Exception {
		URL urlfile = new URL("https://news.lau.edu.lb/rss.xml");
		InputStream is =urlfile.openStream();
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		DocumentBuilder db=dbf.newDocumentBuilder();
		Document document=db.parse(is);
		File htmfile=new File("sami.htm");
		PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter(htmfile)));
		StringBuilder sb=new StringBuilder();
		sb.append("<!DOCTYPE html><html>"+"<head><title>lau website revealed</title></head><body>");
		NodeList itemlist;
		Node itemnode;
		Element itemel;
		itemlist=document.getElementsByTagName("item");

		for(int i=0;i<itemlist.getLength();i++) {
			itemnode=itemlist.item(i);
			itemel=(Element)itemnode;
		
		sb.append("<h1>"+itemel.getElementsByTagName("title").item(0).getTextContent()+"</h1>");
		sb.append("<p>"+itemel.getElementsByTagName("description").item(0).getTextContent()+"</p>");
		sb.append("</body></html>");
        pw.println(sb);
		}
        Desktop.getDesktop().browse(htmfile.toURI());

		
		
		
		
	}

}
