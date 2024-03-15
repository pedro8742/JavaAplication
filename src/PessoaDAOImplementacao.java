import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PessoaDAOImplementacao implements PessoaDAO{
    private ConexaoMySQL conexao;
    public PessoaDAOImplementacao(ConexaoMySQL conexao) {
        this.conexao = conexao;
    }
    @Override
    public void cadastrar(Pessoa pessoa){
        String sql = "INSERT INTO pessoas (nome, email) VALUES (?, ?)";
        try (PreparedStatement stmt = conexao.getConexao().prepareStatement(sql)) {
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void atualizar(Pessoa pessoa) {
        String sql = "UPDADE pessoas Set nome = ? WHERE email = ?";
        try (PreparedStatement stmt = conexao.getConexao().prepareStatement(sql)) {
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleter(Pessoa pessoa) {
        String sql = "DELETE FROM pessoas WHERE email = ?";
        try (PreparedStatement stmt = conexao.getConexao().prepareStatement(sql)) {
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Pessoa pesquisar(String email) {
        Pessoa pessoa = null;
        String sql = "SELECT * FROM pessoas WHERE email = ?";
        try (PreparedStatement stmt = conexao.getConexao().prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String nome = rs.getString("nome");
                pessoa = new Pessoa(nome, email);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
