package tabelasconfig;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="mesdereferencia")
public class MesDeReferencia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String descricao;
	
	@Column
	private Long idSalarioMinimo;
	
	@Column
	private Long idINSS;
	
	@Column
	private Long idIRRF;
	
	@Column
	private Long idSalarioFamilia;
	
}
