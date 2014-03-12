package br.com.fti.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import br.com.fti.widget.FItemListView;
import br.com.fti.widget.FToast;
import br.com.ftigfin.R;

public class CadastreActivity extends BaseActivity {
	
	public static Integer CADASTRE_ACTIVITY = 1;
	
	public static String RETURN_SEARCH = "return_seach";
	
	public static String ID_RESULT = "id_codigo";
	
	protected TextView tvCodigo;
	
	protected TextView tvDescricao;
	
	protected EditText etCodigo;
	
	protected EditText etDescricao;
	
	protected ListView lvLista;
		
	@Override
	protected void onCreate(Bundle savedInstanceState, int id) {
		super.onCreate(savedInstanceState);
		setContentView(id);
		
		tvCodigo = (TextView) findViewById(R.id.tvCodigo);
		tvDescricao = (TextView) findViewById(R.id.tvDescricao);
		etCodigo = (EditText) findViewById(R.id.etCodigo);
		etDescricao = (EditText) findViewById(R.id.etDescricao);
		lvLista = (ListView) findViewById(R.id.listaConsulta);
		
		lvLista.setOnItemClickListener(onItemClickListener);
		
		onSearch();
	}
	
	protected OnItemClickListener onItemClickListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			
			if (!getIntent().getBooleanExtra(RETURN_SEARCH, false)) {
				refreshItem(position);
				
				onShow(true);	
			} else {
				setResult(RESULT_OK, new Intent().putExtra(ID_RESULT, 
						((FItemListView) lvLista.getItemAtPosition(position)).getIdCodigoItem()));
				
				finish();
			}
		}
	
	};
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main_activity_actions, menu);
	    return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
        case R.id.action_new: return onNew(this);
        case R.id.action_save: return onSave(this);
        case R.id.action_delete: return onDelete(this);
        case R.id.action_cancel: return onCancel(this);
        default: return super.onOptionsItemSelected(item);
        }
	}
	
	protected boolean onNew(Context context) {
		
		etCodigo.setText("");
		
		if (etDescricao != null)
			etDescricao.setText("");
		
		onShow(true);
        
		return true;
	}
	
	protected boolean onSave(Context context) {
		
		onSearch();
		
		FToast.onShowMessage(this, "Sucesso");
		
		return true;
	}
	
	protected boolean onDelete(Context context) {
		
		onSearch();
		
		FToast.onShowMessage(this, "Sucesso");
		
		return true;
	}
	
	protected boolean onCancel(Context context) {
		onShow(false);
		
		return true;
	}

	protected void onShow(boolean show) {
		
		tvCodigo.setVisibility((show ? 0 : TRIM_MEMORY_BACKGROUND));
    	etCodigo.setVisibility((show ? 0 : TRIM_MEMORY_BACKGROUND));
    	
    	if (tvDescricao != null)
    		tvDescricao.setVisibility((show ? 0 : TRIM_MEMORY_BACKGROUND));
    	if (etDescricao != null)
    		etDescricao.setVisibility((show ? 0 : TRIM_MEMORY_BACKGROUND));
    	
    	if ((!show) && (etDescricao != null)){
			InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
	    	mgr.hideSoftInputFromWindow(etDescricao.getWindowToken(), 0);
		}
    	
    }

	protected void onSearch() {
		onShow((lvLista.getCount() <= 0));
	}
	
	protected void refreshItem(Integer position) {
		etCodigo.setText(((FItemListView) lvLista.getItemAtPosition(position)).getIdCodigoItem().toString());
		etDescricao.setText(((FItemListView) lvLista.getItemAtPosition(position)).getNmCodigoItem());
	}

}
