public class Pessoa {
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private String nome;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;

    public Pessoa(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

}
