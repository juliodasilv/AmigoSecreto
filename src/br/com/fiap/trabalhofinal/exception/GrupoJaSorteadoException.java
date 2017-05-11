package br.com.fiap.trabalhofinal.exception;

/**
 * @author Julio, Helena
 *
 */
public class GrupoJaSorteadoException extends Exception {
	
	private static final long serialVersionUID = -5941864901558500943L;

	@Override
	public String getMessage() {
		return "Seu grupo de amigo secreto já foi sorteado!";
	}
}
