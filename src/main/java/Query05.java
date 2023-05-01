import java.sql.*;

public class Query05 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                "1234");

        Statement st = con.createStatement();


        //SORU: Öğrenciler tablosuna yen bir kayıt ekleyin (300, ‘Sena Can’, 12, ‘K’)
//        String sql01="insert into ogrenciler values(6300,'Sena Can',12,'K') ";
//        st.executeUpdate(setrtql01);
        //SORU: Öğrenciler tablosuna birden fazla veri ekleyin
        // (400, 'Sena Can', 12, 'K'), (401, 'Sena Can', 12, 'K'), (402, 'Sena Can', 12, 'K')
//        String[] veri = {"insert into ogrenciler values(500, 'Sena Can', 12, 'K')" ,
//                " insert into ogrenciler values(501, 'Sena Can', 12, 'K')",
//                "insert into ogrenciler values(502, 'Sena Can', 12, 'K')"};
//
//        int count=0;
//        for (String each:veri) {
//
//           count+=st.executeUpdate(each);
//        }
//        System.out.println(count+"  satir eklendi");

        //2. YOL
        String [] veri = {"insert into ogrenciler values (610, 'Sena Can', 12, 'K')",
                "insert into ogrenciler values (611, 'Sena Can', 12, 'K')",
                "insert into ogrenciler values (622, 'Sena Can', 12, 'K')"};

        for(String each: veri){
            st.addBatch(each);          //yukarıdaki dataların gepsini birleştirir
        }
        st.executeBatch();              //Dataları tek seferde gönderir.

        st.close();
        con.close();
    }
}
