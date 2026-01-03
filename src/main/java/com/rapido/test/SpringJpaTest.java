package com.rapido.test;

import com.rapido.config.PersistenceJavaConfig;
import com.rapido.entities.Bike;
import com.rapido.service.ManageBikeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class SpringJpaTest {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(PersistenceJavaConfig.class);
        ManageBikeService manageBikeService =  context.getBean("manageBikeService", ManageBikeService.class);
        List<Bike> bikes = manageBikeService.getBikes();
        bikes.stream().forEach(System.out::println);
    }
}
