package com.ryz2593.happy.singleton_pattern;

/**
 * @author ryz2593
 * @date 2019/9/5
 * @desc
 */
class HungrySingleton {
	//¶öººÊ½
	private static Singleton instance = new Singleton();

	private HungrySingleton (){}

	private static Singleton getInstance() {
		return instance;
	}
	
}