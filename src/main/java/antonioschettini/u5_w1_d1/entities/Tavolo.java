package antonioschettini.u5_w1_d1.entities;

import antonioschettini.u5_w1_d1.enums.StatoTavolo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tavolo {
    private int numero;
    private int MaxCoperti;
    private StatoTavolo stato;

}
