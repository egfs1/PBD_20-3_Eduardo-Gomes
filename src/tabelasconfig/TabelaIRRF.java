package tabelasconfig;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tabelairrf")
public class TabelaIRRF {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private Date vigencia;
	
	@Column
	private double valorMinimo;
	
	@Column
	private double valorMaximo;
	
	@Column
	private double aliquota;
	
	@Column
	private double valorDeduzir;
	
}
