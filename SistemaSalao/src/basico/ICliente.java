
package basico;

import excecoes.DadoInvalidoException;

/**
 *
 * @author Geisianny Bernardo
 */
public interface ICliente {
    
    public Cliente atualizarTelefone(Cliente cliente, int numero) 
            throws DadoInvalidoException;
    
    public String verificarInformacoes();
}
