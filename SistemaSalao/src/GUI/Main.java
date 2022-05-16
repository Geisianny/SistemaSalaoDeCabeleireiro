
package GUI;

import basico.Agendamento;
import basico.Cliente;
import dados.RepositorioCliente;
import excecoes.DadoInvalidoException;
import excecoes.PessoaNaoEncontradoException;
import java.io.IOException;
import java.util.Scanner;


/**
 *
 * @author Geisianny Bernardo
 */
public class Main {

    public static void main(String[] args)  {
        
        boolean sair = false;
        Scanner scan = new Scanner(System.in);
        
        //Manipulando o arquivo
        RepositorioCliente repositorio = null;
            String caminhoRepositorio = "./repositorio.teste";
            try {
                repositorio = RepositorioCliente.
                        carregarRepositorioCliente(caminhoRepositorio);
		} catch (IOException e) {
			System.out.println("Não foi possível carregar o "
                                + "repositório.");
			repositorio = new RepositorioCliente();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        
        do{
            System.out.println("-------------------------------");
            System.out.println("Sistema: SALÃO DE CABELEIREIRO");
            System.out.println("-------------------------------");
            System.out.println("| 1 - Procura cliente         |");
            System.out.println("| 2 - Cadastrar cliente       |");
            System.out.println("| 3 - Mostrar clientes        |");
            System.out.println("| 4 - Excluir cliente         |");
            System.out.println("| 5 - Atualizar cliente       |");
            System.out.println("| 6 - Sair do Sistema         |");
            
            System.out.println("\nDigite uma opção: ");
            int entrada = scan.nextInt();
            
            switch(entrada){
                case 1:
                    System.out.println("Digite o nome do Cliente procurado: ");
                    String nome = scan.next();
                    Cliente clienteProcurado = null;
                    try {
			clienteProcurado = repositorio.procurarCliente(nome);
                        System.out.println(clienteProcurado.toString());
                        
                    } catch (PessoaNaoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }   
                    break; 
                    
                case 2 :
                    System.out.println("Digite o nome: ");
                    String nomeCadastro = scan.next();
                    System.out.println("Digite o numero de telefone: ");
                    int numero = scan.nextInt();
                    System.out.println("Digite o horario de agendamento: ");
                    String horario = scan.next();
                    
                    System.out.println("Digite o serviço: ");
                    String servico = scan.next();
                    System.out.println("Digite o código de agendamento: ");
                    int codigo = scan.nextInt();
                    
                    Agendamento agenda = new Agendamento(servico,codigo,horario);
                    Cliente c = new Cliente(agenda,nomeCadastro,numero);
            
                   
                    repositorio.adicionarCliente(c);
                    
                    
                
                    
                    System.out.println("Cliente cadastrado no sistema com"
                            + " sucesso");
                    
                    //Salvando cliente no arquivo
                    try {
			repositorio.salvarRepositorioCliente(caminhoRepositorio);
                    } catch (IOException  e) {
			//e.printStackTrace();
			System.out.println("Não foi possível salvar o arquivo.");
		    }
                    break;

                    
                case 3:
                    
                    //Mostar todos os clientes
                    System.out.println("Clientes: \n");
                    for(int i = 0; i< repositorio.quantidadeDeClientes(); i++){
                        try {
                            Cliente c1 = repositorio.procurarCliente(i);
                            System.out.println(c1.toString());
                        } catch (PessoaNaoEncontradoException |
                            ArrayIndexOutOfBoundsException e) {
                            System.out.println("Não foi encontrado cliente "
                                    + "no sistema com o "
                            + "id : " + i);
                        }
                    }
                    
                    break;
                    
                case 4:
                    System.out.println("Digite o nome do cliente que "
                            + "deseja excluir: ");
                    String nomeExcluir = scan.next();
                    try {
                        repositorio.excluirCliente(nomeExcluir );
                        System.out.println("Cliente excluido do sistema "
                                    + "com sucesso");
                    } catch (PessoaNaoEncontradoException | NullPointerException
                            e){
                        System.out.println("Não foi encontrado cliente "
                            + "no sistema, logo não pode ser excluido");
                           
                    }
                    break;
                   
                    

                case 5:
                    
                    System.out.println("------ Atualizações ----");
                    System.out.println("1 - Atualizar ID");
                    System.out.println("2 - Atualizar telefone");
                    System.out.println("------------------------");
                    System.out.println("\nDigite a opção escolhida: ");
                    int op = scan.nextInt();
                    
                    
                    if (op == 1){
                        System.out.println("Digite o nome do cliente: ");
                        String nomeAT = scan.next();
                        
                        Cliente clienteAT = null;
                        try {
                            
                            clienteAT = repositorio.procurarCliente(nomeAT);
                           
                            System.out.println("Digite o ID ");
                            int id = scan.nextInt();
                            
                            clienteAT.setId(clienteAT.solicitarID(id));
                            System.out.println("ID atualizado com sucesso");
                            
                            
                            
                        } catch (PessoaNaoEncontradoException |
                                DadoInvalidoException e) {
                            System.out.println(e.getMessage());
                        }   
                        
                    }else if(op == 2){
                        System.out.println("Digite o nome do cliente: ");
                        String nomeAT = scan.next();
                        
                        Cliente clienteAT = null;
                        try {
                            
                            clienteAT = repositorio.procurarCliente(nomeAT);
                           
                            System.out.println("Digite o numero de telefone: ");
                            int telefone = scan.nextInt();
                            
                            clienteAT.atualizarTelefone(clienteAT, telefone);
                            System.out.println("Numero atualizado com sucesso");
                            
                            
                        } catch (PessoaNaoEncontradoException e) {
                            System.out.println(e.getMessage());
                        }   
                        
                    }
                    break;
                  
                case 6:
                   System.out.println("Saindo do sistema...");
                    sair = true;
                    break;
                    
                default:
                    System.out.println("Erro: digite uma opção valida!");
                    break;
            }
                    
        }while(!sair);
       
        
        scan.close();
        
    }
    
}

