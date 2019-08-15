package com.ryz2593.happy.study.dynamic.proxy.jdk;

/**
 * Client
 * client测试代码
 *
 * @author ryz2593
 * @date 2019/7/12
 * @desc
 */
public class Client {
    public static void main(String[] args) {
        // 保存生成的代理类的字节码文件
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        // jdk动态代理测试
        Subject subject = new JDKDynamicProxy(new RealSubject()).getProxy();
        subject.doSomething();
        System.out.println("------------------------------------------");
        subject.sellBook();
        System.out.println("------------------------------------------");
        subject.speak();
    }
}
