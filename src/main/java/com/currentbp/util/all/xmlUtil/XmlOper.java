package com.currentbp.util.all.xmlUtil;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlOper {
	private XmlOper() {
	}

	public static NodeList getNodeList(Element parent) {
		return parent.getChildNodes();
	}

	public static Element[] getElementsByName(Element parent, String name) {
		ArrayList resList = new ArrayList();
		NodeList nl = getNodeList(parent);
		for (int i = 0; i < nl.getLength(); i++) {
			Node nd = nl.item(i);
			if (nd.getNodeName().equals(name)) {
				resList.add(nd);
			}
		}
		Element[] res = new Element[resList.size()];
		for (int i = 0; i < resList.size(); i++) {
			res[0] = (Element) resList.get(i);
		}
		return res;
	}

	public static String getElementName(Element element) {
		return element.getNodeName();
	}

	public static String getElementValue(Element element) {
		NodeList nl = element.getChildNodes();
		for (int i = 0; i < nl.getLength(); i++) {
			if (nl.item(i).getNodeType() == Node.TEXT_NODE)// 是一个Text Node
			{
				return element.getFirstChild().getNodeValue();
			}
		}
		return null;
	}

	/**
	 * 获取当前节点的attr属性的值
	 * @param element
	 * @param attr
	 * @return
	 */
	public static String getElementAttr(Element element, String attr) {
		return element.getAttribute(attr);
	}

	public static void setElementValue(Element element, String val) {
		Node node = element.getOwnerDocument().createTextNode(val);
		NodeList nl = element.getChildNodes();
		for (int i = 0; i < nl.getLength(); i++) {
			Node nd = nl.item(i);
			if (nd.getNodeType() == Node.TEXT_NODE)// 是一个Text Node
			{
				nd.setNodeValue(val);
				return;
			}
		}
		element.appendChild(node);
	}

	public static void setElementAttr(Element element, String attr, String attrVal) {
		element.setAttribute(attr, attrVal);
	}

	public static void addElement(Element parent, Element child) {
		parent.appendChild(child);
	}

	public static void addElement(Element parent, String tagName) {
		Document doc = parent.getOwnerDocument();
		Element child = doc.createElement(tagName);
		parent.appendChild(child);
	}

	public static void addElement(Element parent, String tagName, String text) {
		Document doc = parent.getOwnerDocument();
		Element child = doc.createElement(tagName);
		setElementValue(child, text);
		parent.appendChild(child);
	}

	public static void removeElement(Element parent, String tagName) {
		NodeList nl = parent.getChildNodes();
		for (int i = 0; i < nl.getLength(); i++) {
			Node nd = nl.item(i);
			if (nd.getNodeName().equals(tagName)) {
				parent.removeChild(nd);
			}
		}
	}

	public static void main(String[] args) {
		XmlBuilder x = new XmlBuilder("C:\\Users\\lenovo\\Desktop\\first.xml");
		System.out.println(x.getRoot());
		XmlOper xo = new XmlOper();
		
		for(Element element: xo.getElementsByName(x.getRoot(),"IPName")){
			System.out.println(element.getAttribute("value"));
			
		}
		System.out.println(xo.getNodeList(x.getRoot()));
		
		System.out.println(xo.getElementsByName(x.getRoot(),"IPName"));
		
		System.out.println("===="+xo.getElementAttr(x.getRoot(), "name"));
		
	}
}