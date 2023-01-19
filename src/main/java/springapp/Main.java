package springapp;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Client c = new Client("1234","aina@gmail.com");
        System.out.println(c.Login());
    }
}
