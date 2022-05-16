package teste;


import basico.Agendamento;
import basico.Cliente;
import dados.RepositorioCliente;
import excecoes.DadoInvalidoException;
import excecoes.PessoaNaoEncontradoException;
import java.io.IOException;

/**
 *
 * @author Geisianny Bernardo
 */
public class Main {

    public static void main(String[] args) {
       
        
        Agendamento[] agendas = new Agendamento[3];
        agendas[0] = new Agendamento("corte", 675, "12:00");
        agendas[1] = new  Agendamento("Hidratacao", 678, "11:00");
        agendas[2] = new  Agendamento("corte", 1233, "16:00");
 
        
        Cliente[] clientes = new Cliente[3];
        clientes[0] = new Cliente(agendas[0],"Marie", 895763936);
        clientes[1] = new Cliente(agendas[1],"Steve", 345627891);
        clientes[2] = new Cliente(agendas[2],"Chris", 1234567789);
        
        System.out.println("Horarios iguai?: "+ clientes[0].
                clientesComHorariosIguais(clientes[0]
                , clientes[1]));
        
        
        clientes[1] = clientes[1].atualizarTelefone(clientes[1], 876789654);
        System.out.println("Numero do cliente atualizado com sucesso!\n");
        System.out.println("Cliente:\n"+clientes[1].toString()+ "\n");
        
        try {
            clientes[1].setId(clientes[1].solicitarID(-1));
        } catch (DadoInvalidoException ex) {
            ex.printStackTrace();
        }
        
        
        //Recupera arquivo
        RepositorioCliente repositorio = null;
        String arquivoRepositorio = "./repositorio.teste";
        
        try {
            repositorio = RepositorioCliente.carregarRepositorioCliente
        (arquivoRepositorio);
	} catch (IOException e) {
	    System.out.println("Não foi possível carregar o repositório"
                    + " de clientes.");
	    repositorio = new RepositorioCliente();
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	}

        // adicionando clientes
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] != null) {
                
                repositorio.adicionarCliente(clientes[i]);
               
            }
	}
        
        //mostrando clientes do sistema
        System.out.println("Clientes dos sistema: \n");
        for (int i = 0; i < repositorio.quantidadeDeClientes(); i++) {
	    try {
		Cliente c = repositorio.procurarCliente(clientes[i].getNome());
		System.out.println(c.toString());
            } catch (PessoaNaoEncontradoException |
                    ArrayIndexOutOfBoundsException e) {
		System.out.println("Não foi encontrado cliente no sistema com o "
                        + "id : " + i);
	    }
        }    

        
	// salvando repositorio no arquivo
	try {
	    repositorio.salvarRepositorioCliente(arquivoRepositorio);
	} catch (IOException e) {
	    e.printStackTrace();
	    System.out.println("Não foi possível salvar o arquivo.");
	}

    }
    
}
