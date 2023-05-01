import java.sql.*;

public class Query02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        Connection con= DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                "1234");

        //3) Statement

        Statement st= con.createStatement();
        //Soru 1 : Region id'si 1 olan "country name" degerlerini cagirin

        String sql01= "select country_name from countries where region_id=1";

        ResultSet veri= st.executeQuery(sql01);

        while (veri.next()) {

            System.out.println(veri.getString(1));
        }

        //Soru2: "region_id"nin 2'den büyük olduğu "country_id" ve "country_name" değerlerini çağırın.

        String sql02="select country_id, country_name from countries where region_id>2";
        ResultSet veri2= st.executeQuery(sql02);

        while (veri2.next()) {

            System.out.println(veri2.getString(1)
            + veri2.getString(2));
        }


    }
}
