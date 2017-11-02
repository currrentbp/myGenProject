package com.currentbp.sort;

import java.util.ArrayList;
import java.util.List;


/**
 * 我的红黑树
 * @author current_bp
 *
 */
public class MyRBTree {

	//树顶
	private TNode topNode = null;
	
	public TNode tn1 = new TNode(25);
	public TNode getNewNode(){
		return this.tn1;
	}
	public TNode getNewNode(int value){
		return new TNode(value);
	}
	
	public static void main(String[] args) {
		MyRBTree m = new MyRBTree();
		System.out.println(m.insertNewNode(m.getNewNode(25)));
		System.out.println(m.insertNewNode(m.getNewNode(30)));
		System.out.println(m.insertNewNode(m.getNewNode(16)));
		System.out.println(m.insertNewNode(m.getNewNode(18)));
		System.out.println(m.insertNewNode(m.getNewNode(29)));
		System.out.println(m.insertNewNode(m.getNewNode(1)));
		System.out.println(m.insertNewNode(m.getNewNode(8)));
		
		
	}
	
	
	/**
	 * 插入一个新的节点
	 * @param newNode
	 * @return : 该节点的层次,顶点为1,0表示插入失败
	 */
	public int insertNewNode(TNode newNode){
		int result = 0;
		
		if(null == topNode){//如果没有树顶
			topNode = newNode;
			result  = 1;
		}else{//已存在树结构
			result = whileTNode(topNode,newNode,1);
			
		}
		
		return result;
	}
	
	
	/**
	 * 获取最短的路径层次
	 * @param newNode
	 * @return
	 */
	public int getLastNode(TNode newNode){
		int result = 0;
		List<TNode> nodes = new ArrayList<TNode>();
		nodes.add(newNode);
		
		
		for(int i=0;i< nodes.size();i++){
			if(null == nodes.get(i).getLeftNode() || null == nodes.get(i).getRightNode()){
				result = i;
				break;
			}else{
				List<TNode> nodes1 = new ArrayList<TNode>();
				for(int j=0;j<nodes.size();j++){
					nodes1.add(nodes.get(j).getLeftNode());
					nodes1.add(nodes.get(j).getRightNode());
				}
				
			}
		}
		
		
		return result;
	}
	
	/**
	 * 递归树，并将数据插入
	 * @param tn
	 * @param tnvalue
	 * @param count
	 * @return
	 */
	public int whileTNode(TNode tn, TNode tnvalue,int count){
		tnvalue.setLeftNode(null);
		tnvalue.setRightNode(null);
		
		if(tn.getValue() <= tnvalue.getValue() && null == tn.getLeftNode()){//左节点值为空
			tn.setLeftNode(tnvalue);
			return ++count;
		}else if(tn.getValue() >= tnvalue.getValue() && null == tn.getRightNode()){//右节点值为空
			tn.setRightNode(tnvalue);
			return ++count;
		}else if(tn.getValue() <= tnvalue.getValue() && null != tn.getLeftNode()){//左节点值不为空
			return whileTNode(tn.getLeftNode(), tnvalue, ++count);
		}else if(tn.getValue() >= tnvalue.getValue() && null != tn.getRightNode()){//右节点值不为空
			return whileTNode(tn.getRightNode(), tnvalue, ++count);
		}else{
			return 0;
		}
	}
	
	
	
}


/**
 * 树的节点
 * @author current_bp
 *
 * @param <T>
 */
class TNode<T>{
	private int value;
	private TNode selfNode = null;
	private TNode leftNode = null;
	private TNode rightNode = null;
	
	public TNode(){};
	public TNode(int value){
		this.value=value;
		this.selfNode = null;
		this.rightNode = null;
		this.leftNode = null;
	}
	
	/**
	 * 
	 * @param value:值
	 * @param selfNode:本节点
	 * @param leftNode:左节点
	 * @param rightNode:右节点
	 */
	public TNode(int value,TNode selfNode,TNode leftNode,TNode rightNode){
		this.value=value;
		this.selfNode = selfNode;
		this.rightNode = rightNode;
		this.leftNode = leftNode;
	}
	
	
	public int getValue(){
		return this.value;
	}
	public TNode getSelfNode() {
		return selfNode;
	}
	public void setSelfNode(TNode selfNode) {
		this.selfNode = selfNode;
	}
	public TNode getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(TNode leftNode) {
		this.leftNode = leftNode;
	}
	public TNode getRightNode() {
		return rightNode;
	}
	public void setRightNode(TNode rightNode) {
		this.rightNode = rightNode;
	}
	
	
}