package SampleCamel.config;

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
	 @Bean  
	    public Queue queue() {  
	        return new ActiveMQQueue("SAMPLE_QUEUE");  
	    }  
	/*@Bean
    public ActiveMQComponent activemq() {
          ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();

          //logger.info("ActiveMQComponent loaded ....... ");
          
          activeMQConnectionFactory.setBrokerURL(activeMQProperties.getProducerBrokerURL());           
          RedeliveryPolicy queuePolicy = new RedeliveryPolicy();
          queuePolicy.setUseExponentialBackOff(true);
          queuePolicy.setBackOffMultiplier(2);
          queuePolicy.setMaximumRedeliveryDelay(600000);
          activeMQConnectionFactory.setRedeliveryPolicy(queuePolicy);       
   
          ActiveMQComponent activeMQComponent = new ActiveMQComponent();
          activeMQComponent.setConnectionFactory(activeMQConnectionFactory);
          activeMQComponent.setUsePooledConnection(true);
          return activeMQComponent;*/

		private  ActiveMQConnectionFactory activeMQConnectionFactory ;
	
		   
		@Bean
	    public ActiveMQComponent activemq() {
	          activeMQConnectionFactory = new ActiveMQConnectionFactory();

	          //logger.info("ActiveMQComponent loaded ....... ");
	          
	          activeMQConnectionFactory.setBrokerURL(activeMQProperties.getConsumerBrokerURL()); 
	          activeMQConnectionFactory.setDisableTimeStampsByDefault(true);
	          activeMQConnectionFactory.setTrustAllPackages(true);//pacakge name(post Object to topic need this)//pacakge name
	          
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
	         //activeMQComponent.setConnectionFactory(activeMQConnectionFactory);
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
		        //jmsComponent.setClientId("");
		        return jmsComponent;
		    }
		   
	  /*   * Message listener container, used for invoking messageReceiver.onMessage on message reception.
	     
	    @Bean
	    public MessageListenerContainer getContainer(){
	        DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
	        container.setConnectionFactory(connectionFactory());
	        container.setDestinationName(ORDER_RESPONSE_QUEUE);
	        container.setMessageListener(messageReceiver);
	        return container;
	    }*/
	 
			/*@Bean
			public ActiveMQConnectionFactory connectionFactory(){
				ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
				connectionFactory.setBrokerURL(activeMQProperties.getProducerBrokerURL());
				
				connectionFactory.setTrustedPackages(Arrays.asList("SampleCamel"));
				connectionFactory.setTrustAllPackages(true);
				return connectionFactory;
			}
			
			@Bean 
			public JmsTemplate jmsTemplate(){
				JmsTemplate template = new JmsTemplate();
				template.setConnectionFactory(connectionFactory());
				template.setDefaultDestinationName("SAMPLE_QUEUE");
				return template;
			}*/
    }

