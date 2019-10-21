package com.ryz2593.happy.singleton_pattern;

/**
 * @author ryz2593
 * @date 2019/9/5
 * @desc
 */
class lazySingleton {
	//����ʽ
	private static lazySingleton instance = null;
	private lazySingleton (){}
	//���߳�����£����̰߳�ȫd
	public static lazySingleton getInstance() {
		if(instance == null) {
			instance = new lazySingleton();
		}
		return instance;
	}
	
	//�̰߳�ȫ
	public static synchronized lazySingleton getInstance1() {
		if(instance == null) {
			instance = new lazySingleton();
		}
		return instance;
	}
	
	//˫�ؼ��� 
	public static lazySingleton getInstance2() {
		if(instance == null) {
			//������ס����Singleton
			synchronized(lazySingleton.class) {
				if(instance == null) {
					instance = new lazySingleton();
				}
			}
		}
		return instance;
	}
	
	
}