package br.com.fiap.trabalhofinal.controller;


import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
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

	/**
	 * @param model
	 * @param sessao
	 * @return
	 */
	@RequestMapping("/grupo/iniciarSorteio")
	public String iniciarSorteio(ModelMap model, HttpSession sessao) {
		Membro membro = (Membro) sessao.getAttribute("usuario");

		try {
			service.validarPermissaoParaSorteio(membro);
			model.addAttribute("grupo", service.buscarGrupoPorId(membro.getGrupo().getId()));
			model.addAttribute("membros", service.listarMembrosrPorIdGrupo(membro.getGrupo().getId()));
			return "pesquisa/pesquisarGrupoParaSorteio";
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "home";
		}
	}

	@RequestMapping("/grupo/sortear")
	public String sortear(HttpSession sessao, ModelMap model) {
		try {
			Membro membro = (Membro) sessao.getAttribute("usuario");
			service.sortearAmigoSecreto(membro.getGrupo().getId());
			model.addAttribute("msg", "Sorteio realizado com sucesso!");
			return "home";
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return iniciarSorteio(model, sessao);
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
			model.addAttribute("msg", e.getMessage());
			return "pesquisa/pesquisarGrupo";
		}
	}

	@RequestMapping(value = "/grupo/listarMembros", method = RequestMethod.GET)
	public String listar(@RequestParam("idGrupo") long idGrupo, ModelMap model) {
		model.addAttribute("selected", idGrupo);
		model.addAttribute("grupos", service.listarGrupos());
		model.addAttribute("membros", service.listarMembrosrPorIdGrupo(idGrupo));
		return "redirect:pesquisa/pesquisarGrupo";
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
	public String cadastrar(@Valid Grupo grupo, BindingResult bindingResult, ModelMap model, HttpSession sessao) {
		try {
			if (bindingResult.hasErrors()) {
				throw new BindException(bindingResult);
			}
			
			Membro moderador = (Membro) sessao.getAttribute("usuario");
			service.cadastrarGrupo(grupo, moderador);
			model.addAttribute("msg", "Cadastro de grupo realizado com sucesso!");
			return "home";
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "cadastro/cadastrarGrupo";
		}
	}
}
