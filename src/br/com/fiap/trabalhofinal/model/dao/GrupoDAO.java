package br.com.fiap.trabalhofinal.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.fiap.trabalhofinal.model.Grupo;
import br.com.fiap.trabalhofinal.model.Membro;

/**
 * @author Julio
 *
 */
@Repository
public class GrupoDAO {
	@PersistenceContext
	private EntityManager manager;

	public Grupo adicionar(Grupo grupo) throws Exception {
		return manager.merge(grupo);
	}

	public void adicionarMembro(Grupo grupo, Membro membro) throws Exception {
		try {
			String query = "INSERT INTO CURSOS (ID,IDESCOLA,DESCRICAO) VALUES (?,?,?)";
//			jdbcTemplate.update(query, curso.getId(), curso.getEscola().getId(), curso.getDescricao());
		} catch (Exception e) {
			throw e;
		}
	}

	public Grupo buscarPorNome(String nome) {
		return null;
	}

	public void sortear(Grupo grupo) {
		
	}

}