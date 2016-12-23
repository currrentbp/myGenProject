package com.bp.annotation.test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import com.bp.util.all.ListUtil;
import com.bp.util.all.StringUtil;

/**
 * 
 * @author current_bp
 * @createTime 20161008
 *
 */
public class SqlUseAnnotation {
	
	public String getSql(PersonAnnotation person) 
			throws NoSuchMethodException, SecurityException, 
			IllegalAccessException, IllegalArgumentException, 
			InvocationTargetException {
		StringBuffer sql = new StringBuffer("");
		StringBuffer whereSql = new StringBuffer("");
		Class personClass = person.getClass();
		boolean isHasWhere = false;
		
		boolean tableFlag = personClass.isAnnotationPresent(TableAnnotation.class);
		System.out.println("tableFlag:"+tableFlag);
		
		if(!tableFlag){
			return null;
		}
		TableAnnotation tableAnnotation = (TableAnnotation) personClass.getAnnotation(TableAnnotation.class);
		sql.append("select * from "+ tableAnnotation.value());
		
		Field[] fields = personClass.getDeclaredFields();
		String[] whereFields = null;
		
		if(null != fields && 0 != fields.length){
			whereFields = new String[fields.length];
			for(int i=0;i<fields.length;i++){
				boolean columnFlag = fields[i].isAnnotationPresent(ColumnAnnotation.class);
				System.out.println("columnFlag:"+columnFlag);
				if(!columnFlag){
					continue;
				}else if(!isHasWhere){
					isHasWhere = true;
				}
				
				ColumnAnnotation ca = fields[i].getAnnotation(ColumnAnnotation.class);
				System.out.println("ca value:"+ ca.value());
				String columnName = ca.value();
				String getName = "get"+StringUtil.getCaptureName(columnName);
				
				//获取方法，通过方法获取该字段的值
				Method method = personClass.getMethod(getName);
				Object columnValue = method.invoke(person,null);
				System.out.println("columnValue:"+columnValue);
				
				if(null != columnValue){
					if(columnValue instanceof Integer 
							|| columnValue instanceof Long 
							|| columnValue instanceof Float)
						whereFields[i] = columnName+" = "+ columnValue.toString()+" ";
					else{
						whereFields[i] = columnName+" = '"+ columnValue.toString()+"' ";
					}
				}
			}
		}
		
		if(isHasWhere){
			sql.append(" where ");
		}
		
		sql.append(ListUtil.fill(Arrays.asList(whereFields), " and "));
		
		
		
		
		
		
		return sql.toString();
	}

	public static void main(String[] args) 
			throws NoSuchMethodException, SecurityException, IllegalAccessException, 
			IllegalArgumentException, InvocationTargetException {
		SqlUseAnnotation sqlUseAnnotation = new SqlUseAnnotation();
		PersonAnnotation pa = new PersonAnnotation();
		pa.setId(10L);
		pa.setName("baopan");
		pa.setAddress("baopanAddress");
		String sql = sqlUseAnnotation.getSql(pa);
		System.out.println("sql:"+sql);
	}
}
