package br.com.fiap.trabalhofinal.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.fiap.trabalhofinal.exception.FalhaLoginException;
import br.com.fiap.trabalhofinal.model.Grupo;

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

	public Grupo buscarPorId(long idGrupo) throws Exception {
		return manager.find(Grupo.class, idGrupo);
	}
	
	public List<Grupo> listarTodos() throws FalhaLoginException {
		try{
			return manager.createQuery("select g from Grupo g", Grupo.class).getResultList();
		}catch(NoResultException e){
			throw new FalhaLoginException();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Grupo> listarPorIdModerador(long idModerador) {
		Query query = manager.createQuery("select g from Grupo g where g.moderador.id=:idModerador", Grupo.class);
		query.setParameter("idModerador", idModerador);
		return query.getResultList();
	}

}