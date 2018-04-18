package com.huang.model;

public class Student {
	
	private String name;  
	  
    private Integer age;  
  
    public Student(String name, Integer age) {  
        this.name = name;  
        this.age = age;  
    } 
	
	
    public Student() {  
        System.out.println("Student类的构造方法");  
    }  
  
    @Override  
    public String toString() {  
    	return "name:" + this.name + ";age:" + this.age;
    }
    
    public void fun(){};  
    
    public void talk(String str)throws NullPointerException{};
    
    public String getName() {  
        return name;  
    }  
  
    public void setName(String name) {  
        this.name = name;  
    } 

}
