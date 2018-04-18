package com.huang.reflect.object;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;  

public class ReflectMain {

	public static void main(String[] args) throws Exception {

		getConstructor();
		
		System.out.println("=====================Method separation==========================");
		
		getReflectDemo();
		
		System.out.println("=====================Method separation==========================");
		
		getNewInstanceByConstructor();
		
		System.out.println("=====================Method separation==========================");
		
		getMethodByClassName();
		
		System.out.println("=====================Method separation==========================");
		
		getMethodPropertyOfClass();
		
		System.out.println("=====================Method separation==========================");
		
		invokeMethod();
		
		System.out.println("=====================Method separation==========================");
		
		getFieldsOfClass();
		

	}
	
	public static void getConstructor() throws ClassNotFoundException{
		Class<?> cls = Class.forName("java.lang.String");
		// 获取所有构造函数
		Constructor<?>[] cons = cls.getConstructors();
		// 循环打印
		for (int i = 0; i < cons.length; i++) {
			System.out.println(cons[i]);
		}
	}
	
	public static void getReflectDemo() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		Class<?> cls = Class.forName("com.huang.model.Student");
		
		Object obj = cls.newInstance();
		
		System.out.println(obj);
		
	}
	
	public static void getNewInstanceByConstructor() throws Exception {
		Class<?> cls = Class.forName("com.huang.model.Student");
		Constructor<?> con = cls.getConstructor(String.class, Integer.class);
		// 这里就相当于Object obj = new Student2("马小超",20);
		Object obj = con.newInstance("马小超", 20);
		System.out.println(obj);
	}
	  
	public static void getMethodByClassName() throws ClassNotFoundException {
		Class<?> cls = Class.forName("com.huang.model.Student");
		// 获取本类中定义的方法
		Method[] method = cls.getDeclaredMethods();
		// 循环打印
		for (int i = 0; i < method.length; i++) {
			System.out.println(method[i]);
		}
	}
	
	public static void getMethodPropertyOfClass()throws Exception{
		Class<?> cls = Class.forName("com.huang.model.Student");  
        Method[] me = cls.getMethods();  
        for (int i = 0; i < me.length; i++) {  
            // 此时用了method的toString方法输出，如果有需要，用户也可以自己拼凑输出  
            // System.out.println(me[i]);  
            // 取得修饰符  
            System.out.print(Modifier.toString(me[i].getModifiers()) + " ");  
            // 取得返回值类型  
            System.out.print(me[i].getReturnType().getSimpleName() + " ");  
            // 取得方法名称  
            System.out.print(me[i].getName() + "(");  
            // 取得方法参数  
            Class<?> params[] = me[i].getParameterTypes();  
            if (params.length > 0) {  
                for (int j = 0; j < params.length; j++) {  
                    System.out.print(params[j].getSimpleName() + " arg-" + j);  
                    if (j < params.length - 1) {  
                        System.out.print(", ");  
                    }  
                }  
            }  
            System.out.print(") ");  
            // 取得异常  
            Class<?>[] exp = me[i].getExceptionTypes();  
            if (exp.length > 0) {  
                System.out.print("throws ");  
                for (int j = 0; j < exp.length; j++) {  
                    System.out.print(exp[j].getSimpleName());  
                    if (j < exp.length - 1) {  
                        System.out.println(", ");  
                    }  
                }  
            }  
            System.out.println("{}");  
            System.out.println();  
        } 
	}
	
    public static void invokeMethod() throws Exception {  
        Class<?> cls = Class.forName("com.huang.model.Student");  
        // 实例化对象  
        Object obj = cls.newInstance();  
        //获取setName()方法  
        Method setNameMethod = cls.getMethod("setName", String.class);  
        //获取getName()方法  
        Method getNameMethod = cls.getMethod("getName");  
        //调用setName()方法，相当于 对象.setName("马小超");  
        setNameMethod.invoke(obj, "马小超");  
        //调用getName()方法并输出  
        System.out.println(getNameMethod.invoke(obj));  
    } 
    
    public static void getFieldsOfClass() throws Exception {  
        Class<?> cls = Class.forName("com.huang.model.Student");  
        //实例化  
        Object obj = cls.newInstance();  
        //获取属性  
        Field nameField = cls.getDeclaredField("name");  
        //取消访问检查  
        nameField.setAccessible(true);
        //给属性赋值  
        nameField.set(obj, "马小超123");  
        //获取属性值并输出  
        System.out.println(nameField.get(obj));  
    } 
}
