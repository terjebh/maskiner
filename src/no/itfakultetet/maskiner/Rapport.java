package no.itfakultetet.maskiner;

import java.sql.SQLException;

public interface Rapport {
    void visRapport(String maskinType) throws SQLException;

    void lagreRapportTilFil(StringBuilder rapportText);

     void lagreRapportIDB();
}
