package com.currentbp.util.all.xmlUtil;

/********************************************************************
 * 项目名称    ：rochoc   <p>
 * 包名称      ：rochoc.xml.oper <p>
 * 文件名称    ：XmlBuilder   <p>
 * 编写者     ：luoc    <p>
 * 编写日期    ：2005-6-22    <p>
 * 程序功能（类）描述 ： 根据传入的XML文件生成Document和root结点<p>
 * 
 * 程序变更日期   ：
 * 变更作者    ：
 * 变更说明    ：
********************************************************************/

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;


public class XmlBuilder {

	public XmlBuilder(String path) {
		this.path = path;
		init();
	}

	public void init() {
		buildDocument();
		buildRoot();
	}

	private void buildDocument() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();

			doc = builder.parse(new File(path));
		} catch (ParserConfigurationException e) {
		} catch (SAXException e) {
		} catch (IOException e) {
		}
	}

	private void buildRoot() {
		root = doc.getDocumentElement();
	}

	public Document getDoc() {
		return doc;
	}

	public void setDoc(Document doc) {
		this.doc = doc;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Element getRoot() {
		return root;
	}

	public void setRoot(Element root) {
		this.root = root;
	}

	private String path = null;// xml文件路径

	private Document doc = null;// xml文件对应的document

	private Element root = null;// xml文件的根结点
	
	
	public static void main(String[] args) {
		XmlBuilder x = new XmlBuilder("C:\\Users\\lenovo\\Desktop\\first.xml");
		System.out.println(x.getRoot());
	}

}