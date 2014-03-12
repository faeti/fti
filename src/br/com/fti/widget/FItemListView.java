package br.com.fti.widget;

public class FItemListView {
	
	private Integer idCodigoItem;
	private String nmCodigoItem;
	
	public FItemListView() {
		this(0, "");
	}
	
	public FItemListView(Integer idCodigo, String nmCodigo) {
		this.setIdCodigoItem(idCodigo);
		this.setNmCodigoItem(nmCodigo);
	}

	public Integer getIdCodigoItem() {
		return idCodigoItem;
	}

	public void setIdCodigoItem(Integer idCodigoItem) {
		this.idCodigoItem = idCodigoItem;
	}

	public String getNmCodigoItem() {
		return nmCodigoItem;
	}

	public void setNmCodigoItem(String nmCodigoItem) {
		this.nmCodigoItem = nmCodigoItem;
	}
}
