package com.sapient.kafka.config;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
@EnableRabbit
public class RabbitMQConfig {
    
    @Value("${spring.rabbitmq.host}")
    private String rabbitMQHost;

    @Value("${spring.rabbitmq.port}")
    private String rabbitMQPort;
    
    @Value("${spring.rabbitmq.username}")
    private String rabbitMQUsername;
    
    @Value("${spring.rabbitmq.password}")
    private String rabbitMQPassword;

    @Bean
    public CachingConnectionFactory cachingConnectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(rabbitMQHost);
        connectionFactory.setPort(Integer.parseInt(rabbitMQPort));
        connectionFactory.setUsername(rabbitMQUsername);
        connectionFactory.setPassword(rabbitMQPassword);
        return connectionFactory;
    }

    @Bean
    public ConnectionFactory connectionFactory() {
      return (ConnectionFactory) cachingConnectionFactory();
    }

    


}
