package br.com.fti.framework;

public interface BusinessRule {

	public boolean verificaCamposObrigatorios(BusinessValue value);
	
	public boolean validaRegraNegocio(BusinessValue value);
	
}
