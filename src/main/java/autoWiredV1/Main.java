package autoWiredV1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class Main {
public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
    UUID uuid = UUID.randomUUID();
    System.out.println("NEW_UUID: "+uuid);
}
}
