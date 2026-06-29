package antonioschettini.u5_w1_d1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data // con il data mi crea automaticamente getter setter e tostring
@AllArgsConstructor
@NoArgsConstructor
public class Pizza {
    private String nome;
    private int calorie;
    private double prezzo;
    private List<Topping> ingredienti;
}
