package com.test.quote;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@EnableAutoConfiguration
@Component
public class ActiveMQProperties {
	
	
	@Value("${spring.amq.messaging.producerBrokerURL}")
	private String producerBrokerURL;

	@Value("${spring.amq.messaging.consumerBrokerURL}")
	private String consumerBrokerURL;

	@Value("${spring.amq.messaging.maxConnections}")
	private Integer maxConnections;

	@Value("${spring.amq.messaging.maximumActiveSession}")
	private Integer maximumActiveSession;

	@Value("${spring.amq.messaging.maximumRedeliveryDelay}")
	private Integer maximumRedeliveryDelay;

	@Value("${spring.amq.messaging.maximumRedeliveries}")
	private Integer maximumRedeliveries;

	@Value("${spring.amq.messaging.concurrentConsumers}")
	private Integer concurrentConsumers;

	@Value("${spring.amq.messaging.backOffMultiplier}")
	private Integer backOffMultiplier;

	public String getProducerBrokerURL() {
		return producerBrokerURL;
	}

	public String getConsumerBrokerURL() {
		return consumerBrokerURL;
	}

	public Integer getMaxConnections() {
		return maxConnections;
	}

	public Integer getMaximumActiveSession() {
		return maximumActiveSession;
	}

	public Integer getMaximumRedeliveryDelay() {
		return maximumRedeliveryDelay;
	}

	public Integer getMaximumRedeliveries() {
		return maximumRedeliveries;
	}

	public Integer getConcurrentConsumers() {
		return concurrentConsumers;
	}

	public Integer getBackOffMultiplier() {
		return backOffMultiplier;
	}
	
	
}
