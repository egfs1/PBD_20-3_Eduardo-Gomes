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
			query="SELECT p FROM Pessoa p ORDER BY p.id"),
	
	@NamedQuery(name="Pessoa.findByUsuarioANDSenha", 
	query="SELECT p FROM Pessoa p WHERE p.usuario = :usuario AND p.senha = :senha"),
	
	@NamedQuery(name="Pessoa.findUsuario",
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
	private double valorHora;
	
	@Column
	private String usuario;
	
	@Column
	private String senha;
	
	
	
	public Pessoa() {
	}
	
	
	// Contrutor para adm e contador
	public Pessoa(String nome, String naturalidade, int qntFilhos, Date dataNascimento, Date dataAdmissao,
			boolean sindicalizado, String funcao, String tipo, int horasSemanaisContratadas, double valorHora, String usuario,
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
		this.valorHora = valorHora;
		this.usuario = usuario;
		this.senha = senha;
	}
	
	// contrutor para funcionario comum
	public Pessoa(String nome, String naturalidade, int qntFilhos, Date dataNascimento, Date dataAdmissao,
			boolean sindicalizado, String funcao, String tipo, int horasSemanaisContratadas, double valorHora) {
		this.nome = nome;
		this.naturalidade = naturalidade;
		this.qntFilhos = qntFilhos;
		this.dataNascimento = dataNascimento;
		this.dataAdmissao = dataAdmissao;
		this.sindicalizado = sindicalizado;
		this.funcao = funcao;
		this.tipo = tipo;
		this.horasSemanaisContratadas = horasSemanaisContratadas;
		this.valorHora = valorHora;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public double getValorHora() {
		return valorHora;
	}


	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
	public static int[] columnsSize() {
		int[] array = {50, 200, 200, 100, 250, 250, 100, 200, 200, 100, 100, 200, 400};
		return array;
	}
	
	
		
}
