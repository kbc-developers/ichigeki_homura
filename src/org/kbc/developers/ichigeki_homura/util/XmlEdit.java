package org.kbc.developers.ichigeki_homura.util;

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

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.xpath.XPathExpression;
import org.xml.sax.SAXException;


public class XmlEdit {

	private Document mDoc;

	public boolean read( File aFile ) {

		//----------------------------------
		// step1. DocumentBuilderを準備する
		//----------------------------------
		DocumentBuilder builder = null;
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// 通常はありえないが、
			e.printStackTrace();
			return false;
		}

		//----------------------------------------------------
		// step2. XMLファイルを読み込んで、Documentを構築する
		//----------------------------------------------------
		Document document = null;
		try {
			document = builder.parse( aFile );
		} catch (SAXException e) {
			// 文法エラーが発生した場合
			e.printStackTrace();
		} catch (IOException e) {
			// ファイルが読み込めなかった場合
			e.printStackTrace();
		}
		mDoc = document;
		// 完了
		return true;
	}

	public boolean saveDocument( File aFile ){

		//---------------------------------
		// step1. Transformerの準備
		//---------------------------------
		Transformer transformer = null;
		try {
			TransformerFactory factory = TransformerFactory.newInstance();
			transformer = factory.newTransformer();
		} catch (TransformerConfigurationException e) {
			// 通常はありえない。
			e.printStackTrace();
			return false;
		}

		//---------------------------------
		// step2. Transformerの動作設定
		//---------------------------------
		transformer.setOutputProperty("indent",   "yes");
		transformer.setOutputProperty("encoding", "utf-8");

		//-------------------------------------
		// step3. Documentをファイルに書き出す
		//------------------------------------
		try {
			transformer.transform(new DOMSource( mDoc ),
					new StreamResult( aFile ) );
		} catch (TransformerException e) {
			// 書き出しエラー発生
			e.printStackTrace();
			return false;
		}

		// 終了
		return true;
	}

	public void printItem(String path) {
		//for test only
		try {
			XPath xPath = XPathFactory.newInstance().newXPath();
			//System.out.println("" + xPath.evaluate(location1, document, XPathConstants.STRING));

			Object result =  xPath.evaluate(path, mDoc, XPathConstants.NODESET);
			NodeList nodeList = (NodeList) result;

			Log.d("test","Print current Item in config_statusBarIcons");
			for( int i=0; i<nodeList.getLength(); i++ ) {
				if( nodeList.item(i).getNodeType() == Node.TEXT_NODE ) {
					Log.d("item",nodeList.item(i).getNodeValue());
				}
			}

		} catch (XPathExpressionException e) {
			//e.printStackTrace();
		}
	}

	public boolean isExistItem(String path,String val) {

		boolean ret = false;

		XPath xPath = XPathFactory.newInstance().newXPath();
//		String location1 = "/resources/string-array[@name='config_statusBarIcons']/item/text()";
//		String location2 = "/resources/string-array[@name='config_statusBarIcons']/item[text()='felica_lock']";

		String location1 = path+"/text()";
		String location2 = path+"[text()='"+val+"']";

		try {
			String aaa = (String) xPath.evaluate(location2, mDoc, XPathConstants.STRING);
			if("".equals(aaa))
			{
				aaa = "\""+val+"\" is nothing";
			}
			else
			{
				aaa = "Already exists \""+val+"\" ";
				ret = true;
			}
			Log.d(val,aaa);

		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		//for test only
		printItem(location1);

		return ret;
	}

	public boolean appendItem(String path,String val)
	{
		XPath xPath = XPathFactory.newInstance().newXPath();
		//String location1 = path+"/..";
		//String location2 = path+"[text()='"+val+"']";
		try {
			//System.out.println("" + xPath.evaluate(location1, document, XPathConstants.STRING));

			Object result =  xPath.evaluate(path, mDoc, XPathConstants.NODESET);
			NodeList nodeList = (NodeList) result;

			if( nodeList.getLength()== 0)
			{
				Log.d("item","getLength()=0");
				return false;
			}
			Log.d("tag-name",nodeList.item(0).getNodeName());

		    Element item = mDoc.createElement(nodeList.item(0).getNodeName());
		    item.setTextContent(val);
			//nodeList.item(0).appendChild(item);
		    nodeList.item(0).getParentNode().appendChild(item);

		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		printItem(path+"/text()");

		return true;
	}
}
