package antonioschettini.u5_w1_d1;

import antonioschettini.u5_w1_d1.entities.Drink;
import antonioschettini.u5_w1_d1.entities.Ordine;
import antonioschettini.u5_w1_d1.entities.Pizza;
import antonioschettini.u5_w1_d1.entities.Tavolo;
import antonioschettini.u5_w1_d1.enums.StatoTavolo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class U5W1D1ApplicationTests {

    @Test
    @DisplayName("Test per verificare il prezzo della margherita")

    public void testPrezzoPizzaMargherita() {
        Pizza margherita = new Pizza("Pizza Margherita", 1100, 4.50, List.of());
        // Verifico il prezzo che sia 4.50
        assertEquals(4.50, margherita.getPrezzo());
    }

    @Test
    @DisplayName("Test per verifica se il tavolo diventa occupato alla creazione di un ordine")
    public void testTavoloDiventaOccupatoConOrdine() {
        Tavolo tavolo1 = new Tavolo(1, 4, StatoTavolo.LIBERO);
        //creo l'ordine
        Ordine ordine = new Ordine(1, tavolo1, 2);
        //Controllo se il tavolo diventa occupato
        assertEquals(StatoTavolo.OCCUPATO, tavolo1.getStato());
    }

    @Test
    @DisplayName("Test per verificare che agli ordini vengano aggiunti correttamente i prodotti")
    public void testConteggioElementiOrdinati() {
        Tavolo tavolo = new Tavolo(1, 4, StatoTavolo.LIBERO);
        Ordine ordine = new Ordine(1, tavolo, 2);
        // Aggiungo pizze e bevande all'ordine
        ordine.getElementiOrdinati().add(new Pizza("Pizza Margherita", 1100, 4.50, List.of()));
        ordine.getElementiOrdinati().add(new Drink("Water", 0, 1.00));
        // ho aggiunto 2 prodotti quindi verifico che la lista dell'ordine sia esattamente di due elementi
        assertEquals(2, ordine.getElementiOrdinati().size());
    }

    @ParameterizedTest
    @DisplayName("Test per verificare che il costo del coperto venga aggiunto correttamente e l'importo sia consono " + "al numero di coperti")
    @ValueSource(ints = {1, 2, 4}) // il test viene ripeturo 3 volte con numero diversi di coperti per la *
    public void testCalcoloCoperti(int numeroOspiti) {
        Tavolo tavolo = new Tavolo(1, 4, StatoTavolo.LIBERO);
        Ordine ordine = new Ordine(1, tavolo, numeroOspiti);
        // per non accendere spring fisso un costo fisso al coperto
        double costoSingoloCoperto = 2.00;
        // simulo il calcolo atteso
        double totaleAtteso = numeroOspiti * costoSingoloCoperto;
        // adesso controllo che il calcolo restituisca la somma corretta calcolandolo come il metodo ed ho parametrizzato
        // il coperto singolo
        assertEquals(totaleAtteso, ordine.calcolaTotale(costoSingoloCoperto));

    }

    @Test
    @DisplayName("Test di simulazione conto completo Cena")
    public void testCalcoloContoCena() {
        // simulo un tavolo con 2 persone che effettuano un ordine e chiedono il conto
        Tavolo tavolo = new Tavolo(1, 4, StatoTavolo.LIBERO);
        Ordine ordine = new Ordine(1, tavolo, 2);
        // inserisco i prodotti nell'ordine
        ordine.getElementiOrdinati().add(new Pizza("Pizza Margherita", 1100, 4.50, List.of()));
        ordine.getElementiOrdinati().add(new Pizza("Pizza Margherita", 1100, 4.50, List.of()));
        ordine.getElementiOrdinati().add(new Drink("Lemonade", 130, 1.50));
        ordine.getElementiOrdinati().add(new Drink("Lemonade", 130, 1.50));

        double copertoSingolo = 2.00;
        // effettuo il calcolo atteso 9 per 2 margherite + 3 per due limonate + 4 per i due coperti, totale 16
        double totaleAtteso = (4.50 * 2) + (1.50 * 2) + (2 * copertoSingolo);
        assertEquals(totaleAtteso, ordine.calcolaTotale(copertoSingolo));
    }

}

