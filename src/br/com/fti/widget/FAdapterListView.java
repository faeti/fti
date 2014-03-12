package br.com.fti.widget;

import java.util.List;

import br.com.ftigfin.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class FAdapterListView extends BaseAdapter {

	private LayoutInflater mInflater;
    private List<FItemListView> itens;

    public FAdapterListView(Context context, List<FItemListView> itens) { 
    	this.itens = itens; 
    	mInflater = LayoutInflater.from(context); 
    }

    @Override
	public int getCount() {
		return this.itens.size();
	}

	@Override
	public Object getItem(int position) {
		return this.itens.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		FItemSuporte itemHolder; 

		if (view == null) { 
			view = mInflater.inflate(R.layout.item_list_view, null); 
			itemHolder = new FItemSuporte(); 
			itemHolder.idCodigo = ((TextView) view.findViewById(R.id.idCodigoItem)); 
			itemHolder.nmDescricao = ((TextView) view.findViewById(R.id.idDescricaoItem)); 
			view.setTag(itemHolder); 
		} 
		else { 
			itemHolder = (FItemSuporte) view.getTag(); 
		} 
		
		FItemListView item = itens.get(position); 
		itemHolder.idCodigo.setText(item.getIdCodigoItem().toString()); 
		itemHolder.nmDescricao.setText(item.getNmCodigoItem()); 
		
		return view;
	}

}