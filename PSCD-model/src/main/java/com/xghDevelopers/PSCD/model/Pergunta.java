package com.xghDevelopers.PSCD.model;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="`XGH_PSCD_PER`")
@AttributeOverrides({
	@AttributeOverride(name="id", column=@Column(name="`PER_PK_ID`")),
	@AttributeOverride(name="dtCriacao", column=@Column(name="`PER_DT_CRIACAO`"))
})
public class Pergunta extends EntityID{
	
	private static final long serialVersionUID = 9078166537257306425L;

	@Column(name="`PER_TXT_QUESTAO`")
	private String questao;
	
	@Column(name="`PER_VAL_SIM`")
	private Double sim;
	
	@Column(name="`PER_VAL_NAO`")
	private Double nao;
	
	@Column(name="`PER_VAL_TALVEZ`")
	private Double talvez;
	
	@ManyToMany(mappedBy="listPergunta")
	private Set<Dimensao> listDimensao;
	
	public String getQuestao() {
		return questao;
	}

	public void setQuestao(String questao) {
		this.questao = questao;
	}

	public Double getSim() {
		return sim;
	}

	public void setSim(Double sim) {
		this.sim = sim;
	}

	public Double getNao() {
		return nao;
	}

	public void setNao(Double nao) {
		this.nao = nao;
	}

	public Double getTalvez() {
		return talvez;
	}

	public void setTalvez(Double talvez) {
		this.talvez = talvez;
	}

	public Set<Dimensao> getListDimensao() {
		return listDimensao;
	}

	public void setListDimensao(Set<Dimensao> listDimensao) {
		this.listDimensao = listDimensao;
	}
	
}
