package br.com.fiap.trabalhofinal.exception;

public class FalhaLoginException extends Exception {

	private static final long serialVersionUID = 7815534543008419914L;

	@Override
	public String getMessage() {
		return "CPF ou senha inválidos";
	}

}
