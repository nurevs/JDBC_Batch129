import Utilities.JdbcUtils;
import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static Utilities.DatabaseUtilities.*;

public class MedunnaRoomTest {
    @Test
    public static void main(String[] args) throws SQLException {
        //"john_doe" isimli kullanıcı tarafından oda olusturuldu mu?

        JdbcUtils.connectToDataBase("medunna.com","medunna_db",
                "medunna_user","medunna_pass_987");

        Statement statement=JdbcUtils.createStatement();
        String sql01="select created_by from room";

        ResultSet resultSet =statement.executeQuery(sql01);
        List<String> created_byList=new ArrayList<>();

        while (resultSet.next()){//tek tek butun satirlardan veri aliyoruz
            created_byList.add(resultSet.getString(1));
        }
        System.out.println("Oda olusturanlar: "+created_byList);

        Assert.assertTrue("Database'de kayit bulunamdi..",created_byList.contains("john_doe"));


        JdbcUtils.closeConnectionAndStatement();


    }
    //ODEVVV
    @Test
    public void test02(){

        //Rosetta Luettgen
    }
}
