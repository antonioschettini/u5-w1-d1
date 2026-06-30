package antonioschettini.u5_w1_d1.runners;

import antonioschettini.u5_w1_d1.entities.Menu;
import antonioschettini.u5_w1_d1.entities.Ordine;
import antonioschettini.u5_w1_d1.entities.Tavolo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class OrdiniRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(OrdiniRunner.class);

    private final Menu menu;
    private final Tavolo tavolo1;
    private final double costoCoperto;

    @Autowired
    public OrdiniRunner(Menu menu, @Value("${pizzeria.costoCoperto}") double costoCoperto, Tavolo tavolo1) {
        this.menu = menu;
        this.costoCoperto = costoCoperto;
        this.tavolo1 = tavolo1;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("\n Il sistema di gestione ordini è Attivo");

        Ordine ordine = new Ordine(1, tavolo1, 3);
        if (!menu.getPizzas().isEmpty()) {
            // Aggiungo le pizze
            ordine.getElementiOrdinati().add(menu.getPizzas().getFirst());
            ordine.getElementiOrdinati().add(menu.getPizzas().get(1));
            ordine.getElementiOrdinati().add(menu.getPizzas().get(2));

            // Aggiungo le bevande
            ordine.getElementiOrdinati().add(menu.getDrinks().getFirst());
            ordine.getElementiOrdinati().add(menu.getDrinks().get(1));
            ordine.getElementiOrdinati().add(menu.getDrinks().get(2));
        }

        double totale = ordine.calcolaTotale(costoCoperto);
        logger.info("\n Riepilogo ordine: " + ordine);
        logger.info("\n Conto finale: € " + totale);
        logger.info("\n Stato del tavolo dopo l'ordine: " + tavolo1.getStato());
    }
}