package dao;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenericDAO {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaEniatus");
	private static PessoaDAO pdao = new PessoaDAO();
	private static RequestResetSenhaDAO rdao = new RequestResetSenhaDAO();
	private static TabelaSalarioMinimoDAO tsmdao = new TabelaSalarioMinimoDAO();
	private static TabelaSalarioFamiliaDAO tsfdao = new TabelaSalarioFamiliaDAO();
	private static ValoresINSSDAO vinssdao = new ValoresINSSDAO();
	private static TabelaINSSDAO tinssdao = new TabelaINSSDAO();
	private static ValoresIRRFDAO virrfdao = new ValoresIRRFDAO();
	private static TabelaIRRFDAO tirrfdao = new TabelaIRRFDAO();
	private static MesDeReferenciaDAO mdrdao = new MesDeReferenciaDAO();
	private static LogDAO logdao = new LogDAO();
	private static FolhaDePagamentoDAO fpdao = new FolhaDePagamentoDAO();
	
	public static EntityManagerFactory getEmf() {
		return emf;
	}

	public static PessoaDAO getPdao() {
		return pdao;
	}

	public static RequestResetSenhaDAO getRdao() {
		return rdao;
	}

	public static TabelaSalarioMinimoDAO getTsmdao() {
		return tsmdao;
	}

	public static TabelaSalarioFamiliaDAO getTsfdao() {
		return tsfdao;
	}

	public static ValoresINSSDAO getVinssdao() {
		return vinssdao;
	}

	public static TabelaINSSDAO getTinssdao() {
		return tinssdao;
	}

	public static ValoresIRRFDAO getVirrfdao() {
		return virrfdao;
	}

	public static TabelaIRRFDAO getTirrfdao() {
		return tirrfdao;
	}

	public static MesDeReferenciaDAO getMdrdao() {
		return mdrdao;
	}

	public static LogDAO getLogdao() {
		return logdao;
	}

	public static FolhaDePagamentoDAO getFpdao() {
		return fpdao;
	}
	
	
	

	
}
