package antonioschettini.u5_w1_d1.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data // con il data mi crea automaticamente getter setter e tostrin
@NoArgsConstructor
@ToString(callSuper = true)
public class Topping extends ElementoMenu {
    public Topping(String nome, int calorie, double prezzo) {
        super(nome, prezzo, calorie);
    }
}
