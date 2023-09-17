package no.itfakultetet.maskiner;

import java.sql.*;

public class Postgres {

    public Postgres(String query) {

        String url = "jdbc:postgresql://itfakultetet.no/maskiner?user=kurs&password=kurs123&ssl=false";
        try (Connection conn = DriverManager.getConnection(url)) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();



        } catch (SQLException e) {
            System.out.println("Noe gikk galt: \nFeilkode:"+ e.getErrorCode()+"\nFeilmelding: "+e.getMessage());
        }

    }

 }
