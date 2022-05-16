
package basico;



/**
 *
 * @author Geisianny Bernardo
 */
public class Prestador extends Pessoa implements IUsuario {
    
    private double comissao;
    private boolean status;
    private String servico;
    private int id;

    public Prestador(double comissao, String codigo, String email, String nome,
            int telefone, String servico, boolean status) {
        super(codigo, email, nome, telefone);
        this.comissao = comissao;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
   
    @Override
    public int solicitarID(int numero)  {
        
        if( numero != 0 && numero > 0){
            return numero;
        }
        // throw new PessoaNaoEncontradoException("Erro: Dado invalido!");
        return -1;
       
        
    }

    
     @Override
    public String toString() {
        
        return "Dados Prestador:" + 
                "\nNome: " + nome +
                "\nEndereco: " + endereco +
                "\nTelefone: " + telefone +
                "\nAgendamento: " + "\nServiço: " +
                servico + "\nComissão: "
                + comissao + 
                "\nStatus: " + status +
                "\nServiço: " + 
                servico +
                "\nID: " + id + "\n";

                
    }
    
    
    
}
