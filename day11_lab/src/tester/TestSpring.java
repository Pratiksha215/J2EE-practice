package tester;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dependent.ATMImpl;

public class TestSpring {

	public static void main(String[] args) {
		// start SC nd confirm
		try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml")) 
		{
			//why all beans are loc-loaded-inst-D.I : def loading policy 
			System.out.println("SC booted....");
			//deposit 1000 :B.L
			//BeanFactory method
			//<T>T getBean(String  name, Class<T>beanClass) throws BeanException
			//App is requesting SC to supply rdy to use(loc-loaded-inst--D.I)
			ATMImpl a1=ctx.getBean("atm", ATMImpl.class);//demand made to Sc to getrdy made bean
			a1.deposit(1000);
			ATMImpl a2=ctx.getBean("atm", ATMImpl.class);
			System.out.println(a1==a2);//true since def scope of a spring bean = singleton
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
}
