package tabelasconfig;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="valoresinss")
public class ValoresINSS {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private double valorMinimo;
	
	@Column
	private double valorMaximo;
	
	@Column
	private double aliquota;

	public ValoresINSS(double valorMinimo, double valorMaximo, double aliquota) {
		super();
		this.valorMinimo = valorMinimo;
		this.valorMaximo = valorMaximo;
		this.aliquota = aliquota;
	}
	
	public ValoresINSS() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getValorMinimo() {
		return valorMinimo;
	}

	public void setValorMinimo(double valorMinimo) {
		this.valorMinimo = valorMinimo;
	}

	public double getValorMaximo() {
		return valorMaximo;
	}

	public void setValorMaximo(double valorMaximo) {
		this.valorMaximo = valorMaximo;
	}

	public double getAliquota() {
		return aliquota;
	}

	public void setAliquota(double aliquota) {
		this.aliquota = aliquota;
	}
	
	public static int[] columnsSize() {
		int[] array = {50, 524, 200};
		return array;
	}
	
	public static int tableHeight() {
		return 148;
	}
	
}
