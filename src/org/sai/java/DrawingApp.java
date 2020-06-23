package org.sai.java;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class DrawingApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Triangle triangle  = new Triangle();
		
//		BeanFactory factory= new XmlBeanFactory(new FileSystemResource("spring.xml"));
//		
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
		Shape shape=(Shape)context.getBean("circle");
		
		shape.draw();
		
	//	System.out.println(context.getMessage("greeting",null, "Default Greeting", null));
		
		
		
		
//		//Gets the resource
//				ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//
//				Triangle triangle = (Triangle) context.getBean("triangle");
//				triangle.draw();
//
//		//Closes the context
//				( (ClassPathXmlApplicationContext) context ).close();
//		
	}

}
