package org.zhouwei.algorithm;

/**
 * Created by zhouwei on 2018/3/27.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.velocity.VelocityAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Arrays;

/**
 * 测试task的服务启动类
 *
 * @author zhouwei
 */
@ComponentScan(basePackages = {"org.zhouwei.algorithm"},excludeFilters = @ComponentScan.Filter(type= FilterType.ASSIGNABLE_TYPE, value={Entrance.class}))
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class,DataSourceTransactionManagerAutoConfiguration.class, VelocityAutoConfiguration.class})
@EnableTransactionManagement
@EnableScheduling
public class TestEntrance {

    private static ApplicationContext context = null;

    public static void main(String[] args) {
        context = SpringApplication.run(TestEntrance.class, args);
        final String[] beanNames = context.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (final String beanName : beanNames) {
            System.out.println(beanName);
        }
        System.out.println("test algorithm started");
    }

    public static ApplicationContext getContext(){
        return TestEntrance.context;
    }

}