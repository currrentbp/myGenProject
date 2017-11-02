package com.currentbp.steam;

import java.util.ArrayList;


/**
 * 
  * @author current_bp
 * @time 20160405
 *
 */
public class BinaryTree {

	private int value ;
	private BinaryTree leftBinaryTree = null;
	private BinaryTree rightBinaryTree = null;
	
	/**
	 * 先序排序。
	 * @param list
	 * @return
	 */
	public BinaryTree createBinaryTreeByArray(ArrayList list)
	{
		BinaryTree binaryTree = null;
		if(null != list && list.size()!= 0)
		{
			binaryTree = new BinaryTree();
		}
		//将list的数据添加到树中。
		for(int i=0 ;i< list.size();i++)
		{
			//判断这个数（list.get(i)）的位置，并将这个数放入这个位置。
			if(i== 0)
			{
				binaryTree.setValue(Integer.parseInt(list.get(i).toString()));
			}else
			{
				addNumToBinaryTree(binaryTree,Integer.parseInt(list.get(i).toString()));
			}
		}
		
		return binaryTree;
	}
	
	/**
	 * 将一个数字添加到一个树中，先序排序。
	 * @param binaryTree
	 * @param num
	 */
	public void addNumToBinaryTree(BinaryTree binaryTree, int num){
		if(null !=binaryTree)
		{
			if(binaryTree.getValue()>= num)
			{
				addNumToBinaryTree(binaryTree.getLeftBinaryTree(), num);
			}else
			{
				addNumToBinaryTree(binaryTree.getRightBinaryTree(), num);
			}
		}else
		{
			BinaryTree binaryTree1 = new BinaryTree();
			binaryTree1.setValue(num);
			binaryTree=binaryTree1;
		}
		
	}
	
	
	public static void main(String[] args) {
		BinaryTree test = new BinaryTree();
		ArrayList list = new ArrayList();
		list.add(5);
		list.add(3);
		list.add(4);
		list.add(8);
		list.add(7);
		test.createBinaryTreeByArray(list);
	}
	
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public BinaryTree getLeftBinaryTree() {
		return leftBinaryTree;
	}
	public void setLeftBinaryTree(BinaryTree leftBinaryTree) {
		this.leftBinaryTree = leftBinaryTree;
	}
	public BinaryTree getRightBinaryTree() {
		return rightBinaryTree;
	}
	public void setRightBinaryTree(BinaryTree rightBinaryTree) {
		this.rightBinaryTree = rightBinaryTree;
	}
	
}
