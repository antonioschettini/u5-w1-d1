package antonioschettini.u5_w1_d1.config;

import antonioschettini.u5_w1_d1.entities.Drink;
import antonioschettini.u5_w1_d1.entities.Menu;
import antonioschettini.u5_w1_d1.entities.Pizza;
import antonioschettini.u5_w1_d1.entities.Topping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PizzeriaConfig {
    // Lista Bean per i toppings
    @Bean
    public Topping cheese() {
        return new Topping("Cheese", 92, 0.70);
    }

    @Bean
    public Topping ham() {
        return new Topping("Ham", 40, 0.99);
    }

    @Bean
    public Topping onions() {
        return new Topping("Onions", 22, 0.50);
    }

    @Bean
    public Topping pineapple() {
        return new Topping("Pineapple", 30, 1.10);
    }

    @Bean
    public Topping salami() {
        return new Topping("Salami", 90, 0.99);
    }

    // Lista Pizze
    @Bean
    public Pizza margherita() {
        // passo desso la lista degli ingredienti nella lista utilizzando i bean
        return new Pizza("Pizza Margherita (tomato, cheese) ", 1100, 4.50, List.of(cheese()));
    }

    @Bean
    public Pizza hawaiian() {
        return new Pizza("Hawaiian Pizza (tomato, cheese, ham, pineapple) ", 1200, 8.50, List.of(cheese(), ham(), pineapple()));
    }

    @Bean
    public Pizza salamiPizza() {
        return new Pizza("Pizza Salami (tomato, cheese, salami) ", 1300, 7.00, List.of(cheese(), salami()));
    }

    // Lista dei drinks
    @Bean
    public Drink lemonade() {
        return new Drink("Lemonade (0.33cl) ", 130, 1.50);
    }

    @Bean
    public Drink water() {
        return new Drink("Water (0.50cl) ", 0, 1.00);
    }

    @Bean
    public Drink wine() {
        return new Drink("Wine (0.50cl, 13%) ", 650, 11.00);
    }

    // Adesso creo il menu completo per inserire la lista di pizze toppings drink, utilizzando i beean
    @Bean
    public Menu menuCompleto() {
        List<Pizza> listaPizze = List.of(margherita(), hawaiian(), salamiPizza());
        List<Topping> listaToppings = List.of(cheese(), ham(), onions(), pineapple(), salami());
        List<Drink> listaDrinks = List.of(lemonade(), water(), wine());

        // Passo le liste nel costruttore
        return new Menu(listaPizze, listaToppings, listaDrinks);
    }
}
