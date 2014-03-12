package br.com.fti.enumerator;

public enum FEnumDate {
	DATETIME("dd/MM/yyyy HH:mm:ss"), DATE("dd/MM/yyyy"), TIME("HH:mm:ss"),
	SQLDATETIME("yyyy-MM-dd HH:mm:ss"), SQLDATE("yyyy-MM-dd"), SQLTIME("HH:mm:ss");

	public String format;

	FEnumDate(String format) {
		this.format = format;
	}
	
	public String getFormat() {
		return this.format;
	}

}
