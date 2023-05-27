package fr.orionbs.experience_service.adapter.persistence.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PersistenceConfiguration {

    @Bean
    public DataSource dataSource(PersistenceProperties persistenceProperties) {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://" + persistenceProperties.getHost() + ":" + persistenceProperties.getPort().toString() + "/" + persistenceProperties.getDatabase() + "");
        dataSourceBuilder.username(persistenceProperties.getUsername());
        dataSourceBuilder.password(persistenceProperties.getPassword());
        return dataSourceBuilder.build();
    }

}
