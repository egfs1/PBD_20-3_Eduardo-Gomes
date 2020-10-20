package folhadepagamento;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import dao.GenericDAO;
import model.FormatarVigencia;
import model.Pessoa;

public class GerarFolhaDePagamento {
	
	public static void gerar(FolhaDePagamento folha) {
		try {
			
			// TOTAL PROVENTOS = SALARIO BRUTO
			// TOTAL = SALARIO LIQUIDO
			
			 PDDocument pDDocument = PDDocument.load(new File("template/TemplateFolhaPagamento.pdf"));
	            PDAcroForm pDAcroForm = pDDocument.getDocumentCatalog().getAcroForm();
	            
	            PDField vigencia = pDAcroForm.getField("Vigencia");
	            PDField funcionarioCodigo = pDAcroForm.getField("FuncionarioCodigo");
	            PDField funcionarioNome = pDAcroForm.getField("FuncionarioNome");
	            PDField funcionarioFuncao = pDAcroForm.getField("FuncionarioFuncao");
	            PDField salarioBaseDesc = pDAcroForm.getField("SalarioBaseDesc");
	            PDField adicionalTempoDesc = pDAcroForm.getField("AdicionalTempoDesc");
	            PDField horaExtraDesc = pDAcroForm.getField("HoraExtraDesc");
	            PDField auxilioAlimentacaoDesc = pDAcroForm.getField("AuxilioAlimentacaoDesc");
	            PDField salarioFamiliaDesc = pDAcroForm.getField("SalarioFamiliaDesc");
	            PDField acrescimoValorDesc = pDAcroForm.getField("AcrescimoValorDesc");
	            PDField inssDesc = pDAcroForm.getField("InssDesc");
	            PDField contribuicaoSindicalDesc = pDAcroForm.getField("ContribuicaoSindicalDesc");
	            PDField irrfDesc = pDAcroForm.getField("IrrfDesc");
	            PDField faltasDesc = pDAcroForm.getField("FaltasDesc");
	            PDField descontoValorDesc = pDAcroForm.getField("DescontoValorDesc");
	            PDField salarioBaseValor = pDAcroForm.getField("SalarioBaseValor");
	            PDField adicionalTempoValor = pDAcroForm.getField("AdicionalTempoValor");
	            PDField horaExtraValor = pDAcroForm.getField("HoraExtraValor");
	            PDField auxilioAlimentacaoValor = pDAcroForm.getField("AuxilioAlimentacaoValor");
	            PDField salarioFamiliaValor = pDAcroForm.getField("SalarioFamiliaValor");
	            PDField acrescimoValorValor = pDAcroForm.getField("AcrescimoValorValor");
	            PDField inssValor = pDAcroForm.getField("InssValor");
	            PDField contribuicaoSindicalValor = pDAcroForm.getField("ContribuicaoSindicalValor");
	            PDField irrfValor = pDAcroForm.getField("IrrfValor");
	            PDField faltasValor = pDAcroForm.getField("FaltasValor");
	            PDField descontoValorValor = pDAcroForm.getField("DescontoValorValor");
	            PDField acrescimoDesc = pDAcroForm.getField("AcrescimoDesc");
	            PDField descontoDesc = pDAcroForm.getField("DescontoDesc");
	            PDField totalProventos = pDAcroForm.getField("TotalProventos");
	            PDField totalDescontos = pDAcroForm.getField("TotalDescontos");
	            PDField total = pDAcroForm.getField("Total");
	            
	            double ttlProventos = folha.getSalarioBase() + folha.getAdicionalTempoServico() + folha.getHoraExtra() + folha.getAuxilioAlimentacao() + folha.getAcrescimoValor();
	            double ttlDescontos = folha.getInss() + folha.getContribuicaoSindical() + folha.getFaltas() + folha.getIrrf() + folha.getDescontoValor();
	            double ttl = ttlProventos - ttlDescontos + folha.getSalarioFamilia();
	            Pessoa funcionario = GenericDAO.getPdao().findID(folha.getUser_id(), GenericDAO.getEmf());
	            
	            String fileDate;
	            fileDate = FormatarVigencia.dateToFormat(folha.getVigencia()).replace("/", "-");
	            
	            String fileName;
	            fileName = funcionario.getNome().replace(" ", "-");
	            
	            vigencia.setValue(FormatarVigencia.dateToFormat(folha.getVigencia()));
	            funcionarioCodigo.setValue(funcionario.getId() + "");
	            funcionarioNome.setValue(funcionario.getNome());
	            funcionarioFuncao.setValue(funcionario.getFuncao());
	            salarioBaseDesc.setValue("Salário Base");
	            adicionalTempoDesc.setValue("Adicional por Tempo de Serviço");
	            horaExtraDesc.setValue("Hora Extra");
	            auxilioAlimentacaoDesc.setValue("Auxilio Alimentação");
	            salarioFamiliaDesc.setValue("Salário Família");
	            acrescimoValorDesc.setValue("Outros Acréscimos");
	            inssDesc.setValue("INSS");
	            contribuicaoSindicalDesc.setValue("Contribuição Sindical");
	            irrfDesc.setValue("IRRF");
	            faltasDesc.setValue("Faltas");
	            descontoValorDesc.setValue("Outros Descontos");
	            salarioBaseValor.setValue(folha.getSalarioBase() + "");
	            adicionalTempoValor.setValue(folha.getAdicionalTempoServico() + "");
	            horaExtraValor.setValue(folha.getHoraExtra() + "");
	            auxilioAlimentacaoValor.setValue(folha.getAuxilioAlimentacao() + "");
	            salarioFamiliaValor.setValue(folha.getSalarioFamilia() + "");
	            acrescimoValorValor.setValue(folha.getAcrescimoValor() + "");
	            inssValor.setValue(folha.getInss() + "");
	            contribuicaoSindicalValor.setValue(folha.getContribuicaoSindical() + "");
	            irrfValor.setValue(folha.getIrrf() + "");
	            faltasValor.setValue(folha.getFaltas() + "");
	            descontoValorValor.setValue(folha.getDescontoValor() + "");
	            acrescimoDesc.setValue(folha.getAcrescimoDescricao());
	            descontoDesc.setValue(folha.getDescontoDescricao());
	            totalProventos.setValue(ttlProventos + "");
	            totalDescontos.setValue(ttlDescontos + "");
	            total.setValue(ttl + "");
	            
	            pDDocument.save("pdf/FolhaPagamento_" + fileDate + "_" + fileName + ".pdf");
	            pDDocument.close();
			
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		
	}
	
}
