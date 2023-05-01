import java.sql.*;

public class Query01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // 1) Driver tanimla
        Class.forName("org.postgresql.Driver");

        //2)Database'e baglan
        Connection con= DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                "1234");

        //3) Statement

        Statement st= con.createStatement();
        //4) resultset
        ResultSet veri= st.executeQuery("select * from ogrenciler");

        //5)Datalari al
       while (veri.next()){
           System.out.println(veri.getInt(1)
           + veri.getString(2)
           + veri.getInt(3)
           + veri.getString(4));


       }
       //6)Baglantilari kapatma
       con.close();
       st.close();
       veri.close();

    }
}
