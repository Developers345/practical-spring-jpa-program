package com.rapido.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource("classpath:db.properties")
@ComponentScan(basePackages = {"com.rapido.dao,com.rapido.service"})
@EnableTransactionManagement
public class PersistenceJavaConfig {

    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource()
    {
        DriverManagerDataSource dataSource = null;
        dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("db.driverClassName"));
        dataSource.setUrl(env.getProperty("db.url"));
        dataSource.setUsername(env.getProperty("db.username"));
        dataSource.setPassword(env.getProperty("db.password"));

        return dataSource;

    }
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(DataSource dataSource)
    {
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = null;
        Properties props = null;
       // HibernateJpaVendorAdapter jpaVendorAdapter = null;

        localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        localContainerEntityManagerFactoryBean.setDataSource(dataSource);

        props = new Properties();
        props.put("hibernate.show_sql","true");
        localContainerEntityManagerFactoryBean.setJpaProperties(props);
        //jpaVendorAdapter = new HibernateJpaVendorAdapter();
       // jpaVendorAdapter.setShowSql(true);
        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        localContainerEntityManagerFactoryBean.setPackagesToScan("com.rapido.entities");
        localContainerEntityManagerFactoryBean.setPersistenceUnitName("rapidoPu");

        return localContainerEntityManagerFactoryBean;
    }


     @Bean
     public JpaTransactionManager jpaTransactionManager(EntityManagerFactory emf)
     {
         return new JpaTransactionManager(emf);
     }

}
