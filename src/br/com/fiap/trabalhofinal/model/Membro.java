package br.com.fiap.trabalhofinal.model;

import java.io.Serializable;
import java.util.Date;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
 * @author Julio
 */
@Entity
@Table(name = "membro")
public class Membro implements Serializable {

	private static final long serialVersionUID = -8899573447241218176L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	
	@Size(max=128)
	@NotNull(message="{membro.nome.null}") 
	@Column(name = "NOME", nullable=false, length=128)
	private String nome;
	
	@Column(name = "CPF", nullable=false, unique=true)
//	@Pattern(regexp="[0-9]{3}\\.?[0-9]{3}\\.?[0-9]{3}\\-?[0-9]{2}", message="CPF inválido") @NotNull @NotEmpty
	private String cpf;
	
	@Size(max=15, min=6, message="A senha deve ter entre 6 e 15 caracteres") @NotNull @NotEmpty
	@Column(name = "SENHA", nullable=false, length=15)
	private String senha;
	
	@Email(message="E-mail inválido	") @NotNull @NotEmpty
	@Column(name = "EMAIL", nullable=false, length=50)
	private String email;
	
	@Column(name = "DATA_NASCIMENTO")
	@DateTimeFormat(iso=ISO.DATE, pattern="yyyy-MM-dd")
	private Date dataNascimento;
	
	@Column(name = "DETALHE_PRESENTE")
	private String detalhePresente;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_AMIGO_SECRETO", referencedColumnName = "ID")
	private Membro amigoSecreto;
	
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "ID_GRUPO", referencedColumnName = "ID") })
	private Grupo grupo;
	
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getDetalhePresente() {
		return detalhePresente;
	}

	public void setDetalhePresente(String detalhePresente) {
		this.detalhePresente = detalhePresente;
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

	@Override
	public String toString() {
		return "Membro [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", senha=" + senha + ", email=" + email
				+ ", dataNascimento=" + dataNascimento + ", detalhePresente=" + detalhePresente + ", amigoSecreto=" + amigoSecreto
				+ ", grupo=" + grupo.getNome() + "]";
	}
}