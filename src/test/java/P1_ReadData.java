import java.sql.*;

public class P1_ReadData {

    //MySql de day3 de..

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch59?serverTimezone=UTC", "root", "gulsen.1234");

        Statement st = con.createStatement();

        // SORU1: Talebeler tablosundan tum kayitları listeleyiniz.
        // ResultSet kayitlar=st.executeQuery("select * from talebeler");
        // while (kayitlar.next()){
        //     System.out.println(kayitlar.getInt(1)+kayitlar.getString(2)+kayitlar.getString(3)
        //     +kayitlar.getInt(4));
        // }

        //  // SORU2: Talebeler tablosunda notları 90 uzeri olan kayitları listeleyiniz.
        //  System.err.println("================================================================");
        //  ResultSet kayitlar1= st.executeQuery("select * from talebeler where yazili_notu>90");
        //  while (kayitlar1.next()){
        //      System.out.println(kayitlar1.getInt(1)+kayitlar1.getString(2)+kayitlar1.getString(3)
        //              +kayitlar1.getInt(4));
        //  }

        // SORU3: Talebeler tablosunda id'si 124 olan öğrencilerin tüm bilgilerini listeleyiniz.
        ResultSet id124 = st.executeQuery("select * from talebeler where id= 124");
        while (id124.next()) {
            System.out.printf("%-6s  %-15.15s  %-8s  %-5s\n", id124.getObject(1), id124.getObject(2), id124.getObject(3), id124.getObject(4));

        }
        // SORU4: Talebeler tablosunda notu 70 ile 90 arasindaki kisilerin isimlerini listeleyiniz.

        ResultSet not7090 = st.executeQuery("select isim, yazili_notu from talebeler where yazili_notu between '70' AND '90'");
        while (not7090.next()) {
            System.out.printf("%-16s  %-16s \n", not7090.getObject(1), not7090.getObject(2));
        }

        // SORU5: Talebeler tablosunda isminin 2. harfi e olan kisilerin veli_isimleri ile birlikte listeleyiniz.
        ResultSet veliIsmi = st.executeQuery("select isim,veli_isim from talebeler where isim like '_e%'");
        System.out.println("========================================");
        while (veliIsmi.next()) {
            System.out.printf("%-16s  %-16s \n", veliIsmi.getObject(1), veliIsmi.getObject(2));
        }

    }

}


