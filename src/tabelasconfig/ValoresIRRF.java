package tabelasconfig;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="valoresirrf")
public class ValoresIRRF {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private double valorMinimo;
	
	@Column
	private double valorMaximo;
	
	@Column
	private double aliquota;
	
	@Column
	private double valorDeduzir;
	
	public ValoresIRRF(double valorMinimo, double valorMaximo, double aliquota, double valorDeduzir) {
		this.valorMinimo = valorMinimo;
		this.valorMaximo = valorMaximo;
		this.aliquota = aliquota;
		this.valorDeduzir = valorDeduzir;
	}
	
	public ValoresIRRF() {}

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

	public double getValorDeduzir() {
		return valorDeduzir;
	}

	public void setValorDeduzir(double valorDeduzir) {
		this.valorDeduzir = valorDeduzir;
	}
	
	public static int[] columnsSize() {
		int[] array = {50, 424, 150, 150};
		return array;
	}
	
	public static int tableHeight() {
		return 178;
	}
	
}
