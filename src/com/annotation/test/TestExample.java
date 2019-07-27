package com.annotation.test;

import com.annotation.test.Test;
import com.annotation.test.TesterInfo;
import com.annotation.test.TesterInfo.Priority;

@TesterInfo(
		priority = Priority.high,
		createdBy = "pro",
		tags = { "sales", "test" }
)
public class TestExample {
	@Test
	void TestA() {
		if (true)
			throw new RuntimeException("This test always failed");
	}
	
	@Test(enable = false)
	void testB() {
		if (false)
			throw new RuntimeException("This test always passed");
	}
	
	@Test(enable = true)
	void testC() {
		if (10 > 1) {
		}
	}
}
