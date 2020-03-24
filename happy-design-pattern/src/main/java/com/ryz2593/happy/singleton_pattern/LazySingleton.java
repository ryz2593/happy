package com.ryz2593.happy.singleton_pattern;

/**
 * @author ryz2593
 * @date 2019/9/5
 * @desc
 */
class lazySingleton {
	private static lazySingleton instance = null;
	private lazySingleton (){}

	/**
	 * not thread safe
	 * @return
	 */
	public static lazySingleton getInstance() {
		if(instance == null) {
			instance = new lazySingleton();
		}
		return instance;
	}

	/**
	 * thread safe
	 * @return
	 */
	public static synchronized lazySingleton getInstance1() {
		if(instance == null) {
			instance = new lazySingleton();
		}
		return instance;
	}

	/**
	 * thread safe
	 * double check getInstance
	 *
	 * @return
	 */
	public static lazySingleton getInstance2() {
		if(instance == null) {
			synchronized(lazySingleton.class) {
				if(instance == null) {
					instance = new lazySingleton();
				}
			}
		}
		return instance;
	}
	
	
}