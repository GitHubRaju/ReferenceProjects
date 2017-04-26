package com.test.quote;

import java.util.Arrays;

import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.RedeliveryPolicy;
import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.pool.PooledConnectionFactory;
import org.apache.camel.component.jms.JmsComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.stereotype.Component;






@Configuration
@EnableAutoConfiguration
@Component
public class QueueConfigration {

	
	@Autowired
    private ActiveMQProperties activeMQProperties;
	/* @Bean  
	    public Queue queue() {  
	        return new ActiveMQQueue("SAMPLE_QUEUE");  
	    } */ 


		private  ActiveMQConnectionFactory activeMQConnectionFactory ;
	
		   
		@Bean
	    public ActiveMQComponent activeMQConsumer() {
	          activeMQConnectionFactory = new ActiveMQConnectionFactory();

	          
	          activeMQConnectionFactory.setBrokerURL(activeMQProperties.getConsumerBrokerURL()); 
	          activeMQConnectionFactory.setDisableTimeStampsByDefault(true);
	        
	          PooledConnectionFactory pooledConnectionFactory = new PooledConnectionFactory();
	          pooledConnectionFactory.setConnectionFactory(activeMQConnectionFactory);
	          pooledConnectionFactory.setMaxConnections(activeMQProperties.getMaxConnections());
	          pooledConnectionFactory.setMaximumActiveSessionPerConnection(
	        		  activeMQProperties.getMaximumActiveSession());
	          
	          RedeliveryPolicy queuePolicy = new RedeliveryPolicy();
	          queuePolicy.setUseExponentialBackOff(true);
	          queuePolicy.setBackOffMultiplier(2);
	          queuePolicy.setMaximumRedeliveryDelay(600000);
	          activeMQConnectionFactory.setRedeliveryPolicy(queuePolicy);       
	          ActiveMQComponent activeMQComponent = new ActiveMQComponent();

	          activeMQComponent.setUsePooledConnection(true);
	          activeMQComponent.setConnectionFactory(pooledConnectionFactory);
	          activeMQComponent.setCacheLevel(DefaultMessageListenerContainer.CACHE_CONSUMER);
	          activeMQComponent.setTransacted(true);

	          return activeMQComponent;
	    }
		   @Bean
		    public JmsComponent wMQConnection() {
		        JmsComponent jmsComponent = new JmsComponent();
		        jmsComponent.setConnectionFactory(activeMQConnectionFactory);
		        jmsComponent.setConcurrentConsumers(activeMQProperties.getConcurrentConsumers());
		        return jmsComponent;
		    }
		   
		

    }

