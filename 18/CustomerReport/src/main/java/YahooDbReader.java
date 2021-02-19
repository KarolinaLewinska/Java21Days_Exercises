
import java.sql.*;

public class YahooDbReader {
    String ticker;
    public YahooDbReader(String ticker) {
        this.ticker = ticker;
    }
    public void readStocks() {
        String db = "jdbc:derby://localhost:1527/sample";
        try (
           Connection conn = DriverManager.getConnection(
               db, "app", "APP");
           Statement st = conn.createStatement()) {

           Class.forName("org.apache.derby.jdbc.ClientDriver");

            ResultSet query;
            query = st.executeQuery(
                    "select TICKER, PRICE, DATE, CHANGE, LOW, HIGH, PRICEOPEN, VOLUME " +
                            "from STOCKS");
           
            while (query.next()) { 
                System.out.println("TICKER:\t" + query.getString(1));
                System.out.println("PRICE:\t" + query.getString(2));
                System.out.println("DATE:\t" + query.getString(3));
                System.out.println("CHANGE:\t" + query.getString(4));
                System.out.println("LOW:\t" + query.getString(5));
                System.out.println("HIGH:\t" + query.getString(6));
                System.out.println("PRICEOPEN:\t" + query.getString(7));
                System.out.println("VOLUME:\t" + query.getString(8));
                System.out.println();
            }
            st.close();
        } catch (SQLException s) {
            s.getMessage();
        } catch (Exception e) {
           e.getMessage();
        }
    }
    public static void main(String[] args) {
        YahooDbReader db = new YahooDbReader(args[0]);
        db.readStocks();
    }  
}
