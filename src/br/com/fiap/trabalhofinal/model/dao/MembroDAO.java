package br.com.fiap.trabalhofinal.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.fiap.trabalhofinal.model.Grupo;
import br.com.fiap.trabalhofinal.model.Membro;

/**
 * @author Julio
 */
@Repository
public class MembroDAO {
	@PersistenceContext
	private EntityManager manager;

	public Membro adicionar(Membro membro) throws Exception {
		return manager.merge(membro);
	}

	public Membro buscarPorId(Grupo grupo, Membro membro) throws Exception {
		return manager.find(Membro.class, membro.getId());
	}

}