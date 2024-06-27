package com.example.demomultipledatasource.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.demomultipledatasource.config.marker.SsgMapper;
import com.zaxxer.hikari.HikariDataSource;
import lombok.RequiredArgsConstructor;

@Configuration
@MapperScan(
        basePackages = "com.example.demomultipledatasource",
        sqlSessionFactoryRef = "oracleSqlSessionFactory",
        annotationClass = SsgMapper.class
)
@EnableTransactionManagement
@RequiredArgsConstructor
public class OracleDataSourceConfig {

    private final ApplicationContext applicationContext;

    @Value("${spring.oracle.datasource.mybatis.config}")
    private String mybatisConfig;

    @Value("${spring.oracle.datasource.mybatis.mapper-locations}")
    private String mybatisMapperLocations;

    @Primary
    @Bean
    @Qualifier("oracleDataSource")
    @ConfigurationProperties(prefix = "spring.oracle.datasource")
    public DataSource oracleDataSource() {
        return DataSourceBuilder.create()
                .type(HikariDataSource.class)
                .build();
    }

    @Primary
    @Bean
    @Qualifier("oracleSqlSessionFactory")
    public SqlSessionFactory oracleSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(oracleDataSource());
        sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource(mybatisConfig));
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources(mybatisMapperLocations));
        return sqlSessionFactoryBean.getObject();
    }

    @Primary
    @Bean
    @Qualifier("oracleTransactionManager")
    public DataSourceTransactionManager oracleTransactionManager() {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(oracleDataSource());
        return dataSourceTransactionManager;
    }

    @Primary
    @Bean
    @Qualifier("oracleSqlSessionTemplate")
    public SqlSessionTemplate oracleSqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(oracleSqlSessionFactory());
    }

    @Primary
    @Bean
    @Qualifier("oracleSqlSessionBatchTemplate")
    public SqlSessionTemplate oracleSqlSessionBatchTemplate() throws Exception {
        return new SqlSessionTemplate(oracleSqlSessionFactory(), ExecutorType.BATCH);
    }
}