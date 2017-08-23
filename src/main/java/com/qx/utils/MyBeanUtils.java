package com.qx.utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBeanUtils {
	
	private static Map<String, MyConvert> convertMap=new HashMap<>();
	
	// 参1:变量名  参2:给变量名对应的转换器
	/**
	 * 
	 * @param name  变量名(即 key)  the name must be as same as the propertyName
	 * @param myConvert  该变量名对应的转换器(即value)
	 */
	public static void addConvert(String name,MyConvert myConvert) {
		convertMap.put(name, myConvert);
	};
	
	/**
	 * 转换批量对象
	 * @param sources  转换前的原始数据
	 * @param tClass  转换后的目表类
	 * @return
	 */
	public static <T> List<T> populateBean(List sources,Class<T> tClass) throws Exception{
		
		List<T> list=new ArrayList<>();//创建存放目标的集合
		
		//中间转换数据
		for (int i = 0; i < sources.size(); i++) {//遍历转换前的原始数据
			Object o = sources.get(i);
			T newInstance = tClass.newInstance();//转换后的用于存放数据的对象
			Field[] declaredFields = tClass.getDeclaredFields();//从目标中取出所有的字段
			for (Field field : declaredFields) { //遍历字段
				String name = field.getName(); //找到每个字段的名字,这个刚好在原始内容中都存在
				/*在原始的类中查找当前同名的属性,o.getclass()得到的是原始类型 不是Object.class*/
				PropertyDescriptor propertyDescriptor=new PropertyDescriptor(name, o.getClass());
				if (propertyDescriptor!=null) {
					Method readMethod = propertyDescriptor.getReadMethod();//获取get方法
					Object invoke = readMethod.invoke(o);//调用get方法从当前正在需要转换的对象上面获取值
					
					MyConvert myConvert = convertMap.get(name);//根据当前的字段名去转换器中查询是否有转换器
					if (myConvert!=null) {
						invoke=myConvert.convert(invoke);
					}
					
					//field.setAccessible(true);//首先设置允许访问私有变量
					//field.set(newInstance, invoke);//赋值
					PropertyDescriptor targetPro=new PropertyDescriptor(name, tClass);//从目标类上面找这个属性,这里建议使用set放个赋值
					if (targetPro!=null) {
						Method writeMethod = targetPro.getWriteMethod();//获取set方法
						writeMethod.invoke(newInstance, invoke);//为目标类型对象的属性赋值
					}
				}
			}
			list.add(newInstance);
		}
		//convertMap.clear();//注意 转换器应该在所有的数据遍历完成后清除(若多用户共享该map则不能清除)
		return list;
		
	}
}
