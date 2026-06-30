package antonioschettini.u5_w1_d1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class ElementoMenu {
    protected String nome;
    protected double prezzo;
    protected int calorie;
}
