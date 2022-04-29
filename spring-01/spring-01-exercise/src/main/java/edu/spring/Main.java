package edu.spring;

//import org.springframework.context.support.ClassPathXmlApplicationContext;
import edu.spring.domain.Person;
import edu.spring.service.PersonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

        PersonService personService = context.getBean(PersonService.class);
        // TODO: создайте здесь класс контекста

        // TODO: Получите Person Service

        // Получите Person "Ivan"
        Person ivan = personService.getByName("Ivan");
        System.out.println("name: " + ivan.getName() + " age: " + ivan.getAge());
    }
}
