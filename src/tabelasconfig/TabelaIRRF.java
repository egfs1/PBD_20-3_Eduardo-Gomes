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
	@NamedQuery(name="TabelaIRRF.findAll", 
			query="SELECT x FROM TabelaIRRF x ORDER BY x.id DESC"),
	
	@NamedQuery(name="TabelaIRRF.findByVigencia", 
			query="SELECT x FROM TabelaIRRF x WHERE x.vigencia = :vigencia"),
	
	@NamedQuery(name="TabelaIRRF.findIdByVigencia", 
	query="SELECT x.id FROM TabelaIRRF x WHERE x.vigencia = :vigencia"),
})

@Entity
@Table(name="tabelairrf")
public class TabelaIRRF {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private Date vigencia;
	
	@Column
	private Long idValorIRRF1;
	
	@Column
	private Long idValorIRRF2;
	
	@Column
	private Long idValorIRRF3;

	@Column
	private Long idValorIRRF4;
	
	@Column
	private Long idValorIRRF5;


	
	public TabelaIRRF(Date vigencia, Long idValorIRRF1, Long idValorIRRF2, Long idValorIRRF3, Long idValorIRRF4,
			Long idValorIRRF5) {
		this.vigencia = vigencia;
		this.idValorIRRF1 = idValorIRRF1;
		this.idValorIRRF2 = idValorIRRF2;
		this.idValorIRRF3 = idValorIRRF3;
		this.idValorIRRF4 = idValorIRRF4;
		this.idValorIRRF5 = idValorIRRF5;
	}

	public TabelaIRRF() {}

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

	public Long getIdValorIRRF1() {
		return idValorIRRF1;
	}

	public void setIdValorIRRF1(Long idValorIRRF1) {
		this.idValorIRRF1 = idValorIRRF1;
	}

	public Long getIdValorIRRF2() {
		return idValorIRRF2;
	}

	public void setIdValorIRRF2(Long idValorIRRF2) {
		this.idValorIRRF2 = idValorIRRF2;
	}

	public Long getIdValorIRRF3() {
		return idValorIRRF3;
	}

	public void setIdValorIRRF3(Long idValorIRRF3) {
		this.idValorIRRF3 = idValorIRRF3;
	}

	public Long getIdValorIRRF4() {
		return idValorIRRF4;
	}

	public void setIdValorIRRF4(Long idValorIRRF4) {
		this.idValorIRRF4 = idValorIRRF4;
	}

	public Long getIdValorIRRF5() {
		return idValorIRRF5;
	}

	public void setIdValorIRRF5(Long idValorIRRF5) {
		this.idValorIRRF5 = idValorIRRF5;
	}
	
	
	
}
