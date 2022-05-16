
package basico;

import java.io.Serializable;


/**
 *
 * @author Geisianny Bernardo
 */
public class Agendamento implements Serializable {

    public String servico;
    public int codigoDeAgendamento;
    public String horario;
    public String prestadorDoServico;
    double valorDoServico;
    
    
    
    public Agendamento(String servico, int codigoDeAgendamento, String horario){
        this.servico = servico;
        this.codigoDeAgendamento = codigoDeAgendamento;
        this.horario = horario;
    }
    
    
    public Agendamento(String servico, int codigoDeAgendamento, String horario, 
            String prestadorDoServico, double valorDoServico){
        
        this.servico = servico;
        this.codigoDeAgendamento = codigoDeAgendamento;
        this.horario = horario;
        this.prestadorDoServico = prestadorDoServico;
        this.valorDoServico = valorDoServico;
        
    }
    

    @Override
    public String toString() {
        
        return "== Agendamento ==\n" + "Servico: " + servico+
                "\nCodigo de agendamento: " +  
                codigoDeAgendamento + "\nHorario: " + horario
                + "\nPrestador de serviço: " + prestadorDoServico 
                + "\nValor do serviço: " + valorDoServico;
         
    }
    
    
    
   
    
}
