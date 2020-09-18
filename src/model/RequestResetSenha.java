package model;

import java.io.Serializable;
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
	@NamedQuery(name="RequestResetSenha.findAll", 
			query="SELECT r FROM RequestResetSenha r"),
	
	@NamedQuery(name="RequestResetSenha.findByIDPessoa", 
	query="SELECT r FROM RequestResetSenha r WHERE r.idPessoa = :idpessoa")
})

@Entity
@Table(name="requestresetsenha")
public class RequestResetSenha implements Serializable{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
		
	@Column
	private Long idPessoa;
		
	@Column
	private Date dataRequest;
	
	public RequestResetSenha() {}
	
	public RequestResetSenha(Long idPessoa, Date dataRequest) {
		this.idPessoa = idPessoa;
		this.dataRequest = dataRequest;
	}

	public Long getId() {
		return id;
	}

	public Long getIdPessoa() {
		return idPessoa;
	}

	public Date getDataRequest() {
		return dataRequest;
	}
	
	
	

}
