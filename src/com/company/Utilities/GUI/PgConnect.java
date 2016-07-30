package com.company.Utilities.GUI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 * Created by micro on 30.07.2016.
 */
public class PgConnect {





        public static String connectGetRoles(String userName) {
            Connection c = null;
            Statement stmt = null;
            String  roles = null;
            try {
                Class.forName("org.postgresql.Driver");
                c = DriverManager
                        .getConnection("jdbc:postgresql://localhost:5432/mrsdb",
                                "postgres", "sox10");
                c.setAutoCommit(false);
                System.out.println("Opened database successfully");

                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM ROLES;" );
                while ( rs.next() ) {
                    int id = rs.getInt("id");
                    String  name = rs.getString("USERNAME");

                    if (name.compareTo(userName) == 0){
                        roles = rs.getString("ROLES");
                    }
                }

                rs.close();
                stmt.close();
                c.close();

            } catch ( Exception e ) {
                System.err.println( e.getClass().getName()+": "+ e.getMessage() );
                System.exit(0);
            }
            //System.out.println("Operation done successfully");
            return roles;
        }
        public static String connectGetPatient(String last, String first, String mid) {
            Connection c = null;
            Statement stmt = null;
            String  roles = null;
            try {
                Class.forName("org.postgresql.Driver");
                c = DriverManager
                        .getConnection("jdbc:postgresql://localhost:5432/mrsdb",
                                "postgres", "sox10");
                c.setAutoCommit(false);
                System.out.println("Opened database successfully");

                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM PATIENTS;" );
                while ( rs.next() ) {

                    int id = rs.getInt("id");
                    String  lastN = rs.getString("LASTNAME");
                    String  firstN = rs.getString("FIRSTNAME");
                    String  midN = rs.getString("MIDNAME");
                    String  punctureDate = rs.getString("PUNCTUREDATE");

                    //if (name.compareTo(userName) == 0){
                    roles = rs.getString("ROLES");
                    //}
                }

                rs.close();
                stmt.close();
                c.close();

            } catch ( Exception e ) {
                System.err.println( e.getClass().getName()+": "+ e.getMessage() );
                System.exit(0);
            }
            //System.out.println("Operation done successfully");
            return roles;
        }
    }


