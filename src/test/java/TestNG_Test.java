import Utilities.DatabaseUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Utilities.DatabaseUtilities.*;

public class TestNG_Test {

  @Test
    public void test01(){

    //Derya Soylu database;de kayitli mi

    createConnection();

    String sql="Select * from ogrenciler";
    Assert.assertTrue(DatabaseUtilities.getColumnData(sql,"ogrenci_ismi").contains("Derya Soylu"),
            "Database de kayit bulunamadi");

 closeConnection();
      
  }

  @Test
  public void test02(){
    //111 numarali kayit var mi
    createConnection();

    String sql="Select * from ogrenciler";
    Assert.assertTrue(DatabaseUtilities.getColumnData(sql,"okul_no").contains(111),
            "Database'de kayit bulunamadi");




    closeConnection();
  }
}
