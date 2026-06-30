package antonioschettini.u5_w1_d1.entities;

import antonioschettini.u5_w1_d1.enums.StatoOrdine;
import antonioschettini.u5_w1_d1.enums.StatoTavolo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Ordine {
    private int numeroOrdine;
    private StatoOrdine stato;
    private int numeroCoperti;
    private LocalTime oraAcquisizione;
    private Tavolo tavolo;

    // inserisco una lista che accetta per polimorfismo tutti gli elementimenu
    private List<ElementoMenu> elementiOrdinati = new ArrayList<>();

    public Ordine(int numeroOrdine, Tavolo tavolo, int numeroCoperti) {
        this.numeroOrdine = numeroOrdine;
        this.tavolo = tavolo;
        this.numeroCoperti = numeroCoperti;
        this.stato = StatoOrdine.IN_CORSO;
        this.oraAcquisizione = LocalTime.now();
        this.tavolo.setStato(StatoTavolo.OCCUPATO); // c'è un ordine tavolo setto il tavolo ad occupato
    }

    //Metodo per calcolare il totale dell'ordine da pagare
    public double calcolaTotale(double costoSingoloCoperto) {
        //apro uno stream per sommare i prezzi di tutte le cose ordinate
        double totaleProdotti = elementiOrdinati.stream()
                .mapToDouble(ElementoMenu::getPrezzo)
                .sum();
        // calcolo il costo totale dei coperti
        double totaleCoperti = this.numeroCoperti * costoSingoloCoperto;
        return totaleProdotti + totaleCoperti;
    }

    @Override
    public String toString() {
        return "Ordine{" +
                "numeroOrdine=" + numeroOrdine +
                ", stato=" + stato +
                ", numeroCoperti=" + numeroCoperti +
                ", oraAcquisizione=" + oraAcquisizione +
                ", tavolo=" + tavolo +
                ", \n elementiOrdinati=" + elementiOrdinati +
                '}';
    }
}
