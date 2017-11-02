package com.currentbp.util.all.xmlUtil;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlCreater {
	public XmlCreater(String path) {
		this.path = path;
		init();
	}

	private void init() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			doc = builder.newDocument();// 新建DOM
		} catch (ParserConfigurationException e) {
		}
	}

	public Element createRootElement(String rootTagName) {
		if (doc.getDocumentElement() == null) {
			Element root = doc.createElement(rootTagName);
			doc.appendChild(root);
			return root;
		}
		return doc.getDocumentElement();
	}

	public Element createElement(Element parent, String tagName) {
		Document doc = parent.getOwnerDocument();
		Element child = doc.createElement(tagName);
		parent.appendChild(child);
		return child;
	}

	public Element createElement(Element parent, String tagName, String value) {
		Document doc = parent.getOwnerDocument();
		Element child = doc.createElement(tagName);
		XmlOper.setElementValue(child, value);
		parent.appendChild(child);
		return child;
	}

	public void createAttribute(Element parent, String attrName, String attrValue) {
		XmlOper.setElementAttr(parent, attrName, attrValue);
	}

	public void buildXmlFile() {
		TransformerFactory tfactory = TransformerFactory.newInstance();
		try {
			Transformer transformer = tfactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(path));
			transformer.setOutputProperty("encoding", "UTF-8");
			transformer.transform(source, result);
		} catch (TransformerConfigurationException e) {
		} catch (TransformerException e) {
		}
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

	private Document doc = null;// 新创建的DOM
	private String path = null;// 生成的XML文件绝对路径
}
