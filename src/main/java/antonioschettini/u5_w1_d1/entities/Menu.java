package antonioschettini.u5_w1_d1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data // con il data mi crea automaticamente getter setter e tostring
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    private List<Pizza> pizzas;
    private List<Topping> toppings;
    private List<Drink> drinks;

    // Creo un metodo per stampare il menù nel sout
    public void stampaMenu() {
        System.out.println("-----------------------------------------");
        System.out.println("Pizzeria Menù");
        System.out.println("-----------------------------------------");

        System.out.println("Lista Pizze");
        pizzas.forEach(pizza -> System.out.println(pizza.getNome() + " Calorie: " + pizza.getCalorie() + " Prezzo " + pizza.getPrezzo() + " €"));
//        for (Pizza pizza : pizzas) {
//            System.out.println(pizza.getNome() + " Calorie: " + pizza.getCalorie() + " Prezzo " + pizza.getPrezzo() + " €");
//        }

        System.out.println("-----------------------------------------");

        System.out.println("Toppings");
        toppings.forEach(topping -> System.out.println(topping.getNome() + " Calorie: " + topping.getCalorie() + " Prezzo " + topping.getPrezzo() + " €"));
//        for (Topping topping : toppings) {
//            System.out.println(topping.getNome() + " Calorie: " + topping.getCalorie() + " Prezzo " + topping.getPrezzo() + " €");
//        }

        System.out.println("-----------------------------------------");

        System.out.println("Drinks");
        drinks.forEach(drink -> System.out.println(drink.getNome() + " Calorie: " + drink.getCalorie() + " Prezzo " + drink.getPrezzo() + " €"));
//        for (Drink drink : drinks) {
//            System.out.println(drink.getNome() + " Calorie: " + drink.getCalorie() + " Prezzo " + drink.getPrezzo() + " €");
//        }

        System.out.println("-----------------------------------------");
    }

}
