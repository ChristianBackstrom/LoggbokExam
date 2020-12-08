import java.sql.SQLException;

public class test {
    public static void main(String[] args) throws SQLException {
        database db = new database();

        Body body = db.getData(1);

        Save save = new Save();
        Model model = new Model(save);

        model.setLogg(body);

    }
}
