package demo;

import demo.domain.UserInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InfoAnalysisServiceApplication {

    public static void main(String[] args){
        SpringApplication.run(InfoAnalysisServiceApplication.class);
        UserInfo userInfo = new UserInfo();
    }
}
