package com.bp.util.all;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 
 * 日志
 * @author current_bp
 * @createTime 20170523
 */
public class LogUtil {

	@SuppressWarnings("rawtypes")
	private Class class1;

	private Logger log;

	@SuppressWarnings("rawtypes")
	public LogUtil(Class class1) {
		this.class1 = class1;
		log = LoggerFactory.getLogger(class1);
	}

	/**
	 * 记录日志信息
	 */
	public void debug(String message) {
		log.debug(String.format("%s className = %s", message, class1.getName()));
	}

	/**
	 * 记录日志信息
	 */
	public void info(String message) {
		log.info(String.format("%s className = %s", message, class1.getName()));
	}

	/**
	 * 记录日志信息
	 */
	public void debug(String message, Throwable t) {
		log.debug(message, t);
	}

	/**
	 * 记录日志信息
	 */
	public void info(String message, Throwable t) {
		log.info(message, t);
	}

	/**
	 * 记录警告日志信息
	 * 
	 */
	public void warn(String message) {
		log.warn(String.format("%s className = %s", message, class1.getName()));
	}

	/**
	 * 记录警告日志信息
	 */
	public void warn(String message, Throwable t) {
		log.warn(message, t);
	}

	/**
	 * 记录错误日志信息
	 */
	public void error(String message,Throwable t) {
		log.error(String.format("%s className = %s ,throwable = %s", message, class1.getName(),getThrowableString(t)));
	}
	/**
	 * 记录错误日志信息
	 */
	public void error(String message) {
		log.error(String.format("%s className = %s", message, class1.getName()));
	}
	/**
	 * 记录报警日志信息
	 */
	public void alarm(String message,Throwable t) {
		log.error(String.format("alarm %s className = %s ,throwable = %s", message, class1.getName(),getThrowableString(t)));
	}
	/**
	 * 记录报警日志信息
	 */
	public void alarm(String message) {
		log.error(String.format("alarm %s className = %s", message, class1.getName()));
	}

	/**
	 * 读取异常信息
	 */
	public String getThrowableString(Throwable t) {
		if (t == null)
			return null;
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		t.printStackTrace(pw);
		pw.close();
		return sw.toString();
	}

	@SuppressWarnings("rawtypes")
	public Class getClass1() {
		return class1;
	}

	@SuppressWarnings("rawtypes")
	public void setClass1(Class class1) {
		this.class1 = class1;
	}
}
