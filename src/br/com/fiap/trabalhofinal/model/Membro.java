package br.com.fiap.trabalhofinal.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author Julio
 */
@Entity
@Table(name = "membro")
public class Membro {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	
	@Column(name = "NOME", nullable=false, length=50)
	private String nome;
	
	@Column(name = "CPF", nullable=false, unique=true)
	private int cpf;
	
	@Column(name = "SENHA", nullable=false, length=20)
	private String senha;
	
	@Column(name = "EMAIL", nullable=false, length=50)
	private String email;
	
	@Column(name = "DATA_NASCIMENTO")
	private Calendar dataNascimento;
	
	@Column(name = "DETALHE")
	private String detalhe;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_AMIGO_SECRETO", referencedColumnName = "ID")
	private Membro amigoSecreto;
	
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "ID_GRUPO", referencedColumnName = "ID") })
	private Grupo grupo;
	
	@Transient
	private boolean moderador = false;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getDetalhe() {
		return detalhe;
	}

	public void setDetalhe(String detalhe) {
		this.detalhe = detalhe;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Membro getAmigoSecreto() {
		return amigoSecreto;
	}

	public void setAmigoSecreto(Membro amigoSecreto) {
		this.amigoSecreto = amigoSecreto;
	}
	
	public boolean isModerador() {
		return moderador;
	}
}