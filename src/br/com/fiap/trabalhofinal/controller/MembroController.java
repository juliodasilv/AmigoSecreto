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

import br.com.fiap.trabalhofinal.model.Membro;
import br.com.fiap.trabalhofinal.model.dao.GrupoDAO;
import br.com.fiap.trabalhofinal.model.dao.MembroDAO;

/**
 * @author Julio
 *
 */
@Controller
@Transactional
@RequestMapping("/membro")
public class MembroController {
	
	@Autowired
	private MembroDAO membroDao;

	@Autowired
	private GrupoDAO grupoDao;
	
	@RequestMapping("/iniciarCadastro")
	public String iniciarCadastro(Membro membro) {
		return "cadastro/cadastrarMembro";
	}

	@RequestMapping(value="/cadastrar", method=RequestMethod.POST)
	public String cadastrar(@Valid Membro membro, BindingResult bindingResult, HttpSession sessao,  ModelMap model) {
		try {
			if (bindingResult.hasErrors()) {
				throw new BindException(bindingResult);
			}
			
			membro = membroDao.adicionar(membro);
			sessao.setAttribute("usuario", membro);
			return "home";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.addAttribute("msg", e.getMessage());
			return "cadastro/cadastrarMembro";
		}
	}

	@RequestMapping("/visualizarAmigoSecreto")
	public String visualizar() {
		if(true)
			return "visualizar/visualizarAmigoSecreto";
		else
			return "amigoNaoSorteado";
	}
	
}
