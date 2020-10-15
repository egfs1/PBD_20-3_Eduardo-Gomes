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
	@NamedQuery(name="MesDeReferencia.findAll", 
			query="SELECT x FROM MesDeReferencia x ORDER BY x.id DESC"),
	
	@NamedQuery(name="MesDeReferencia.findByVigencia", 
			query="SELECT x FROM MesDeReferencia x WHERE x.vigencia = :vigencia"),
})

@Entity
@Table(name="mesdereferencia")
public class MesDeReferencia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private Date vigencia;
	
	@Column
	private Long idSalarioMinimo;
	
	@Column
	private Long idINSS;
	
	@Column
	private Long idIRRF;
	
	@Column
	private Long idSalarioFamilia;

	public MesDeReferencia(Date vigencia, Long idSalarioMinimo, Long idINSS, Long idIRRF, Long idSalarioFamilia) {
		this.vigencia = vigencia;
		this.idSalarioMinimo = idSalarioMinimo;
		this.idINSS = idINSS;
		this.idIRRF = idIRRF;
		this.idSalarioFamilia = idSalarioFamilia;
	}

	public MesDeReferencia() {
	}

	public Long getId() {
		return id;
	}

	public Date getVigencia() {
		return vigencia;
	}

	public Long getIdSalarioMinimo() {
		return idSalarioMinimo;
	}

	public Long getIdINSS() {
		return idINSS;
	}

	public Long getIdIRRF() {
		return idIRRF;
	}

	public Long getIdSalarioFamilia() {
		return idSalarioFamilia;
	}
	
	public static int[] columnsSize() {
		int[] array = {49, 145, 145, 145, 145, 145};
		return array;
	}
}
