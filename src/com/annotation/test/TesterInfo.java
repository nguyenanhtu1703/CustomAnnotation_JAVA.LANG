package com.annotation.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface TesterInfo {
	public enum Priority {
		low, medium, high
	}
	Priority priority() default Priority.medium;
	String[] tags() default "";
	String createdBy() default "pro";
	String lastModified() default "28/7/2019";
}
