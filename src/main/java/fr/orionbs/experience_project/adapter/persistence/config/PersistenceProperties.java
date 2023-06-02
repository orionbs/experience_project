package fr.orionbs.experience_project.adapter.persistence.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "persistence")
@Data
public class PersistenceProperties {
    private String host;
    private Integer port;
    private String username;
    private String password;
    private String database;
}
