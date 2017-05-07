package br.com.fiap.trabalhofinal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
 * @author Julio
 */
@Entity
@Table(name = "grupo")
public class Grupo implements Serializable{

	private static final long serialVersionUID = -5262762781830079764L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	
	@OneToOne
	@JoinColumn(name = "ID_MODERADOR", referencedColumnName = "ID")
	private Membro moderador;

	@Column(name = "NOME", nullable = false, length=30)
	private String nome;

	@Column(name = "LOCAL_CONFRATERNIZACAO")
	private String localConfraternizacao;
	
	@Column(name = "VALOR_MINIMO_PRESENTE")
	private double valorMinimoPresente;
	
	@Column(name = "DATA_CONFRATERNIZACAO")
	@DateTimeFormat(iso=ISO.DATE, pattern="yyyy-MM-dd")
	private Date dataConfraternizacao;

	@Column(name = "DATA_SORTEIO")
	@DateTimeFormat(iso=ISO.DATE, pattern="yyyy-MM-dd")
	private Date dataSorteio;
	
	@OneToMany(mappedBy="grupo", fetch = FetchType.LAZY)
	private List<Membro> membros;

	@Transient
	//TODO 
	//Criar uma flag para permitir ou não o sorteio
	//por enquanto esta transiente para nao esquecer de fazer isso
	private boolean permiteSorteio;
	
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

	public Membro getModerador() {
		return moderador;
	}

	public void setModerador(Membro moderador) {
		this.moderador = moderador;
	}

	public double getValorMinimoPresente() {
		return valorMinimoPresente;
	}

	public void setValorMinimoPresente(double valorMinimoPresente) {
		this.valorMinimoPresente = valorMinimoPresente;
	}

	public List<Membro> getMembros() {
		return membros;
	}

	public void setMembros(List<Membro> membros) {
		this.membros = membros;
	}

	public String getLocalConfraternizacao() {
		return localConfraternizacao;
	}

	public void setLocalConfraternizacao(String localConfraternizacao) {
		this.localConfraternizacao = localConfraternizacao;
	}

	public Date getDataConfraternizacao() {
		return dataConfraternizacao;
	}

	public void setDataConfraternizacao(Date dataConfraternizacao) {
		this.dataConfraternizacao = dataConfraternizacao;
	}

	public Date getDataSorteio() {
		return dataSorteio;
	}

	public void setDataSorteio(Date dataSorteio) {
		this.dataSorteio = dataSorteio;
	}

	@Override
	public String toString() {
		return "Grupo [id=" + id + ", moderador=" + moderador.getNome() + ", nome=" + nome + ", localConfraternizacao="
				+ localConfraternizacao + ", valorMinimoPresente=" + valorMinimoPresente + ", dataConfraternizacao="
				+ dataConfraternizacao + ", quantidade membros=" + membros.size() + "]";
	}
	
}
