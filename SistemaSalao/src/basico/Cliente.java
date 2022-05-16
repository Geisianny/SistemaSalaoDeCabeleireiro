
package basico;

import excecoes.DadoInvalidoException;
import java.io.Serializable;



/**Classe represetativa de Cliente
 * 
 * @author Geisiannny Bernardo
 */

public class Cliente extends Pessoa implements Serializable, ICliente,  IUsuario{

    private Agendamento agenda;
    private int id;

    
    public Cliente(Agendamento agenda, int id, String endereco, String email,
            String nome, int telefone) {
        super(endereco, email, nome, telefone);
        this.agenda = agenda;
        this.id = id;
    } 
    
    public Cliente(Agendamento agenda,String nome,int numero){
        super(nome, numero);
        this.agenda = agenda;
    }
    
    public Agendamento getAgenda() {
        return agenda;
    }

    public void setAgenda(Agendamento agenda) {
        this.agenda = agenda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public boolean clientesComHorariosIguais(Cliente c1, Cliente c2){
        
        if(c1.agenda.horario.equals(c2.agenda.horario)){
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    public  Cliente atualizarTelefone(Cliente cliente, int telefone) {
        
        cliente.telefone = telefone;
        
        return cliente;
    }

     @Override
    public String verificarInformacoes() {
        
        return "Cliente: " + "\nNome: " + nome +
                "\nEndereco: " + endereco +
                "\nTelefone: " + telefone +
                "\nAgendamento: " + "\nServiço: " +
                agenda.servico + "\nCodigo de "
                + "agendamento: " + 
                agenda.codigoDeAgendamento+ 
                "\nHorario: " + agenda.horario +
                "\nPrestador de serviço: " + 
                agenda.prestadorDoServico +
                "\nValor do serviço: " + agenda.valorDoServico +"\n";
    }
    
    

   @Override
    public int solicitarID(int numero)  throws DadoInvalidoException {
       
        if(numero != 0 && numero > 0){
            return numero;
        }
        throw new DadoInvalidoException("Erro: ID invalido!");
        
       
    }
    
   
    @Override
        public String toString() {

            return "Dados Cliente:" + 
                    "\nNome: " + nome +
                    "\nEndereco: " + endereco +
                    "\nTelefone: " + telefone +
                    "\nAgendamento: " + "\nServiço: " +
                    agenda.servico + "\nCodigo de "
                    + "agendamento: " + 
                    agenda.codigoDeAgendamento+ 
                    "\nHorario: " + agenda.horario +
                    "\nPrestador de serviço: " + 
                    agenda.prestadorDoServico +
                    "\nID: " + id +
                    "\nValor do serviço: " + agenda.valorDoServico +"\n";


        }
    
   
    
}
