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
	@NamedQuery(name="TabelaINSS.findAll", 
			query="SELECT x FROM TabelaINSS x ORDER BY x.id DESC"),
	
	@NamedQuery(name="TabelaINSS.findByVigencia", 
			query="SELECT x FROM TabelaINSS x WHERE x.vigencia = :vigencia"),
})

@Entity
@Table(name="tabelainss")
public class TabelaINSS {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private Date vigencia;
	
	@Column
	private Long idValorINSS1;
	
	@Column
	private Long idValorINSS2;
	
	@Column
	private Long idValorINSS3;

	@Column
	private Long idValorINSS4;

	public TabelaINSS(Date vigencia, Long idValorINSS1, Long idValorINSS2, Long idValorINSS3, Long idValorINSS4) {
		this.vigencia = vigencia;
		this.idValorINSS1 = idValorINSS1;
		this.idValorINSS2 = idValorINSS2;
		this.idValorINSS3 = idValorINSS3;
		this.idValorINSS4 = idValorINSS4;
	}
	
	public TabelaINSS() {} 

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

	public Long getIdValorINSS1() {
		return idValorINSS1;
	}

	public void setIdValorINSS1(Long idValorINSS1) {
		this.idValorINSS1 = idValorINSS1;
	}

	public Long getIdValorINSS2() {
		return idValorINSS2;
	}

	public void setIdValorINSS2(Long idValorINSS2) {
		this.idValorINSS2 = idValorINSS2;
	}

	public Long getIdValorINSS3() {
		return idValorINSS3;
	}

	public void setIdValorINSS3(Long idValorINSS3) {
		this.idValorINSS3 = idValorINSS3;
	}

	public Long getIdValorINSS4() {
		return idValorINSS4;
	}

	public void setIdValorINSS4(Long idValorINSS4) {
		this.idValorINSS4 = idValorINSS4;
	}
	
	
	
}
