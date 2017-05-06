package br.com.fiap.trabalhofinal.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.fiap.trabalhofinal.exception.FalhaLoginException;
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

	public Membro verificaUsuario(String cpf, String senha) throws FalhaLoginException {
		String consulta = "select m from Membro m where m.cpf=:cpf and m.senha=:senha";
		TypedQuery<Membro> query = manager.createQuery(consulta, Membro.class);
		query.setParameter("cpf", cpf);
		query.setParameter("senha", senha);
		
		try{
			return query.getSingleResult();
		}catch(NoResultException e){
			throw new FalhaLoginException();
		}
	}

	public List<Membro> listarPorIdGrupo(int idGrupo) {
		Query query = manager.createQuery("select g from Grupo g where g.id = :idGrupo ", Grupo.class);
		query.setParameter("idGrupo", idGrupo);
		Grupo g = (Grupo) query.getSingleResult();
		return g.getMembros();
	}

}