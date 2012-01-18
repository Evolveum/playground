package com.evolveum.midpoint;

import com.evolveum.midpoint.xml.ns._public.common.common.ActivationType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lazyman
 */
public class Main {

    public static void main(String[] args) {
        // open/read the application context file
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-context-repo.xml");
        SessionFactory factory = (SessionFactory) ctx.getBean("sessionFactory");

        Session session = factory.openSession();
        ActivationType activation = new ActivationType();
        activation.setEnabled(true);

        session.save(activation);

    }
}
