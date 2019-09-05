package com.ryz2593.happy.singleton_pattern;

/**
 * @author ryz2593
 * @date 2019/9/5
 * @desc
 */
class Singleton {
	//����ʽ
	private static Singleton instance = null;
	private Singleton (){}
	//���߳�����£����̰߳�ȫ
	public static Singleton getInstance() {
		if(instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
	
	//�̰߳�ȫ
	public static synchronized Singleton getInstance() {
		if(instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
	
	//˫�ؼ��� 
	public static Singleton getInstance() {
		if(instance == null) {
			//������ס����Singleton
			synchronized(Singleton.class) {
				if(instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
	
	
}