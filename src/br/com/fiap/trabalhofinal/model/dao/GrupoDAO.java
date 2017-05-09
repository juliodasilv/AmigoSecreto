package br.com.fiap.trabalhofinal.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.fiap.trabalhofinal.model.Grupo;

/**
 * @author Julio
 *
 */
@Repository
public class GrupoDAO {
	@PersistenceContext
	private EntityManager manager;

	public Grupo adicionar(Grupo grupo){
		return manager.merge(grupo);
	}

	public Grupo buscarPorId(long idGrupo){
		return manager.find(Grupo.class, idGrupo);
	}
	
	public List<Grupo> listarTodos(){
		return manager.createQuery("select g from Grupo g", Grupo.class).getResultList();
	}

}