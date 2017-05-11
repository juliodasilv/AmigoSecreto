package br.com.fiap.trabalhofinal.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
		Grupo grupo =  manager.find(Grupo.class, idGrupo);
		if(grupo == null)
			throw new NoResultException();
		else
			return grupo;
	}
	
	public List<Grupo> listarTodos(){
		return manager.createQuery("select g from Grupo g", Grupo.class).getResultList();
	}

	public Grupo retornaGrupoQueOUsuarioEModerador(long idModerador) {
		Query query = manager.createQuery("select g from Grupo g where g.moderador.id = :idModerador", Grupo.class);
		query.setParameter("idModerador", idModerador);
		return (Grupo) query.getSingleResult();
	}
}