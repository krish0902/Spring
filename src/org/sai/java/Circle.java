package org.sai.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;


//@Component

//@Service

//@Repository

@Controller
public class Circle implements Shape , ApplicationEventPublisherAware {

	private Point center;
	@Autowired
	private MessageSource messageSource;
	
	private ApplicationEventPublisher publisher;

	
	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@Override
	public void draw() {
		
		System.out.println(this.messageSource.getMessage("drawing.circle",null, "Default Drawing Message", null));
		System.out.println(this.messageSource.getMessage("drawing.point",new Object[] {center.getX(),center.getY()}, "Default Point Message", null));
		System.out.println(this.messageSource.getMessage("greeting",null, "Default Greeting", null));
		
		DrawEvent drawEvent = new DrawEvent(this);
		publisher.publishEvent(drawEvent);
	}

	public Point getCenter() {
		return center;
	}

//	@Autowired
//	@Qualifier("circleRelated")
	
	@Resource(name="pointC")
	public void setCenter(Point center) {
		this.center = center;
	}
	
	
	@PostConstruct
	public void initalizeCircle()
	{
		
		System.out.println("Init of Circle");
		
	}
	
	@PreDestroy
	public void destroyCircle()
	{
		
		System.out.println("Destroy of Circle");
		
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		// TODO Auto-generated method stub
		
		this.publisher=publisher;
		
	}
	
	
}
