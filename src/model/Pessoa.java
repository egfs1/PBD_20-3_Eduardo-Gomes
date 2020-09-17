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
	@NamedQuery(name="Pessoa.findAll", 
			query="SELECT p FROM Pessoa p"),
	
	@NamedQuery(name="Pessoa.findIDByUsuarioANDSenha", 
	query="SELECT p.id FROM Pessoa p WHERE p.usuario = :usuario AND p.senha = :senha"),
	
	@NamedQuery(name="Pessoa.existeUsuario",
	query="SELECT p FROM Pessoa p WHERE p.usuario = :usuario"),
	
	@NamedQuery(name="Pessoa.findUsuarioORID",
	query="SELECT p from Pessoa p WHERE p.usuario = :usuario OR p.id = :id")
})

@Entity
@Table(name="pessoa")
public class Pessoa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String nome;
	
	@Column
	private String naturalidade;
	
	@Column
	private int qntFilhos;
	
	@Column
	private Date dataNascimento;
	
	@Column
	private Date dataAdmissao;
	
	@Column
	private boolean sindicalizado;
	
	@Column
	private String funcao; //papeis: administrador, contador, funcionario(?)
	
	@Column
	private String tipo;   //tipo: mensalista, 40 horas semanais; horista, horas � definir
	
	@Column
	private int horasSemanaisContratadas;
	
	@Column
	private String usuario;
	
	@Column
	private String senha;
	
	
	
	public Pessoa() {
	}
	
	
	// Contrutor para adm e contador
	public Pessoa(String nome, String naturalidade, int qntFilhos, Date dataNascimento, Date dataAdmissao,
			boolean sindicalizado, String funcao, String tipo, int horasSemanaisContratadas, String usuario,
			String senha) {
		this.nome = nome;
		this.naturalidade = naturalidade;
		this.qntFilhos = qntFilhos;
		this.dataNascimento = dataNascimento;
		this.dataAdmissao = dataAdmissao;
		this.sindicalizado = sindicalizado;
		this.funcao = funcao;
		this.tipo = tipo;
		this.horasSemanaisContratadas = horasSemanaisContratadas;
		this.usuario = usuario;
		this.senha = senha;
	}
	
	// contrutor para funcionario comum
	public Pessoa(String nome, String naturalidade, int qntFilhos, Date dataNascimento, Date dataAdmissao,
			boolean sindicalizado, String funcao, String tipo, int horasSemanaisContratadas) {
		this.nome = nome;
		this.naturalidade = naturalidade;
		this.qntFilhos = qntFilhos;
		this.dataNascimento = dataNascimento;
		this.dataAdmissao = dataAdmissao;
		this.sindicalizado = sindicalizado;
		this.funcao = funcao;
		this.tipo = tipo;
		this.horasSemanaisContratadas = horasSemanaisContratadas;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public int getQntFilhos() {
		return qntFilhos;
	}

	public void setQntFilhos(int qntFilhos) {
		this.qntFilhos = qntFilhos;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isSindicalizado() {
		return sindicalizado;
	}

	public void setSindicalizado(boolean sindicalizado) {
		this.sindicalizado = sindicalizado;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getHorasSemanaisContratadas() {
		return horasSemanaisContratadas;
	}

	public void setHorasSemanaisContratadas(int horasSemanaisContratadas) {
		this.horasSemanaisContratadas = horasSemanaisContratadas;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFuncao() {
		return funcao;
	}



	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataAdmissao == null) ? 0 : dataAdmissao.hashCode());
		result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ((funcao == null) ? 0 : funcao.hashCode());
		result = prime * result + horasSemanaisContratadas;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((naturalidade == null) ? 0 : naturalidade.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + qntFilhos;
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + (sindicalizado ? 1231 : 1237);
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (dataAdmissao == null) {
			if (other.dataAdmissao != null)
				return false;
		} else if (!dataAdmissao.equals(other.dataAdmissao))
			return false;
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
			return false;
		if (funcao == null) {
			if (other.funcao != null)
				return false;
		} else if (!funcao.equals(other.funcao))
			return false;
		if (horasSemanaisContratadas != other.horasSemanaisContratadas)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (naturalidade == null) {
			if (other.naturalidade != null)
				return false;
		} else if (!naturalidade.equals(other.naturalidade))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (qntFilhos != other.qntFilhos)
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (sindicalizado != other.sindicalizado)
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", naturalidade=" + naturalidade + ", qntFilhos=" + qntFilhos
				+ ", dataNascimento=" + dataNascimento + ", dataAdmissao=" + dataAdmissao + ", sindicalizado="
				+ sindicalizado + ", funcao=" + funcao + ", tipo=" + tipo + ", horasSemanaisContratadas="
				+ horasSemanaisContratadas + ", usuario=" + usuario + ", senha=" + senha + "]";
	}
	
	
	
	
		
}
