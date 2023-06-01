package LogIn;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetConnection {
    String email;
    String parola;
    static Connection connection;
    public static Connection getConnection(String email, String parola) {
        email = email;
        parola = parola;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectbd", email, parola);
            System.out.println(email);
        }catch(Exception A)
        {
         System.out.println(A);
        }
        return connection;
    }
}
