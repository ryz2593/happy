package com.ryz2593.happy.singleton_pattern;

/**
 * @author ryz2593
 * @date 2019/9/5
 * @desc
 */
class Singleton {
	//懒汉式
	private static Singleton instance = null;
	private Singleton (){}
	//多线程情况下，非线程安全
	public static Singleton getInstance() {
		if(instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
	
	//线程安全
	public static synchronized Singleton getInstance() {
		if(instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
	
	//双重检验 
	public static Singleton getInstance() {
		if(instance == null) {
			//这里锁住的是Singleton
			synchronized(Singleton.class) {
				if(instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
	
	
}