package glebdyakovcompany.app.shop.connections;
import java.sql.*;

import javax.persistence.PostRemove;

public class Postgres {

    public Postgres(){

    }

    public static void main(String[] args) {
        System.out.println("POSTGRESQL");
        try {
            Class.forName("org.postgresql.Driver");
        }
        catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        String url = "jdbc:postgresql://qpdfznab:F_WTjrlUyEp4TpzIfkkqgX8xWOt_vQTk@kashin.db.elephantsql.com/qpdfznab";
        String username = "qpdfznab";
        String password = "F_WTjrlUyEp4TpzIfkkqgX8xWOt_vQTk";

        try {
            Connection db = DriverManager.getConnection(url, username, password);
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM products");
            while (rs.next()) {
                System.out.print("Column 1 returned ");
                System.out.println(rs.getString(2));
                System.out.print("Column 2 returned ");
                System.out.println(rs.getString(3));
            }
            rs.close();
            st.close();
        } catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void workWithDB(){
        System.out.println("POSTGRESQL");
        try {
            Class.forName("org.postgresql.Driver");
        }
        catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        String url = "jdbc:postgres://qpdfznab:F_WTjrlUyEp4TpzIfkkqgX8xWOt_vQTk@kashin.db.elephantsql.com/qpdfznab";
        String username = "qpdfznab";
        String password = "F_WTjrlUyEp4TpzIfkkqgX8xWOt_vQTk";

        try {
            Connection db = DriverManager.getConnection(url, username, password);
        } catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }       
    }

}