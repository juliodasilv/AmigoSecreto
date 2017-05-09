package br.com.fiap.trabalhofinal.controller;


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
import br.com.fiap.trabalhofinal.service.AmigoSecretoService;

/**
 * @author Julio
 */
@Controller
@Transactional
public class GrupoController {
	
	@Autowired
	private AmigoSecretoService service;
	
	@RequestMapping("/grupo/iniciarSorteio")
	public String iniciarSorteio(ModelMap model, HttpSession sessao) {
		Membro membro = (Membro) sessao.getAttribute("usuario");
		model.addAttribute("grupo", service.buscarGrupoPorId(membro.getGrupo().getId()));
		model.addAttribute("membros", service.listarMembrosrPorIdGrupo(membro.getGrupo().getId()));
		return "pesquisa/pesquisarGrupoParaSorteio";
	}

	@RequestMapping("/grupo/sortear")
	public String sortear(@RequestParam("idGrupo") long idGrupo, HttpSession sessao, ModelMap model) {
		try {
			service.sortearAmigoSecreto(idGrupo);
			model.addAttribute("msg", "Sorteio realizado com sucesso!");
			return "home";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.addAttribute("msg", e.getMessage());
			return "pesquisar/pesquisarGrupoParaSorteio";
		}
	}
	
	@RequestMapping("/grupo/pesquisar")
	public String iniciarPesquisar(HttpSession sessao, ModelMap model) {
		Membro usuario = (Membro) sessao.getAttribute("usuario");
		if(usuario.getGrupo() != null){
			model.addAttribute("msg", "Você ja pertence a um grupo de amigo secreto!");
			return "home";
		}else{
			model.addAttribute("grupos", service.listarGrupos());
			return "pesquisa/pesquisarGrupo";
		}
	}
	
	@RequestMapping(value = "/grupo/entrar", method = RequestMethod.POST)
	public String entrar(@RequestParam("idGrupo") long idGrupo, HttpSession sessao, ModelMap model) {
		try {
			//Pega o usuario logado na sessao
			Membro membro = (Membro) sessao.getAttribute("usuario");
			//Adiciona o usuario logado no grupo selecionado
			service.adicionaMembroNoGrupo(idGrupo, membro);
			model.addAttribute("msg", "Você foi adicionado ao grupo com sucesso!");
			return "home";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.addAttribute("msg", e.getMessage());
			return "pesquisa/pesquisarGrupo";
		}
	}

	@RequestMapping(value = "/grupo/listarMembros", method = RequestMethod.POST)
	public String listar(@RequestParam("idGrupo") long idGrupo, ModelMap model) {
		model.addAttribute("selected", idGrupo);
		model.addAttribute("grupos", service.listarGrupos());
		model.addAttribute("membros", service.listarMembrosrPorIdGrupo(idGrupo));
		return "pesquisa/pesquisarGrupo";
	}

	@RequestMapping("/grupo/iniciarCadastro")
	public String iniciarCadastro(HttpSession sessao, ModelMap model) {
		Membro usuario = (Membro) sessao.getAttribute("usuario");
		if(usuario.getGrupo() != null){
			model.addAttribute("msg", "Você ja pertence a um grupo de amigo secreto, portanto não pode criar um novo!");
			return "home";
		}
		return "cadastro/cadastrarGrupo";
	}
	
	@RequestMapping(value = "/grupo/cadastrar", method = RequestMethod.POST)
	public String cadastrar(Grupo grupo, ModelMap model, HttpSession sessao) {
		try {
			Membro moderador = (Membro) sessao.getAttribute("usuario");
			service.cadastrarGrupo(grupo, moderador);
			model.addAttribute("msg", "Cadastro de grupo realizado com sucesso!");
			return "home";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.addAttribute("msg", e.getMessage());
			return "cadastro/cadastrarGrupo";
		}
	}
}
