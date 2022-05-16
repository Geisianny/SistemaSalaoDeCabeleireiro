
package dados;

import basico.Cliente;
import excecoes.PessoaNaoEncontradoException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Geisianny Bernardo
 */
public class RepositorioCliente  implements Serializable {
    
    private int contCliente;
    public ArrayList<Cliente> repositorioCliente;
    
    public RepositorioCliente(){
        this.repositorioCliente = new ArrayList<Cliente>();
        this.contCliente = 0;
    }
    
    public void adicionarCliente(Cliente cliente) {
            cliente.setId(contCliente);
            this.repositorioCliente.add(cliente);
            contCliente++;
    }
        
    
    public int quantidadeDeClientes(){
        return contCliente;
    }
    
    /*procura pelo nome */
    public Cliente procurarCliente(String nome) throws PessoaNaoEncontradoException{
        for(Cliente cliente : repositorioCliente){
            if(cliente.getNome().equals(nome)){
                return cliente;
            }
        }
        throw new PessoaNaoEncontradoException("Cliente não foi encontrado"
                + " no sistema");
    }
   
    /*Procura pelo id*/
    public Cliente procurarCliente(int id) throws PessoaNaoEncontradoException{
        for(Cliente cliente : repositorioCliente){
            if(cliente.getId() == id){
                return cliente;
            }
        }
        throw new PessoaNaoEncontradoException("Cliente não foi encontrado"
                + " no sistema");
    }
    
    public void excluirCliente(String nome) throws PessoaNaoEncontradoException{
        
        Cliente c = procurarCliente(nome);
        
        if(c != null){
            repositorioCliente.remove(c);
            
        }else{
           throw new PessoaNaoEncontradoException("Cliente não foi encontrado"
                + " no sistema");
            
                
        }   
        
    }
    
    public void salvarRepositorioCliente(String caminhoArquivo) throws IOException{
        
        FileOutputStream file = new FileOutputStream(caminhoArquivo);
        ObjectOutputStream oos = new ObjectOutputStream(file);
        
        oos.writeObject(this);
        oos.close();

    }
    
    public static RepositorioCliente carregarRepositorioCliente(
                String caminhoArquivo) 
                throws IOException, ClassNotFoundException {
            
        FileInputStream fin = new FileInputStream(caminhoArquivo);
        ObjectInputStream ois = new ObjectInputStream(fin);
	RepositorioCliente resp = (RepositorioCliente) ois.readObject();
	ois.close();
        
	return resp;
    }
        
        
    
}
