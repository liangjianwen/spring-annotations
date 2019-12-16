package com.ljw.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Profile:
 *      Spring为我们提供的可以根据当前环境，动态激活和切换一系列组件的功能；
 *
 * 开发环境、测试环境、生产环境；
 * 数据源：(/A)(/B)(/C);
 * @Profile
 */
@Configuration
public class MainConfigOfProfile {

    @Bean
    public DataSource dataSourceTest() throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("casa");
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/ljw_test");
        comboPooledDataSource.setDriverClass("com.mysql.jdbc.Driver");
        return comboPooledDataSource;
    }

    @Bean
    public DataSource dataSourceDev() throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("casa");
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/ljw_test");
        comboPooledDataSource.setDriverClass("com.mysql.jdbc.Driver");
        return comboPooledDataSource;
    }

    @Bean
    public DataSource dataSourceProd() throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("casa");
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/ljw_test");
        comboPooledDataSource.setDriverClass("com.mysql.jdbc.Driver");
        return comboPooledDataSource;
    }
}
