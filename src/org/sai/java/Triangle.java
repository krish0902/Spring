package org.sai.java;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle implements Shape,InitializingBean, DisposableBean,ApplicationContextAware,BeanNameAware{

	
	private List<Point> points;

	private ApplicationContext context =null;

	


	public List<Point> getPoints() {
		return points;
	}


	public void setPoints(List<Point> points) {
		this.points = points;
	}


	public void draw()
	{
		System.out.println("Drawing Triangle");
		for(Point p:points)
		{
			System.out.println(p.getX() +" ,"+p.getY());
			
		}
//		System.out.println(getPointA().getX() +" ,"+getPointA().getY());
//		System.out.println(getPointB().getX() +" ,"+getPointB().getY());
//	System.out.println(getPointC().getX() +" ,"+getPointC().getY());

		
	}


	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		
		this.context =context; 
		
	}


	@Override
	public void setBeanName(String beanName) {
		
		System.out.println("Bean name is: "+beanName);
		
	}


	@Override
	public void afterPropertiesSet() throws Exception {
		
		System.out.println("Initailizing init method called for Triangle");
		
		
	}


	@Override
	public void destroy() throws Exception {
		
		
		System.out.println("DisposableBean destroy method called for Traingle");
	}
	
	
	public void myInit()
	{
		System.out.println("My init method called for Triangle");

	}
	
	public void cleanUp()
	{
		System.out.println("My Cleanup method called for Triangle");

	}
	
	
	
	
}
