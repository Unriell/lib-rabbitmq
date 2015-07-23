package io.corbel.lib.rabbitmq.ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import io.corbel.lib.rabbitmq.config.AmqpConfiguration;
import io.corbel.lib.rabbitmq.config.AmqpConfigurer;

public class AmqpConfigurationBeanPostProcessor implements BeanPostProcessor {

	private final AmqpConfigurer configurer;

	public AmqpConfigurationBeanPostProcessor(AmqpConfigurer configurer) {
		this.configurer = configurer;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (AmqpConfiguration.class.isAssignableFrom(bean.getClass())) {
			((AmqpConfiguration) bean).configure(configurer);
		}
		return bean;
	}

}
