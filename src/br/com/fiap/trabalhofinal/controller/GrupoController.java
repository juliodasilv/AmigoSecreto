package br.com.fiap.trabalhofinal.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.fiap.trabalhofinal.model.Grupo;
import br.com.fiap.trabalhofinal.model.Membro;
import br.com.fiap.trabalhofinal.model.dao.GrupoDAO;
import br.com.fiap.trabalhofinal.model.dao.MembroDAO;

/**
 * @author Julio
 */
@Controller
@Transactional
public class GrupoController {
	
	@Autowired
	private GrupoDAO grupoDao;

	@Autowired
	private MembroDAO membroDao;
	
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
	
	@RequestMapping("/grupo/pesquisar")
	public String iniciarPesquisar(ModelMap model) {
		try {
			model.addAttribute("grupos", grupoDao.listarTodos());
			return "pesquisa/pesquisarGrupo";
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return "erro";
		}
		
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

	@RequestMapping(value = "/grupo/listarMembros", method = RequestMethod.POST)
	public String listar(@RequestParam("idGrupo") int idGrupo, ModelMap model) {
		try {
			model.addAttribute("selected", idGrupo);
			model.addAttribute("grupos", grupoDao.listarTodos());
			model.addAttribute("membros", membroDao.listarPorIdGrupo(idGrupo));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.addAttribute("erro", e.getMessage());
		}
		
		return "pesquisa/pesquisarGrupo";
	}

	@RequestMapping("/grupo/iniciarCadastro")
	public String iniciarCadastro() {
		return "cadastro/cadastrarGrupo";
	}
	
	@RequestMapping(value = "/grupo/cadastrar", method = RequestMethod.POST)
	public String cadastrar(Grupo grupo, ModelMap model, HttpSession sessao) {
		try {
			Membro moderador = (Membro) sessao.getAttribute("usuario");
			grupo.setModerador(moderador);
			List<Membro> membros = new ArrayList<>();
			membros.add(moderador);
			grupo.setMembros(membros);
			grupo = grupoDao.adicionar(grupo);
			return "home";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.addAttribute("msg", e.getMessage());
			return "cadastro/cadastrarGrupo";
		}
	}
}
