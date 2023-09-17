package no.itfakultetet.maskiner;

import java.sql.*;

public class Postgres {
    Connection conn;
    public Postgres() {

    }

    public void insertMaskin(Datamaskin maskin) throws SQLException {

        String url = "jdbc:postgresql://itfakultetet.no/maskiner?user=kurs&password=kurs123&ssl=false";
        try (Connection conn = DriverManager.getConnection(url)) {
            Statement st = conn.createStatement();
            // ResultSet rs = st.executeQuery(query);
            // ResultSetMetaData rsmd = rs.getMetaData();
            String tabell = null;
            if(maskin.getClass().equals("Laptop")) tabell ="laptop";
            if(maskin.getClass().equals("Desktop")) tabell ="desktop";
            if(maskin.getClass().equals("Server")) tabell ="server";

            final String INSERT_MASKIN = "INSERT INTO " + tabell +
                    "  (merke, modell, pris) VALUES " +
                    " (?, ?, ?);";
            PreparedStatement preparedStatement = conn.prepareStatement(INSERT_MASKIN);

            preparedStatement.setString(1, maskin.getMerke());
            preparedStatement.setInt(2, maskin.getÅrsmodell());
            preparedStatement.setInt(3, maskin.getPris());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Noe gikk galt: \nFeilkode:" + e.getErrorCode() + "\nFeilmelding: " + e.getMessage());
        }


    }


}
