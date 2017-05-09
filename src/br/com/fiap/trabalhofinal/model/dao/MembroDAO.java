package br.com.fiap.trabalhofinal.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Hibernate;
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

	public Membro adicionar(Membro membro){
		return manager.merge(membro);
	}

	public Membro buscarPorId(long idMembro){
		return manager.find(Membro.class, idMembro);
	}

	public Membro buscarPorEmailSenha(String email, String senha){
		String consulta = "select m from Membro m where m.email=:email and m.senha=:senha";
		TypedQuery<Membro> query = manager.createQuery(consulta, Membro.class);
		query.setParameter("email", email);
		query.setParameter("senha", senha);
		
		return query.getSingleResult();
	}

	public List<Membro> listarPorIdGrupo(long idGrupo) {
		Query query = manager.createQuery("select g from Grupo g where g.id = :idGrupo ", Grupo.class);
		query.setParameter("idGrupo", idGrupo);
		Grupo g = (Grupo) query.getSingleResult();
		
		for (Membro membro : g.getMembros()) {
			Hibernate.initialize(membro);
		}
		
		return g.getMembros();
	}

}