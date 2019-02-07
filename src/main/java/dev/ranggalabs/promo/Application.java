package dev.ranggalabs.promo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by erlangga on 13/01/19.
 */
@SpringBootApplication
public class Application {
    /*
        TODO:
        - multi campaign (DONE)
        - multi reward (DONE)
        - logging to txn log (DONE)
        - unit test
        - stress test gatling
     */

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
