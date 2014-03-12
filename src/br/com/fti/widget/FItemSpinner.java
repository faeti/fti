package br.com.fti.widget;

public class FItemSpinner {
	
	private Integer idItem;
	private String nmDescricao;
	private String csFlag;
	
	public FItemSpinner() {
		this(0, "", "");
	}
	
	public FItemSpinner(Integer idCodigo, String csCodigo, String nmCodigo) {
		this.setIdItem(idCodigo);
		this.setCsFlag(csCodigo);
		this.setNmDescricao(nmCodigo);
	}

	public FItemSpinner(Integer idCodigo, String nmCodigo) {
		this(idCodigo, "", nmCodigo);
	}
	
	public FItemSpinner(String csCodigo, String nmCodigo) {
		this(0, csCodigo, nmCodigo);
	}
	
	public String getCsFlag() {
		return csFlag;
	}

	public void setCsFlag(String csFlag) {
		this.csFlag = csFlag;
	}

	public Integer getIdItem() {
		return idItem;
	}

	public void setIdItem(Integer idItem) {
		this.idItem = idItem;
	}

	public String getNmDescricao() {
		return nmDescricao;
	}

	public void setNmDescricao(String nmDescricao) {
		this.nmDescricao = nmDescricao;
	}
}
