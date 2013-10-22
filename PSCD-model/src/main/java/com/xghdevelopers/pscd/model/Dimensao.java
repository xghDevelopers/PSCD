package com.xghdevelopers.pscd.model;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="`XGH_PSCD_DIM`")
@AttributeOverrides({
	@AttributeOverride(name="id", column=@Column(name="`DIM_PK_ID`")),
	@AttributeOverride(name="dtCriacao", column=@Column(name="`DIM_DT_CRIACAO`"))
})
public class Dimensao extends EntityID {
	
	private static final long serialVersionUID = 4110083308232278228L;

	@Column(name="`DIM_NUM_PESO`")
	private Integer peso;
	
	@Column(name="`DIM_TXT_NOME`")
	private String nome;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="`XGH_PSCD_TID`")
	private TipoDimensao tipo;
	
	@ManyToMany
	@JoinTable(name="`XGH_PSCD_DIM_PER`",
		joinColumns=@JoinColumn(name="`DIM_PK_ID`", referencedColumnName="`DIM_PK_ID`"),
		inverseJoinColumns=@JoinColumn(name="`PER_PK_ID`", referencedColumnName="`PER_PK_ID`")
	)
	private Set<Pergunta> listPergunta;
	
	@ManyToMany
	@JoinTable(name="`XGH_PSCD_DIM_PES`",
		joinColumns=@JoinColumn(name="`DIM_PK_ID`", referencedColumnName="`DIM_PK_ID`"),
		inverseJoinColumns=@JoinColumn(name="`PES_PK_ID`", referencedColumnName="`PES_PK_ID`")
	)
	private Set<Pesquisa> listPesquisa;

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public TipoDimensao getTipo() {
		return tipo;
	}

	public void setTipo(TipoDimensao tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Pergunta> getListPergunta() {
		return listPergunta;
	}

	public void setListPergunta(Set<Pergunta> listPergunta) {
		this.listPergunta = listPergunta;
	}

	public Set<Pesquisa> getListPesquisa() {
		return listPesquisa;
	}

	public void setListPesquisa(Set<Pesquisa> listPesquisa) {
		this.listPesquisa = listPesquisa;
	}
	
}
