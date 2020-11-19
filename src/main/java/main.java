import pl.system.table.TableImpl;
import java.sql.SQLException;

public class main {

    public static void main(String[] args) throws SQLException {
        TableImpl table = new TableImpl();

        table.createTable();

    }

}
