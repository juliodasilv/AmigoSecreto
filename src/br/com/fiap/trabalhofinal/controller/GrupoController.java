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
	public String iniciarSorteio(ModelMap model, HttpSession sessao) {
		//seta flag para exibir botão de sortear
		Membro membro = (Membro) sessao.getAttribute("usuario");
		model.addAttribute("grupos", grupoDao.listarPorIdModerador(membro.getId()));
		return "pesquisa/pesquisarGrupoParaSorteio";
	}

	@RequestMapping("/grupo/sortear")
	public String sortear(@RequestParam("idGrupo") long idGrupo, HttpSession sessao, ModelMap model) {
		try {
			//Recupera lista de membros do grupo selecionado
			List<Membro> membros = membroDao.listarPorIdGrupo(idGrupo);
			//Replica a lista para uma lista temporaria
			List<Membro> membrosElegiveisParaSorteio = new ArrayList<>();
			membrosElegiveisParaSorteio.addAll(membros);
			
			//sortear os membros do grupo
			for (Membro membro : membros) {
				//Sorteia amigo secreto entre os membros elegiveis
				System.out.println("Sorteio do membro " + membro.getNome());
				Membro membroSorteado;
				do{
					//Caso o membro sorteie a si mesmo é realizado um novo sorteio
					membroSorteado = membrosElegiveisParaSorteio.get(0 + ((int)Math.random() * membrosElegiveisParaSorteio.size()));
					System.out.println("membro sorteado " + membroSorteado.getNome());
				}while(membroSorteado.getCpf().equals(membro.getCpf()));
				
				//Uma vez sorteado o membro é retirado da lista de elegíveis
				membrosElegiveisParaSorteio.remove(membroSorteado);

				//adiciona amigo secreto
				membro.setAmigoSecreto(membroSorteado);
				membroDao.adicionar(membro);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.addAttribute("erro", e.getMessage());
			return "pesquisar/pesquisarGrupoParaSorteio";
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
	public String entrar(@RequestParam("idGrupo") long idGrupo, HttpSession sessao, ModelMap model) {
		try {
			//Pega o usuario logado na sessao
			Membro membro = (Membro) sessao.getAttribute("usuario");
			
			//Adiciona o usuario logado no grupo selecionado
			membro.setGrupo(grupoDao.buscarPorId(idGrupo));
			membroDao.adicionar(membro);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.addAttribute("erro", e.getMessage());
		}
		
		return "home";
	}

	@RequestMapping(value = "/grupo/listarMembros", method = RequestMethod.POST)
	public String listar(@RequestParam("idGrupo") long idGrupo, ModelMap model) {
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
			//Cria novo grupo
			grupo.setModerador(moderador);
			grupo = grupoDao.adicionar(grupo);
			
			//Adiciona o moderador no grupo selecionado
			moderador.setGrupo(grupo);
			membroDao.adicionar(moderador);
			
			return "home";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.addAttribute("msg", e.getMessage());
			return "cadastro/cadastrarGrupo";
		}
	}
}
