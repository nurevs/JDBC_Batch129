import Utilities.DatabaseUtilities;
import jdk.jfr.StackTrace;
import org.junit.Assert;
import org.junit.Test;

import static Utilities.DatabaseUtilities.*;


public class JUnit_Test {

    @Test
    public void test01(){

        //Nil Naz ve Ali Can isimli ogrencilerin DataBase'de kayotli oldugunu dogrula
       createConnection();

       String sql="select * from ogrenciler";

        System.out.println(getColumnData(sql, "ogrenci_ismi"));
        Assert.assertTrue("Database'de kayit bulunamadi..",
                getColumnData(sql,"ogrenci_ismi").contains("Nil Naz"));
        Assert.assertTrue("Database'de kayit bulunamadi..",
                getColumnData(sql,"ogrenci_ismi").contains("Ali Can"));

        //getColumnData(sql, "ogrenci_ismi ") tablodaki ogrenci isimlerini verir.
        closeConnection();
    }


    @Test
    public void test02(){

        //120 numarali ogrenci var mi?
        createConnection();
        Assert.assertTrue("Database'de kayit bulunamadi..",
                getColumnData("select * from ogrenciler", "okul_no").contains(120));

         closeConnection();

    }


}
