package com.mbrdi.didemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mbrdi.didemo.controllers.ConstructorInjectedController;
import com.mbrdi.didemo.controllers.MyController;
import com.mbrdi.didemo.controllers.PropertyInjectedController;
import com.mbrdi.didemo.controllers.SetterInjectedController;
import com.mbrdi.didemo.externalization.FakeDataSource;

@SpringBootApplication
public class DiDemoApplication {

	public static void main(String[] args) {
		
		//getting the handle of Application context.
		ApplicationContext ctx = SpringApplication.run(DiDemoApplication.class, args);
		
		MyController controller = (MyController)ctx.getBean("myController");
		System.out.println(controller.hello());
		System.out.println(ctx.getBean(PropertyInjectedController.class).sayHello());
		System.out.println(ctx.getBean(SetterInjectedController.class).sayHello());
		System.out.println(ctx.getBean(ConstructorInjectedController.class).sayHello());
		
		FakeDataSource fakeDataSource = (FakeDataSource) ctx.getBean(FakeDataSource.class);
		System.out.println("externalized properties " + fakeDataSource.getPassword());
	}

}
