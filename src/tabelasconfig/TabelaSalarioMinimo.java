package tabelasconfig;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(name="SalarioMinimo.findAll", 
			query="SELECT x FROM TabelaSalarioMinimo x ORDER BY x.id DESC"),
	
	@NamedQuery(name="SalarioMinimo.findByVigencia", 
	query="SELECT x FROM TabelaSalarioMinimo x WHERE x.vigencia = :vigencia"),
})

@Entity
@Table(name="tabelasalariominimo")
public class TabelaSalarioMinimo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private Date vigencia;
	
	@Column
	private double valor;
	
	public TabelaSalarioMinimo(Date vigencia, double valor) {
		super();
		this.vigencia = vigencia;
		this.valor = valor;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getVigencia() {
		return vigencia;
	}

	public void setVigencia(Date vigencia) {
		this.vigencia = vigencia;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public static int[] columnsSize() {
		int[] array = {50, 362, 362};
		return array;
	}
	
	
}
