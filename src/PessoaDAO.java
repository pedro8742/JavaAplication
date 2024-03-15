public interface PessoaDAO {

    void cadastrar(Pessoa pessoa);
    void atualizar(Pessoa pessoa);
    void deleter(Pessoa pessoa);
    Pessoa pesquisar(String email);
}
