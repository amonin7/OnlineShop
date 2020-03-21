package main;

import main.config.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShopBackendApp {

    private static final Logger log = LoggerFactory.getLogger(ShopBackendApp.class);

    private Properties props;

    public ShopBackendApp(Properties properties) {
        this.props = properties;
        log.info("\n\n\t" + this.props.getPrefix() + "\n");
    }

    public static void main(String[] args) {
        SpringApplication.run(ShopBackendApp.class, args);
    }

}
