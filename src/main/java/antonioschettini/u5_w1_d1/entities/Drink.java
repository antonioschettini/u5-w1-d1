package antonioschettini.u5_w1_d1.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data // con il data mi crea automaticamente getter setter e tostring
@NoArgsConstructor
@ToString(callSuper = true)
public class Drink extends ElementoMenu {
    
    public Drink(String nome, int calorie, double prezzo) {
        super(nome, prezzo, calorie);
    }
}
