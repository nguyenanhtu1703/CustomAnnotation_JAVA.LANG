package com.annotation.test;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class App {
	//public boolean yes() default true;
	public static void main(String[] args) {
		System.out.println("Testing...");
		int passed = 0, failed = 0, count = 0, ignore = 0;
		Class obj = TestExample.class;
		
		if (obj.isAnnotationPresent(TesterInfo.class)) {
			Annotation annotation = obj.getAnnotation(TesterInfo.class);
			
			TesterInfo testerInfo = (TesterInfo) annotation;
			System.out.println(testerInfo.createdBy());
			System.out.println(testerInfo.priority());
			System.out.println(testerInfo.lastModified());
			
			int tagLength = testerInfo.tags().length;
			for(String tag : testerInfo.tags()) {
				if (tagLength > 1) {
					System.out.println(tag + ", ");
				} else {
					System.out.println(tag);
				}
				tagLength--;
			}
		}
		
		for(Method method: obj.getDeclaredMethods()) {
			if (method.isAnnotationPresent(Test.class)) {
				Annotation annotation = method.getAnnotation(Test.class);
				Test test = (Test) annotation;
				if (test.enable()) {
					try {
						method.invoke(obj.newInstance());
						System.out.printf("%s - Test '%s' - passed %n", ++count, method.getName());
					} catch (Throwable ex) {
						System.out.printf("%s - Test '%s' - failed %n", ++count, method.getName());
					}				
				} else {
					System.out.printf("%s - Test '%s' - ignored %n", ++count, method.getName());
					ignore++;
				}
			}
			System.out.printf("%nResult: Total: %d, Passed: %d, Failed %d, Ignore %d%n", count, passed, failed, ignore);
		}
	}
}
