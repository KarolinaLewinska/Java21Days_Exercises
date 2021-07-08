import java.sql.*;

public class CustomerReport {
   
    public static void main(String[] args) {
       String data = "jdbc:derby://localhost:1527/sample";
       try (Connection conn = DriverManager.getConnection(data, "app", "APP");
            Statement st = conn.createStatement()) {

           Class.forName("org.apache.derby.jdbc.ClientDriver");

            ResultSet rec = st.executeQuery(
                "select PRODUCT_ID, PRODUCT_CODE, PURCHASE_COST"
                        + "from APP.PRODUCT " +
                "order by PRODUCT_ID");
            
          while (rec.next()) {
                System.out.println("CUSTOMER_ID:\t"
                    + rec.getString(1));
                System.out.println("NAME:\t" + rec.getString(2));
                System.out.println("CITY:\t" + rec.getString(3));
                System.out.println("STATE:\t" + rec.getString(4));
                System.out.println();
            }
            st.close();
          
        } catch (SQLException s) {
            System.out.println("Błąd SQL: " + s.toString() + " "
                + s.getErrorCode() + " " + s.getSQLState());
        } catch (Exception e) {
            System.out.println("Błąd: " + e.toString()
                + e.getMessage());
        }
    }
}
