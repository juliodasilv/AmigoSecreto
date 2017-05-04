package br.com.fiap.trabalhofinal.controller;


import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.fiap.trabalhofinal.model.Grupo;
import br.com.fiap.trabalhofinal.model.Membro;
import br.com.fiap.trabalhofinal.model.dao.GrupoDAO;

/**
 * @author Julio
 */
@Controller
@Transactional
public class GrupoController {
	
	@Autowired
	private GrupoDAO grupoDao;
	
	@RequestMapping("/grupo/visualizar")
	public String visualizar() {
		return "visualizar/visualizarGrupo";
	}

	@RequestMapping("/grupo/iniciarSorteio")
	public String iniciarSorteio() {
		//seta flag para exibir botão de sortear
		return "visualizar/visualizarGrupo";
	}

	@RequestMapping("/grupo/sortear")
	public String sortear(Grupo grupo, ModelMap model) {
		//sortear os membros do grupo
		try {
			grupoDao.sortear(grupo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.addAttribute("erro", e.getMessage());
		}
		
		return "home";
	}
	
	@RequestMapping("/grupo/iniciarListagem")
	public String iniciarListagem() {
		return "listagem/listarGrupo";
	}
	
	@RequestMapping(value = "/grupo/entrar", method = RequestMethod.POST)
	public String entrar(Membro membro, Grupo grupo, ModelMap model) {
		try {
			grupoDao.adicionarMembro(grupo, membro);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.addAttribute("erro", e.getMessage());
		}
		
		return "home";
	}

	@RequestMapping(value = "/grupo/listar", method = RequestMethod.POST)
	public String listar(String nome, ModelMap model) {
		try {
			Grupo grupo = grupoDao.buscarPorNome(nome);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.addAttribute("erro", e.getMessage());
		}
		
		return "listatem/listarGrupo";
	}

	@RequestMapping("/grupo/iniciarCadastro")
	public String iniciarCadastro() {
		return "cadastro/cadastrarGrupo";
	}
	
	@RequestMapping(value = "/grupo/cadastrar", method = RequestMethod.POST)
	public String cadastrar(Grupo grupo, ModelMap model, HttpSession sessao) {
		try {
			grupo.setModerador((Membro) sessao.getAttribute("usuario"));
			grupo = grupoDao.adicionar(grupo);
			return "home";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.addAttribute("erro", e.getMessage());
			return "cadastro/cadastrarGrupo";
		}
	}
}
