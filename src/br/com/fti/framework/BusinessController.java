package br.com.fti.framework;

import java.util.List;

import android.content.Context;

public interface BusinessController {
	
	public boolean save(Context context, BusinessValue value);
	
	public boolean delete(Context context, BusinessValue value);
	
	public boolean getFull(Context context, BusinessValue value);
	
	public boolean getLite(Context context, BusinessValue value);
	
	public boolean search(Context context, List<BusinessValue> listValue);
	
	public boolean checkBusinessRule(BusinessValue value);
	
	
}
