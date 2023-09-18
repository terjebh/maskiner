package no.itfakultetet.maskiner.view;

import java.sql.SQLException;

public interface Rapport {
    void visRapport(String maskinType) throws SQLException;

    void lagreRapportTilFil(StringBuilder rapportText);

     void lagreRapportIDB();
}
