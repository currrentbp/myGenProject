package com.currentbp.base.feature.annotationForTest;

import java.lang.reflect.Method;

/**
 * 
 * @author current_bp
 * @createTime 20161008
 *
 */

public class UseFirstAnnotation {

	@FirstAnnotation("sssssdfsdfsd")
	public static void use1(String s1) {
		System.out.println("s1:" + s1);


		try {
			// 通过运行时反射API获得annotation信息
			Class rt_class = UseFirstAnnotation.class;
			Method[] methods = rt_class.getMethods();

			boolean flag = rt_class.isAnnotationPresent(FirstAnnotation.class);
			System.out.println("===>flag:" + flag);

			if (!flag) {
				for (Method method : methods) {
					FirstAnnotation firstAnnotation = method.getAnnotation(FirstAnnotation.class);
					if (null != firstAnnotation) {
						System.out.println("===>firstAnnotation:" + firstAnnotation);
						System.out.println("===>firstAnnotation: value:"+firstAnnotation.value());
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		UseFirstAnnotation.use1("s1");
	}

}
