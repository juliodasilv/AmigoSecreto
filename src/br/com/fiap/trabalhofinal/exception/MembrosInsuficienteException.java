package br.com.fiap.trabalhofinal.exception;

public class MembrosInsuficienteException extends Exception {

	private static final long serialVersionUID = 7815534543008419914L;

	@Override
	public String getMessage() {
		return "É necessario pelo menos 3 membros no grupo para realizar o sorteio.";
	}

}
