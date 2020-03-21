package main.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Configuration
@Setter
@ToString
@Validated
@ConfigurationProperties(prefix = "mainpackage")
public class Properties {

    @Getter
    @Value("${testProperty.prefix}")
    private String prefix;

}

