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
	@NamedQuery(name="SalarioFamilia.findAll", 
			query="SELECT x FROM TabelaSalarioFamilia x ORDER BY x.id DESC"),
	
	@NamedQuery(name="SalarioFamilia.findByVigencia", 
	query="SELECT x FROM TabelaSalarioFamilia x WHERE x.vigencia = :vigencia"),
})

@Entity
@Table(name="tabelasalariofamilia")
public class TabelaSalarioFamilia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private Date vigencia;
	
	@Column
	private double remuneracaoMensal;
	
	@Column
	private double valorUnitario;

	public TabelaSalarioFamilia(Date vigencia, double remuneracaoMensal, double valorUnitario) {
		this.vigencia = vigencia;
		this.remuneracaoMensal = remuneracaoMensal;
		this.valorUnitario = valorUnitario;
	}
	
	public TabelaSalarioFamilia() {}

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

	public double getRemuneracaoMensal() {
		return remuneracaoMensal;
	}

	public void setRemuneracaoMensal(double remuneracaoMensal) {
		this.remuneracaoMensal = remuneracaoMensal;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	
	public static int[] columnsSize() {
		int[] array = {50, 242, 242, 240};
		return array;
	}
	
}
