import java.sql.*;
import java.util.Properties;

//import org.postgresql;

public class App {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:postgresql://localhost/A3_E1";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "Andig_54");
        // props.setProperty("ssl", "true");
        Connection conn = DriverManager.getConnection(url, props);

        String[] tables = { "\"REGISTRATION\"", "\"STUDENT\"", "\"COURSE\"" };
        for (String i : tables) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM " + i);
            System.out.println("\nTable: " + i);
            while (rs.next()) {
                // System.out.print("Column 1 returned ");
                if (i == "\"STUDENT\"") {
                    System.out.println(rs.getString(1)+"   "+rs.getString(2)+"   "+rs.getString(3)+"   "+rs.getString(4));
                } else {
                    System.out.println(rs.getString(1)+"   "+rs.getString(2)+"   "+rs.getString(3));
                }
            }
            rs.close();
            st.close();
        }

        // String url =
        // "jdbc:postgresql://localhost/test?user=fred&password=secret&ssl=true";
        // Connection conn = DriverManager.getConnection(url);
    }
}
