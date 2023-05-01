import pojos.urun;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Query07 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                "1234");


        Statement st = con.createStatement();

        // SORU: Urunler adında bir tablo olusturalım (id int, isim varchar(10), fiyat int)
        //String sql01 = "create table urunler (id int, isim varchar(10), fiyat int)";
        //st.execute(sql01);

       // String sql01="create table urunler(id int, isim varchar(10), fiyat int) ";
       // st.execute(sql01);

        List<urun> kayitlar= new ArrayList<>();
        kayitlar.add(new urun(100,"Laptop",35000));
        kayitlar.add(new urun(101,"IPad",25000));
        kayitlar.add(new urun(102,"MacBook",25000));
        kayitlar.add(new urun(103,"Anakart",15000));
        kayitlar.add(new urun(104,"IMac",15000));
        kayitlar.add(new urun(105,"IPhone",45000));


        //cok miktarda data eklemek icin PreParedStatement kullanmaliyiz

        PreparedStatement tablo=con.prepareStatement("insert into urunler values(?,?,?)");

        for(urun each:kayitlar){
            tablo.setInt(1,each.getId());//id:100   --- 1.derken 1. ? olani al diyorum
            tablo.setString(2,each.getIsim());//isim:Laptop
            tablo.setDouble(3,each.getFiyat());//fiyat:35000
            tablo.addBatch(); //Butun datalari birlestiriyor
        }

        tablo.executeBatch();// tek seferde butun datalari database e gonderiyoruz


        con.close();






    }
}
