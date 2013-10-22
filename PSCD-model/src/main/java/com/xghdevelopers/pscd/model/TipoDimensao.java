package com.xghdevelopers.pscd.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="`XGH_PSCD_TID`")
@AttributeOverrides({
	@AttributeOverride(name="id", column=@Column(name="`TID_PK_ID`")),
	@AttributeOverride(name="dtCriacao", column=@Column(name="`TID_DT_CRIACAO`"))
})
public class TipoDimensao extends EntityID {
	
	private static final long serialVersionUID = -537630356019341183L;

	@Column(name="`TID_TXT_NOME`")
	private String nome;
	
	@Column(name="`TID_TXT_DESCRICAO`")
	private String descricao;

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
