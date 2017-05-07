package br.com.fiap.trabalhofinal.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.trabalhofinal.exception.FalhaLoginException;
import br.com.fiap.trabalhofinal.model.Grupo;
import br.com.fiap.trabalhofinal.model.Membro;
import br.com.fiap.trabalhofinal.model.dao.GrupoDAO;
import br.com.fiap.trabalhofinal.model.dao.MembroDAO;

/**
 * Classe responsavel pelas regras de negocio
 * 
 * @author Julio
 */
@Service
public class AmigoSecretoService {

	@Autowired
	private GrupoDAO grupoDao;

	@Autowired
	private MembroDAO membroDao;
	
	/**
	 * Retorna o nome do amigo secreto previamente sorteado.
	 * Caso ainda não tenha sido realizado o sorteio, retorna uma msg. 
	 * 
	 * @return
	 */
	public String nomeAmigoSecretoSorteado(Membro membro) {
		Membro amigoSecreto = membroDao.buscarPorId(membro.getId()).getAmigoSecreto(); 
		
		if (amigoSecreto != null)
			return String.format("O seu amigo secreto é o/a %s", amigoSecreto.getNome());
		else
			return "Seu amigo Secreto ainda não foi sorteado.";
	}

	/**
	 * @param grupo
	 * @param moderador
	 * @throws Exception
	 */
	public void cadastrarGrupo(Grupo grupo, Membro moderador) throws Exception {
		//Cria novo grupo
		grupo.setModerador(moderador);
		grupo = grupoDao.adicionar(grupo);
		
		//Adiciona o moderador no grupo selecionado
		moderador.setGrupo(grupo);
		membroDao.adicionar(moderador);
	}

	/**
	 * @param cpf
	 * @param senha
	 * @return
	 * @throws FalhaLoginException
	 */
	public Membro verificaUsuario(String cpf, String senha) throws FalhaLoginException {
		try{
			return membroDao.buscarPorCPFSenha(cpf, senha);
		}catch(NoResultException e){
			throw new FalhaLoginException();
		}
	}

	/**
	 * @param membro
	 * @return
	 */
	public Membro cadastrarMembro(Membro membro) {
		return membroDao.adicionar(membro);
	}

	/**
	 * @param idModerador
	 * @return
	 */
	public Object listarGrupoPorIdModerador(long idModerador) {
		return grupoDao.listarPorIdModerador(idModerador);
	}

	/**
	 * @param idGrupo
	 * @return
	 */
	public List<Membro> listarMembrosrPorIdGrupo(long idGrupo) {
		return membroDao.listarPorIdGrupo(idGrupo);
	}

	public Object listarGrupos() {
		return grupoDao.listarTodos();
	}

	/**
	 * @param idGrupo
	 * @param membro
	 */
	public void adicionaMembroNoGrupo(long idGrupo, Membro membro) {
		membro.setGrupo(grupoDao.buscarPorId(idGrupo));
		membroDao.adicionar(membro);
	}

	/**
	 * @param idGrupo
	 */
	public void sortearAmigoSecreto(long idGrupo) {
		//Recupera lista de membros do grupo selecionado
		List<Membro> membros = listarMembrosrPorIdGrupo(idGrupo);
		//Replica a lista para uma lista temporaria
		List<Membro> membrosElegiveisParaSorteio = new ArrayList<>();
		membrosElegiveisParaSorteio.addAll(membros);
		
		//sortear os membros do grupo
		for (Membro membro : membros) {
			//Sorteia amigo secreto entre os membros elegiveis
			Membro membroSorteado;
			do{
				//Caso o membro sorteie a si mesmo é realizado um novo sorteio
				membroSorteado = membrosElegiveisParaSorteio.get(0 + (int)(Math.random() * membrosElegiveisParaSorteio.size()));
			}while(membroSorteado.getCpf().equals(membro.getCpf()));
			
			//Uma vez sorteado o membro é retirado da lista de elegíveis
			membrosElegiveisParaSorteio.remove(membroSorteado);

			//adiciona amigo secreto
			membro.setAmigoSecreto(membroSorteado);
			cadastrarMembro(membro);
		}
	}
}
