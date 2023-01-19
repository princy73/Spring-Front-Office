package springapp;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws Exception {
        Client c = new Client("Andriantsiory", "Mandresy", "123456", "mandresy@gmail.com", 2500000, 0);
        System.out.println(c.Inscrisption());
    }
}
