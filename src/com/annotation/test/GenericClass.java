package com.annotation.test;

public class GenericClass<T> {
	private T value;
	private GenericClass(T t) {
		this.value = t;
	}
	public GenericClass() {
	}
	public void print(T t) {
		System.out.println("ok " + t);
	}
}
