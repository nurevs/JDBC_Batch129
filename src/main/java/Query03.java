import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Query03 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        Class.forName("org.postgresql.Driver");

        Connection con= DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                "1234");

        Statement st= con.createStatement(); //sql kodlarimizi statement kullanrak gonderiririz

        //“workers” adında bir table oluşturup “worker_id, worker_name, worker_salary” sütunlarını ekleyin.


//        String sql01 = "Create Table workers (worker_id int, worker_name varchar(20), worker_salary int)";
//        st.execute(sql01);


        //tabloya worker_address sutunu ekleyelim

//        String sql02="alter table workers add worker_address varchar(30)";
//
//        st.execute(sql02);

        //workers tablosunu silelim
//        String sql03 = ("drop table workers");
//        st.execute(sql03);
        //execute() -> create, drop, alter table (DDL) icin kullanılır.
        con.close();
        st.close();
        





    }

}
