package com.xghdevelopers.pscd.model;


import java.util.Date;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.xghdevelopers.pscd.model.enums.SituacaoAtivo;

@Entity
@Table(name="`XGH_PSCD_PES`")
@AttributeOverrides({
	@AttributeOverride(name="id", column=@Column(name="`PES_PK_ID`")),
	@AttributeOverride(name="dtCriacao", column=@Column(name="`PES_DT_CRIACAO`"))
})
public class Pesquisa extends EntityID{

	private static final long serialVersionUID = -5685578279289154200L;

	@Column(name="`PES_TXT_NOME`")
	private String nome;
	
	@Column(name="`PES_DT_DTDE`")
	private Date dtDe;
	
	@Column(name="`PES_DT_DTATE`")
	private Date dtAte;

	@ManyToMany(mappedBy="listPesquisa")
	private Set<Dimensao> listDimensao;
	
	@Transient
	private SituacaoAtivo situ;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDtDe() {
		return dtDe;
	}

	public void setDtDe(Date dtDe) {
		this.dtDe = dtDe;
	}

	public Date getDtAte() {
		return dtAte;
	}

	public void setDtAte(Date dtAte) {
		this.dtAte = dtAte;
	}

	public Set<Dimensao> getListDimensao() {
		return listDimensao;
	}

	public void setListDimensao(Set<Dimensao> listDimensao) {
		this.listDimensao = listDimensao;
	}

	public SituacaoAtivo getSitu() {
		return situ;
	}

	public void setSitu(SituacaoAtivo situ) {
		this.situ = situ;
	}
	

}
