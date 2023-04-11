package br.edu.senai.sc.servicos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
public class DataBaseConfig {
    @Bean
    public DataSource dataSource() {
        // configurações de conexão com o banco de dados
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        // configurações do entityManagerFactory
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        // configurações do transactionManager
    }

}
