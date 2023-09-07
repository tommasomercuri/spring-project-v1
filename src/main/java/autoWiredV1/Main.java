package autoWiredV1;

import autoWiredV1.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.UUID;

@SpringBootApplication
public class Main {

public static void main(String[] args) {
	ApplicationContext aP = new ClassPathXmlApplicationContext("applicationcontext.xml");
	User user = (User) aP.getBean("userBean");
	System.out.println(user.toString());
	User user2 = (User) aP.getBean("userBean2");
	user2.setId("3");
	System.out.println(user2.toString());

	user.callAcc();

	for(String a : aP.getBeanDefinitionNames()){
		UUID b = UUID.randomUUID();
		System.out.println(a + " BEAN --->" + b.toString() );
	}

}
}
