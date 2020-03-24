package com.ryz2593.happy.singleton_pattern;

/**
 * @author ryz2593
 * @date 2019/9/5
 * @desc
 */
class LazySingleton {
	private static LazySingleton instance = null;
	private LazySingleton(){}

	/**
	 * not thread safe
	 * @return
	 */
	public static LazySingleton getInstance() {
		if(instance == null) {
			instance = new LazySingleton();
		}
		return instance;
	}

	/**
	 * thread safe
	 * @return
	 */
	public static synchronized LazySingleton getInstance1() {
		if(instance == null) {
			instance = new LazySingleton();
		}
		return instance;
	}

	/**
	 * thread safe
	 * double check getInstance
	 *
	 * @return
	 */
	public static LazySingleton getInstance2() {
		if(instance == null) {
			synchronized(LazySingleton.class) {
				if(instance == null) {
					instance = new LazySingleton();
				}
			}
		}
		return instance;
	}
	
	
}