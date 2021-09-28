package com.techlab.reflection.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.*;

import com.techlab.reflection.Profile;

public class ProfileTest {

	public static void main(String[] args) throws Exception{
		Profile obj = new Profile("Saket");
		  
        Class cls = obj.getClass();
        System.out.println("The name of class is " +
                            cls.getName());
  
        Constructor constructor = cls.getConstructor();
        System.out.println("The name of constructor is " +
                            constructor.getName());
  
        System.out.println("The public methods of class are : ");
        Method[] methods = cls.getMethods();
  
        // Printing method names
        for (Method method:methods)
            System.out.println(method.getName());
  
        Method methodcall1 = cls.getDeclaredMethod("age",int.class);
        methodcall1.invoke(obj, 19);
        Field field = cls.getDeclaredField("name");
        field.setAccessible(true);
        field.set(obj, "JAVA");
        Method age = cls.getDeclaredMethod("name");
        age.invoke(obj);
        Method methodcall = cls.getDeclaredMethod("method");
        methodcall.setAccessible(true);
        methodcall.invoke(obj);
	}

}
