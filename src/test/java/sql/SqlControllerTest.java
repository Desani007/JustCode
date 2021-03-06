package sql;

import org.junit.Test;
import stocks.TransactionMeta;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class SqlControllerTest {

    @Test
    public void connectionTest(){
        SqlController.connectSqlServer();
    }

    @Test
    public void insertStockTest() throws SQLException {
        //SqlController.connectSqlServer();
        SqlController.insertStock("QVC", "_2020-03", 165.2134, 175.0056, 56.9832, 138.5819, "636200296");
    }

    @Test
    public void getStockTest(){
         TransactionMeta stock = SqlController.getStock("test", "_2020-03");
         String actual = stock.getVolume();
         String expected = "636200296";
         assertEquals(actual, expected);
    }

    @Test
    public void createTableTest() {
//        SqlController.connectSqlServer();
        SqlController.createTable("QVC");
    }

    @Test
    public void crateUserTableTest(){
        SqlController.createUserTable();
    }

    @Test
    public void hasIdTest(){
        assertFalse(SqlController.hasId(0));
    }

    @Test
    public void hasIdTest2() throws SQLException {
        SqlController.insertUser(2,
                "test",
                "test",
                LocalDate.of(2012, 10, 12));
        assertTrue(SqlController.hasId(2));
    }

    @Test
    public void insertGetUserTest() throws SQLException {
        SqlController.insertUser(1,
                "test",
                "test",
                LocalDate.of(2012, 10, 12));

        System.out.println(SqlController.getUser(1).toString());
    }
}