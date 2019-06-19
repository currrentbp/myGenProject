package com.currentbp.base.feature.annotationForTest;

import java.lang.annotation.*;

/**
 * 
 * @author current_bp
 * @createTime 20161008
 *
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface TableAnnotation {

	public String value();
}
