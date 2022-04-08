package com.bhaskarmantrala.hub.springbootaop.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * @author venkata.mantrala
 */
public class CustomBeanFactoryAware implements BeanFactoryAware {

    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public boolean isBeanCreated(String beanName) {
        return beanFactory.containsBean(beanName);
    }

}
