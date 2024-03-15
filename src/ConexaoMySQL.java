import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL implements IConexao{

    private String url = "";
    private String usuario = "root";
    private String senha = " ";

        @Override
        public Connection getConexao() {
            try {
                return DriverManager.getConnection(url, usuario, senha);
            } catch(SQLException e) {
                throw new RuntimeException(e);
            }
        }

}
