
package basico;

import excecoes.DadoInvalidoException;

/**
 *
 * @author Geisianny Bernardo
 */
public interface IUsuario {
    
    public int solicitarID(int numero) throws DadoInvalidoException;
}
