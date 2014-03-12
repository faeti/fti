package br.com.fti.framework;

import java.util.List;

import android.content.Context;

public interface BusinessDatabase {

	public boolean insert(Context context, BusinessValue value);
	
	public boolean update(Context context, BusinessValue value);
	
	public boolean delete(Context context, BusinessValue value);
	
	public boolean getFull(BusinessValue value);
	
	public boolean getLite(Context context, BusinessValue value);
	
	public boolean search(Context context, List<BusinessValue> listValue);
}
