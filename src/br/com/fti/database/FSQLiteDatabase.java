package br.com.fti.database;

import br.com.fti.database.FSQLiteOpenHelper;
import br.com.fti.widget.FToast;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

public class FSQLiteDatabase {
	
	public static long insert(SQLiteDatabase db, String tableName, ContentValues values) {
		long result = -1;
		try {
			result = db.insert(tableName, null, values);
		}
		catch (SQLiteException e){
			
		}
				
		return result;
	}
	
	public static long insert(Context context, String tableName, ContentValues values) {
		FSQLiteOpenHelper sqlHelper = new FSQLiteOpenHelper(context);
		
		SQLiteDatabase database = sqlHelper.getWritableDatabase();

		return insert(database, tableName, values);
	}
	
	public static long delete(SQLiteDatabase db, String tableName, Integer id){
		long result = -1;
		
		try {
			result = db.delete(tableName, "id_"+ tableName +" = ?", 
					new String[]{ String.valueOf(id) });
		}
		catch (SQLiteException e){
			
		}
				
		return result;
	}
	
	public static long delete(Context context, String tableName, Integer id){
		FSQLiteOpenHelper sqlHelper = new FSQLiteOpenHelper(context);
		
		SQLiteDatabase database = sqlHelper.getWritableDatabase();
		
		return delete(database, tableName, id);
	}
	
	public static long update(SQLiteDatabase db, String tableName, ContentValues values, Integer id) {
		long result = -1;
		
		try {
			result = db.update(tableName, values, "id_"+ tableName +" = ?", 
					new String[]{ String.valueOf(id) });
		}
		catch (SQLiteException e) {
			
		}
		return result;
	}
	
	public static long update(Context context, String tableName, ContentValues values, Integer id){
		FSQLiteOpenHelper sqlHelper = new FSQLiteOpenHelper(context);
		
		SQLiteDatabase database = sqlHelper.getWritableDatabase();
		
		return update(database, tableName, values, id);
	}
	
	public static Cursor search(Context context, String tableName, String[] columns){
		try {
			FSQLiteOpenHelper sqlHelper = new FSQLiteOpenHelper(context);
			
			SQLiteDatabase database = sqlHelper.getReadableDatabase();
			
			Cursor cursor = database.query(
					tableName, // a. table
					columns, // b. column names
	             	null, // c. selections 
	             	null, // d. selections args
		            null, // e. group by
		            null, // f. having
		            null, // g. order by
		            null); // h. limit
	
			return cursor;
		}
		catch (SQLException e) {
			FToast.onShowMessage(context, e.getMessage());
			
			return null;
		}
	}
	
	public static Cursor search(Context context, FSQLiteQuery query){
		try {
			FSQLiteOpenHelper sqlHelper = new FSQLiteOpenHelper(context);
			
			SQLiteDatabase database = sqlHelper.getReadableDatabase();
			
			Cursor cursor = database.query(
					query.tableName, // a. table
					query.fields, // b. column names
	             	query.selections, // c. selections 
	             	query.arguments, // d. selections args
		            query.group, // e. group by
		            query.having, // f. having
		            query.order, // g. order by
		            query.limit); // h. limit
	
			return cursor;
		}
		catch (SQLException e) {
			FToast.onShowMessage(context, e.getMessage());
			
			return null;
		}
	}
	
	public static Cursor getLite(Context context, String tableName, String[] columns, Integer id){
		try {
			FSQLiteOpenHelper sqlHelper = new FSQLiteOpenHelper(context);
			
			SQLiteDatabase database = sqlHelper.getReadableDatabase();
			
			Cursor cursor = database.query(
					tableName, // a. table
					columns, // b. column names
	             	"id_"+ tableName  +" = ?", // c. selections 
	             	new String[] { id.toString() }, // d. selections args
		            null, // e. group by
		            null, // f. having
		            null, // g. order by
		            null); // h. limit
	
			return cursor;
		}
		catch (SQLiteException e) {
			return null;
		}
	}
	
}
	