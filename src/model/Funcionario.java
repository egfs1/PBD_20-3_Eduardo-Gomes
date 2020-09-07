package model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Funcionario  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private ArrayList<String>papeis; //papeis: administrador, contador, funcionario(?)
	
	@Column
	private String tipo;   //tipo: mensalista, 40 horas semanais; horista, horas à definir
	
	@Column
	private int horasSemanaisContratadas;
	
	@Column
	private int idPessoa;
//	Proventos
//	private double salarioBase,
//				   adicionalTempoServico, 
//				   horaExtra, 
//				   auxilioAlimentacao, 
//				   outros;
	
	
	
	

	public ArrayList<String> getPapeis() {
		return papeis;
	}

	public Funcionario(Long id, ArrayList<String> papeis, String tipo, int horasSemanaisContratadas, int idPessoa) {
	this.id = id;
	this.papeis = papeis;
	this.tipo = tipo;
	this.horasSemanaisContratadas = horasSemanaisContratadas;
	this.idPessoa = idPessoa;
}

	public void setPapeis(ArrayList<String> papeis) {
		this.papeis = papeis;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getHorasSemanaisContratadas() {
		return horasSemanaisContratadas;
	}

	public void setHorasSemanaisContratadas(int horasSemanaisContratadas) {
		this.horasSemanaisContratadas = horasSemanaisContratadas;
	}

	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + horasSemanaisContratadas;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + idPessoa;
		result = prime * result + ((papeis == null) ? 0 : papeis.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		Funcionario other = (Funcionario) obj;
		if (horasSemanaisContratadas != other.horasSemanaisContratadas)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idPessoa != other.idPessoa)
			return false;
		if (papeis == null) {
			if (other.papeis != null)
				return false;
		} else if (!papeis.equals(other.papeis))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", papeis=" + papeis + ", tipo=" + tipo + ", horasSemanaisContratadas="
				+ horasSemanaisContratadas + ", idPessoa=" + idPessoa + "]";
	}
	
	
	
	
}
