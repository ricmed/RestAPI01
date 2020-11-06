package com.pensamentogeek.RestAPI.models;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "Nome não pode ser vazio")
	@Size(min = 4, max = 255, message = "O tamanho do campo nome deve ficar entre 4 e 255")
	private String nome;

	@Min(value = 0,message = "Valor mínino para quantidade é 0")
	@Max(value = 10000, message = "Valor máximo para quantidade é 1000")
	@NotNull(message = "Não pode ser nulo")
	private Integer qtd;

	private Date dataCriacao;
	
	public Produto() {
		
	}
	
	public Produto (String nome, Integer qtd) {
		this.nome = nome;
		this.qtd = qtd;
	}
	
	@PrePersist
	public void onPrePesist(){
		if(this.dataCriacao == null){
			this.dataCriacao = new Date();
		}
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", qtd=" + qtd + ", dataCriacao=" + dataCriacao + "]";
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getQtd() {
		return qtd;
	}
	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
