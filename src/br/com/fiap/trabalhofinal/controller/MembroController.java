package br.com.fiap.trabalhofinal.controller;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.fiap.trabalhofinal.model.Membro;
import br.com.fiap.trabalhofinal.model.dao.GrupoDAO;
import br.com.fiap.trabalhofinal.model.dao.MembroDAO;

/**
 * @author Julio
 *
 */
@Controller
@Transactional
public class MembroController {
	
	@Autowired
	private MembroDAO membroDao;

	@Autowired
	private GrupoDAO grupoDao;
	
	@RequestMapping("/membro/iniciarCadastro")
	public String iniciarCadastro() {
		return "cadastro/cadastrarMembro";
	}

	@RequestMapping(value = "/membro/cadastrar", method = RequestMethod.POST)
	public String cadastrar(Membro membro, ModelMap model) {
		try {
//			membro = membroDao.adicionar(membro);
			return "home";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.addAttribute("erro", e.getMessage());
			return "cadastro/cadastrarMembro";
		}
	}

	@RequestMapping("/membro/visualizarAmigoSecreto")
	public String visualizar() {
		if(true)
			return "visualizar/visualizarAmigoSecreto";
		else
			return "amigoNaoSorteado";
	}

	public MembroDAO getMembroDao() {
		return membroDao;
	}

	public void setMembroDao(MembroDAO membroDao) {
		this.membroDao = membroDao;
	}

	public GrupoDAO getGrupoDao() {
		return grupoDao;
	}

	public void setGrupoDao(GrupoDAO grupoDao) {
		this.grupoDao = grupoDao;
	}
	
}
