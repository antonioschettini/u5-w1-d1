package antonioschettini.u5_w1_d1.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data // con il data mi crea automaticamente getter setter e tostring
@NoArgsConstructor
@ToString(callSuper = true) // dice al to string di includere anche la superclasse
public class Pizza extends ElementoMenu {
    private List<Topping> ingredienti;

    public Pizza(String nome, int calorie, double prezzo, List<Topping> ingredienti) {
        super(nome, prezzo, calorie);
        this.ingredienti = ingredienti;
    }
}
