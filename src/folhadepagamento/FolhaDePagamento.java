package folhadepagamento;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(name="FolhaDePagamento.findAll", 
			query="SELECT f FROM FolhaDePagamento f ORDER BY f.vigencia DESC"),
	
	@NamedQuery(name="FolhaDePagamento.findByUserIdAndVigencia", 
	query="SELECT f FROM FolhaDePagamento f WHERE f.user_id = :user_id AND f.vigencia = :vigencia"),
})

@Entity
@Table(name="folhadepagamento")
public class FolhaDePagamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Date vigencia;
	
	private Long user_id;
	
	//
	
	private double salarioBase;
	
	private double adicionalTempoServico;
	
	private double horaExtra;
	
	private double auxilioAlimentacao;
	
	private double salarioFamilia;
	
	private double acrescimoValor;
	
	private String acrescimoDescricao;
	
	//
	
	private double inss;
	
	private double contribuicaoSindical;
	
	private double irrf;
	
	private double faltas;
	
	private double descontoValor;
	
	private String descontoDescricao;
	
	//
	
	private double salarioLiquido;


	public FolhaDePagamento(Date vigencia, Long user_id, double salarioBase, double adicionalTempoServico,
			double horaExtra, double auxilioAlimentacao, double salarioFamilia, double acrescimoValor,
			String acrescimoDescricao, double inss, double contribuicaoSindical, double irrf, double faltas,
			double descontoValor, String descontoDescricao, double salarioLiquido) {
		this.vigencia = vigencia;
		this.user_id = user_id;
		this.salarioBase = salarioBase;
		this.adicionalTempoServico = adicionalTempoServico;
		this.horaExtra = horaExtra;
		this.auxilioAlimentacao = auxilioAlimentacao;
		this.salarioFamilia = salarioFamilia;
		this.acrescimoValor = acrescimoValor;
		this.acrescimoDescricao = acrescimoDescricao;
		this.inss = inss;
		this.contribuicaoSindical = contribuicaoSindical;
		this.irrf = irrf;
		this.faltas = faltas;
		this.descontoValor = descontoValor;
		this.descontoDescricao = descontoDescricao;
		this.salarioLiquido = salarioLiquido;
	}
	
	public FolhaDePagamento() {}

	public double getSalarioLiquido() {
		return salarioLiquido;
	}

	public void setSalarioLiquido(double salarioLiquido) {
		this.salarioLiquido = salarioLiquido;
	}

	public Long getId() {
		return id;
	}

	public Date getVigencia() {
		return vigencia;
	}

	public Long getUser_id() {
		return user_id;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public double getAdicionalTempoServico() {
		return adicionalTempoServico;
	}

	public double getHoraExtra() {
		return horaExtra;
	}

	public double getAuxilioAlimentacao() {
		return auxilioAlimentacao;
	}

	public double getSalarioFamilia() {
		return salarioFamilia;
	}

	public double getAcrescimoValor() {
		return acrescimoValor;
	}

	public void setAcrescimoValor(double acrescimoValor) {
		this.acrescimoValor = acrescimoValor;
	}

	public String getAcrescimoDescricao() {
		return acrescimoDescricao;
	}

	public void setAcrescimoDescricao(String acrescimoDescricao) {
		this.acrescimoDescricao = acrescimoDescricao;
	}

	public double getDescontoValor() {
		return descontoValor;
	}

	public void setDescontoValor(double descontoValor) {
		this.descontoValor = descontoValor;
	}

	public String getDescontoDescricao() {
		return descontoDescricao;
	}

	public void setDescontoDescricao(String descontoDescricao) {
		this.descontoDescricao = descontoDescricao;
	}

	public double getInss() {
		return inss;
	}

	public double getContribuicaoSindical() {
		return contribuicaoSindical;
	}

	public double getIrrf() {
		return irrf;
	}

	public double getFaltas() {
		return faltas;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public void setVigencia(Date vigencia) {
		this.vigencia = vigencia;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public void setAdicionalTempoServico(double adicionalTempoServico) {
		this.adicionalTempoServico = adicionalTempoServico;
	}

	public void setHoraExtra(double horaExtra) {
		this.horaExtra = horaExtra;
	}

	public void setAuxilioAlimentacao(double auxilioAlimentacao) {
		this.auxilioAlimentacao = auxilioAlimentacao;
	}

	public void setSalarioFamilia(double salarioFamilia) {
		this.salarioFamilia = salarioFamilia;
	}

	public void setInss(double inss) {
		this.inss = inss;
	}

	public void setContribuicaoSindical(double contribuicaoSindical) {
		this.contribuicaoSindical = contribuicaoSindical;
	}

	public void setIrrf(double irrf) {
		this.irrf = irrf;
	}

	public void setFaltas(double faltas) {
		this.faltas = faltas;
	}
	
	
	
}
