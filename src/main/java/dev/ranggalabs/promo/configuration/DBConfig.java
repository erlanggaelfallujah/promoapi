package dev.ranggalabs.promo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sql2o.Sql2o;

import javax.sql.DataSource;

/**
 * Created by erlangga on 13/01/19.
 */
@Configuration
public class DBConfig {
    @Bean
    public Sql2o sql2o(DataSource dataSource){
        Sql2o sql2o = new Sql2o(dataSource);
        return sql2o;
    }
}
