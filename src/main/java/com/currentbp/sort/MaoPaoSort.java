package com.currentbp.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class MaoPaoSort {
	private static Logger logger = LoggerFactory.getLogger(MaoPaoSort.class);

	List<SortObject> sortObjects = new ArrayList<SortObject>();
	
	public List<SortObject> getSortObjects() {
		return sortObjects;
	}

	public void setSortObjects(List<SortObject> sortObjects) {
		this.sortObjects = sortObjects;
	}



	/**
	 * 简单的一个排序，由于时间有限，暂时没有比较更简单的了
	 */
	public void sort() {
		SortObject temp = new SortObject();
		for (int i = 0; i < sortObjects.size(); i++) {
			for (int j = 0; j < sortObjects.size() - i - 1; j++) {
				if (sortObjects.get(j).compareTo(sortObjects.get(j + 1)) < 0) { // 把这里改成大于，就是升序了
					temp.setKey(sortObjects.get(j).getKey());
					temp.setValue(sortObjects.get(j).getValue());
					
					sortObjects.get(j).setKey(sortObjects.get(j + 1).getKey());
					sortObjects.get(j).setValue(sortObjects.get(j + 1).getValue());
					
					sortObjects.get(j + 1).setKey(temp.getKey());
					sortObjects.get(j + 1).setValue(temp.getValue());
				}
			}
		}
	}
	
	/**
	 * 简单的一个排序，由于时间有限，暂时没有比较更简单的了
	 */
	public void sort2() {
		SortObject temp = new SortObject();
		for (int i = 0; i < sortObjects.size(); i++) {
			for (int j = 0; j < sortObjects.size() - i - 1; j++) {
				if (sortObjects.get(j).compareTo(sortObjects.get(j + 1)) > 0) { // 把这里改成大于，就是升序了
					temp.setKey(sortObjects.get(j).getKey());
					temp.setValue(sortObjects.get(j).getValue());
					
					sortObjects.get(j).setKey(sortObjects.get(j + 1).getKey());
					sortObjects.get(j).setValue(sortObjects.get(j + 1).getValue());
					
					sortObjects.get(j + 1).setKey(temp.getKey());
					sortObjects.get(j + 1).setValue(temp.getValue());
				}
			}
		}
	}
	
	public void print(){
		for(int i=0;i<sortObjects.size();i++){
			logger.info("===>"+sortObjects.get(i));
		}
	}

}
