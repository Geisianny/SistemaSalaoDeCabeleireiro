
package basico;

/**
 *
 * @author Geisianny Bernardo
 */
public abstract class Pessoa {
    
    protected String endereco;
    protected String email;
    protected String nome;
    protected int telefone;

    public Pessoa(String endereco, String email, String nome, int telefone) {
        this.endereco= endereco;
        this.email = email;
        this.nome = nome;
        this.telefone = telefone;
    }
    
    public Pessoa(String nome, int telefone){
        this.nome = nome;
        this.telefone = telefone;
    }
    
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
    
    
    
}
