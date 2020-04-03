package com.ryz2593.happy.util;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.ryz2593.happy.enums.ErrorCodeEnum;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.beans.BeanMap;
import com.ryz2593.happy.exception.BusinessException;

import java.io.*;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 对象之间值拷贝操作，json字符串转换成list,map对象
 * 封装了cglib的BeanCopier
 * @author ryz2593
 */
public final class BeanCopyUtil {
    private static final Log logger = LogFactory.getLog(BeanCopyUtil.class);

    private BeanCopyUtil() {
    }


    public static <T> T map(Object source, Class<T> destinationClass) {
        BeanCopier copier = BeanCopier.create(source.getClass(), destinationClass, false);
        T destinationObject = null;
        try {
            destinationObject = destinationClass.newInstance();

        } catch (Exception e) {
            logger.error("", e);
            throw new BusinessException(ErrorCodeEnum.SYSTEM_ERROR);
        }
        copier.copy(source, destinationObject, null);
        return destinationObject;
    }


    public static <T> List<T> mapList(Collection<?> sourceList, Class<T> destinationClass) {
        if (CollectionUtils.isEmpty(sourceList)) {
            return Lists.newArrayList();
        }
        BeanCopier copier = BeanCopier.create(sourceList.iterator().next().getClass(), destinationClass, false);
        List<T> destinationList = Lists.newArrayList();
        for (Object sourceObject : sourceList) {

            T destinationObject = null;
            try {
                destinationObject = destinationClass.newInstance();

            } catch (Exception e) {
                logger.error("", e);
                throw new BusinessException(ErrorCodeEnum.SYSTEM_ERROR);
            }
            copier.copy(sourceObject, destinationObject, null);
            destinationList.add(destinationObject);
        }
        return destinationList;
    }


    //深度复制， T如果是Pojo类的话，必须实现序列化接口
    public static <T> List<T> deepCopyList(List<T> src) {
        List<T> dest = null;
        try {
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(byteOut);
            out.writeObject(src);
            ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
            ObjectInputStream in = new ObjectInputStream(byteIn);
            dest = (List<T>) in.readObject();
        } catch (Exception e) {
            logger.error("", e);
            throw new BusinessException(ErrorCodeEnum.SYSTEM_ERROR);
        }
        return dest;
    }


    public static void copy(Object source, Object destinationObject) {
        if (destinationObject == null || source == null) {
            return;
        }
        BeanCopier copier = BeanCopier.create(source.getClass(), destinationObject.getClass(), false);
        copier.copy(source, destinationObject, null);
    }

    private static class A implements Serializable{
        private B b;

        public B getB() {
            return b;
        }

        public void setB(B b) {
            this.b = b;
        }
    }
    private static class B implements Serializable{

    }

    public static void main(String[] args) throws Exception {
        A a=new A();
        a.setB(new B());

        A a1=new A();
        copy(a,a1);
        System.out.println(a.getB().equals(a1.getB()));


        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(a);
        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        A dest = (A) in.readObject();
        System.out.println(a.getB().equals(dest.getB()));
    }

    /**
     * 将对象装换为map
     * @param bean
     * @return
     */
    public static <T> Map<String, Object> beanToMap(T bean) {
        Map<String, Object> map = Maps.newHashMap();
        if (bean != null) {
            BeanMap beanMap = BeanMap.create(bean);
            for (Object key : beanMap.keySet()) {
                map.put(key+"", beanMap.get(key));
            }
        }
        return map;
    }

    /**
     * 将map装换为javabean对象
     * @param map
     * @param bean
     * @return
     */
    public static <T> T mapToBean(Map<String, Object> map,T bean) {
        BeanMap beanMap = BeanMap.create(bean);
        beanMap.putAll(map);
        return bean;
    }

    /**
     * 将List<T>转换为List<Map<String, Object>>
     * @param objList
     * @return
     * @throws IOException
     */
    public static <T> List<Map<String, Object>> objectsToMaps(List<T> objList) {
        List<Map<String, Object>> list = Lists.newArrayList();
        if (objList != null && objList.size() > 0) {
            Map<String, Object> map = null;
            T bean = null;
            for (int i = 0,size = objList.size(); i < size; i++) {
                bean = objList.get(i);
                map = beanToMap(bean);
                list.add(map);
            }
        }
        return list;
    }

    /**
     * 将List<Map<String,Object>>转换为List<T>
     * @param maps
     * @param clazz
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public static <T> List<T> mapsToObjects(List<Map<String, Object>> maps, Class<T> clazz) throws InstantiationException, IllegalAccessException {
        List<T> list = Lists.newArrayList();
        if (maps != null && maps.size() > 0) {
            Map<String, Object> map = null;
            T bean = null;
            for (int i = 0,size = maps.size(); i < size; i++) {
                map = maps.get(i);
                bean = clazz.newInstance();
                mapToBean(map, bean);
                list.add(bean);
            }
        }
        return list;
    }

}
