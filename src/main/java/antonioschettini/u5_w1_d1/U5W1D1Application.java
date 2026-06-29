package antonioschettini.u5_w1_d1;

import antonioschettini.u5_w1_d1.entities.Menu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class U5W1D1Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(U5W1D1Application.class, args);
        Menu menu = context.getBean(Menu.class);
        menu.stampaMenu();
    }

}
