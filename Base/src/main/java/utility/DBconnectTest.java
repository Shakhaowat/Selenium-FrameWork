package utility;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;

public class DBconnectTest extends ConnectDB {
    static ConnectDB db = null;

    public static void main(String[] args) throws ClassNotFoundException,SQLException, IOException {
        {

        db = new ConnectDB();
        db.readDataBase("logininfo","email");

    }
}
}