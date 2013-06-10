package org.kbc.developers.ichigeki_homura.test;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.kbc.developers.ichigeki_homura.util.Log;
import org.kbc.developers.ichigeki_homura.util.XmlEdit;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.xpath.XPathExpression;
import org.xml.sax.SAXException;


public class XmlTest implements Testable{

	@Override
	public void test() {
		Log.e("test","Start");

		final String input ="Test/arrays.xml";
		final String output ="Test/arrays_after.xml";


		XmlEdit xml = new XmlEdit();
		xml.read(new File(input));

		String location = "/resources/string-array[@name='config_statusBarIcons']/item";

		if( xml.isExistItem(location, "felica_lock") )
		{

		}
		xml.appendItem(location, "test2");

		xml.saveDocument(new File(output));

		Log.e("test","End");

	}

	public static void main(final String[] args) {

		Log.setLoglevel(Log.DEBUG);

		XmlTest test = new XmlTest();


		//    	String osName = System.getProperty("os.name");
		//        System.out.println(osName);

		test.test();
	}

}
