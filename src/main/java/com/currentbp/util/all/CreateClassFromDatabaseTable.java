package com.currentbp.util.all;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 创建一个Class，根据数据库中的某个表
 * 
 * @author current_bp
 * @createTime 20160614
 *
 */
public class CreateClassFromDatabaseTable {

	public static final String url = "jdbc:mysql://localhost:3306/database";
	public static final String name = "com.mysql.jdbc.Driver";
	public static final String user = "root";
	public static final String password = "root";

	public static String DEFAULT_PACKAGE = "package com.currentbp.entity;\n";
	public static String DEFAULT_PATH = "E:\\JAVA_PATH";

	public Connection conn = null;
	public PreparedStatement pst = null;
	public ResultSet rs = null;

	public Map<String, String> fields = new HashMap<String, String>();
	public List<String> tables = new ArrayList<String>();
	public String currentTable = "album";

	public CreateClassFromDatabaseTable() {
	}

	/**
	 * 获取一个库中的所有表对应的class
	 * 
	 * @throws SQLException
	 * @throws IOException
	 */
	public void getAllDatabaseClass() throws SQLException, IOException {
		selectDatabase("show tables");
		for (int i = 0; i < tables.size(); i++) {
			currentTable = tables.get(i);

			String sql = "desc " + currentTable;
			selectTable(sql);
			String clazz = getClassFromTable();
			fields = new HashMap<String, String>();

			// 写入文件
			StreamUtil.writeSomethingToFile(clazz, DEFAULT_PATH + "\\" + currentTable + ".java");

		}
	}

	/**
	 * 获得当前表对应的class
	 */
	public void getTableClass() {
		String sql = "desc " + currentTable;
		selectTable(sql);
		try {
			getClassFromTable();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 从库中查询出所有的表
	 * 
	 * @param sql
	 */
	public void selectDatabase(String sql) {
		try {
			Class.forName(name);// 指定连接类型
			conn = (Connection) DriverManager.getConnection(url, user, password);// 获取连接
			pst = (PreparedStatement) conn.prepareStatement(sql);// 准备执行语句
			rs = pst.executeQuery();

			// 字段以及字段类型
			while (rs.next()) {
				String table = rs.getString(1);

				tables.add(table);
			}
			System.out.println(tables);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	/**
	 * 从指定的库中，查询出指定的表结构
	 * 
	 * @param sql
	 */
	public void selectTable(String sql) {
		try {
			Class.forName(name);// 指定连接类型
			conn = (Connection) DriverManager.getConnection(url, user, password);// 获取连接
			pst = (PreparedStatement) conn.prepareStatement(sql);// 准备执行语句
			rs = pst.executeQuery();

			// 字段以及字段类型
			while (rs.next()) {
				String field = rs.getString(1);
				String type = rs.getString(2);

				fields.put(field, type);
			}
			System.out.println(fields);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public void close() {
		try {
			this.conn.close();
			this.pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 组装Class内容
	 * 
	 * @return
	 * @throws SQLException
	 */
	public String getClassFromTable() throws SQLException {
		StringBuffer sb = new StringBuffer();
		StringBuffer sbImport = new StringBuffer();
		StringBuffer sbFields = new StringBuffer();
		StringBuffer sbGetSet = new StringBuffer();
		StringBuffer sbCon = new StringBuffer();

		Iterator i = fields.keySet().iterator();
		while (i.hasNext()) {
			StringBuffer sbGet = new StringBuffer();
			StringBuffer sbSet = new StringBuffer();
			String field = i.next().toString();
			String type = fields.get(field);
			// 添加包
			if (!(sbImport.indexOf(getClassPackage(type)) > -1)) {// 不存在该类型,则添加该包
				sbImport.append("import " + getClassPackage(type) + ";\n");
			}
			// 添加字段
			sbFields.append(getFieldString(field, type));

			// 添加GET和SET方法
			sbGet.append(getGetString(field, type));
			sbSet.append(getSetString(field, type));
			sbGetSet.append(sbGet.toString() + sbSet.toString());
		}

		// 添加默认构造函数
		sbCon.append("\tpublic " + currentTable + " (){}\n\n");

		sb.append(DEFAULT_PACKAGE + "\n\n");
		sb.append(sbImport);
		sb.append("\n\n");
		sb.append("public class " + currentTable + " {\n");

		sb.append(sbCon);
		sb.append(sbFields);
		sb.append(sbGetSet);

		sb.append("}\n");
		System.out.println("=======================\n" + sb);
		return sb.toString();
	}

	public String getClassPackage(String type) {
		System.out.println("===type:" + type);
		String s = "";
		if (type.contains("tinyint")) {
			s = "java.lang.Integer";
		} else if (type.contains("bigint")) {
			s = "java.lang.Long";
		} else if (type.contains("int")) {
			String num1 = StringUtil.getStringWithOutSome(StringUtil.getSplitString(type, "int")[1],
					new String[] { "\\(", "\\)" });
			if (Integer.parseInt(num1) >= 4) {
				s = "java.lang.Long";
			} else {
				s = "java.lang.Integer";
			}

		} else if (type.contains("varchar")) {
			s = "java.lang.String";
		} else if (type.contains("timestamp")) {
			s = "java.util.Date";
		} else {
			s = "java.lang.String";
		}
		return s;
	}

	public String getShortClass(String type) {
		String s = "";
		if (type.contains("tinyint")) {
			s = "int";
		} else if (type.contains("bigint")) {
			s = "long";
		} else if (type.contains("int")) {
			String num1 = StringUtil.getStringWithOutSome(StringUtil.getSplitString(type, "int")[1],
					new String[] { "\\(", "\\)" });
			if (Integer.parseInt(num1) >= 4) {
				s = "long";
			} else {
				s = "int";
			}
		} else if (type.contains("varchar")) {
			s = "String";
		} else if (type.contains("timestamp")) {
			s = "Date";
		} else {
			s = "String";
		}
		return s;
	}

	// TODO 没有区分类型，比较随意写的
	public String getFieldString(String field, String type) {
		return "\tprivate " + getShortClass(type) + " " + field + ";\n";
	}

	// TODO 没有区分类型，比较随意写的
	public String getGetString(String field, String type) {
		return "\tpublic " + getShortClass(type) + " get" + StringUtil.getCaptureName(field) + "(){\n"
				+ "\t\treturn this." + field + ";\n" + "\t}\n\n";
	}

	// TODO 没有区分类型，比较随意写的
	public String getSetString(String field, String type) {
		return "\tpublic void set" + StringUtil.getCaptureName(field) + "(" + getShortClass(type) + " " + field + "){\n"
				+ "\t\tthis." + field + " = " + field + ";\n\t}\n\n";
	}

	/*
	 * {area=varchar(255), create_time=timestamp, episode_count=int(11),
	 * sub_category=int(11), available=tinyint(4), language=varchar(255),
	 * synopsis=varchar(255), create_by=varchar(100), cover=varchar(255),
	 * update_time=timestamp, extend_properties=varchar(255),
	 * business_type=tinyint(4), name=varchar(255), id=bigint(20),
	 * tag=varchar(255), episode_now=int(11), update_by=varchar(100),
	 * customer_id=bigint(20), category=int(11), business_id=bigint(20)}
	 */
	public static void main(String[] args) throws SQLException, IOException {
		CreateClassFromDatabaseTable c = new CreateClassFromDatabaseTable();
		c.getAllDatabaseClass();
	}
}
