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
		// ��ȡ���й��캯��
		Constructor<?>[] cons = cls.getConstructors();
		// ѭ����ӡ
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
		// ������൱��Object obj = new Student2("��С��",20);
		Object obj = con.newInstance("��С��", 20);
		System.out.println(obj);
	}
	  
	public static void getMethodByClassName() throws ClassNotFoundException {
		Class<?> cls = Class.forName("com.huang.model.Student");
		// ��ȡ�����ж���ķ���
		Method[] method = cls.getDeclaredMethods();
		// ѭ����ӡ
		for (int i = 0; i < method.length; i++) {
			System.out.println(method[i]);
		}
	}
	
	public static void getMethodPropertyOfClass()throws Exception{
		Class<?> cls = Class.forName("com.huang.model.Student");  
        Method[] me = cls.getMethods();  
        for (int i = 0; i < me.length; i++) {  
            // ��ʱ����method��toString����������������Ҫ���û�Ҳ�����Լ�ƴ�����  
            // System.out.println(me[i]);  
            // ȡ�����η�  
            System.out.print(Modifier.toString(me[i].getModifiers()) + " ");  
            // ȡ�÷���ֵ����  
            System.out.print(me[i].getReturnType().getSimpleName() + " ");  
            // ȡ�÷�������  
            System.out.print(me[i].getName() + "(");  
            // ȡ�÷�������  
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
            // ȡ���쳣  
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
        // ʵ��������  
        Object obj = cls.newInstance();  
        //��ȡsetName()����  
        Method setNameMethod = cls.getMethod("setName", String.class);  
        //��ȡgetName()����  
        Method getNameMethod = cls.getMethod("getName");  
        //����setName()�������൱�� ����.setName("��С��");  
        setNameMethod.invoke(obj, "��С��");  
        //����getName()���������  
        System.out.println(getNameMethod.invoke(obj));  
    } 
    
    public static void getFieldsOfClass() throws Exception {  
        Class<?> cls = Class.forName("com.huang.model.Student");  
        //ʵ����  
        Object obj = cls.newInstance();  
        //��ȡ����  
        Field nameField = cls.getDeclaredField("name");  
        //ȡ�����ʼ��  
        nameField.setAccessible(true);
        //�����Ը�ֵ  
        nameField.set(obj, "��С��123");  
        //��ȡ����ֵ�����  
        System.out.println(nameField.get(obj));  
    } 
}
