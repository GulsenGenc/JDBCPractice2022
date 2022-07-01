import java.sql.*;

public class P2_ReadData_Different {

    //MySql de day5 de..personel tablosu


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch59?serverTimezone=UTC", "root", "gulsen.1234");

        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        // ilk satirdaki ilk objeyi yazdiralim
        String query = "select *from personel";
        ResultSet resultSet = st.executeQuery(query);
        System.out.println(resultSet.getRow());
        resultSet.first();

        Object ilkSatırdakiObje = resultSet.getObject(1);
        System.out.println(ilkSatırdakiObje);


        // ikinci satirdaki ilk objeyi yazdiralim
        resultSet.next();
        Object ikinciSatırdakiObje = resultSet.getObject(2);
        System.out.println(ikinciSatırdakiObje);

        // ilk sutundaki 5.degeri yazdiralim
        resultSet.absolute(5);
        System.out.println(resultSet.getObject(1));


        // 0.satira gitmemizin sebebi while sorgusu icerisinde bulunan resultSet.next() in bizi
        // birinci kayda goturmesi icindir. Eger 1.satira gidecek olsak while icindeki kod yuzunden yazdirmaya
        // 2.satirdan baslar, tum listeyi alamayiz

        // Tum listeyi yazdirmak istersek;
        while(resultSet.next()){
            System.out.println(resultSet.getObject(1).toString());
        }


    }}



