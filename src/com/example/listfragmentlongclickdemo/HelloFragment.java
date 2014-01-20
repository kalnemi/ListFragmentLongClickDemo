package com.example.listfragmentlongclickdemo;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class HelloFragment extends ListFragment
{
	String [] country = new String[] { 
			"India",
			"Japan",
			"Pakistan"
	};
	
	@Override
	public View onCreateView ( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState )
	{
		ArrayAdapter<String> adapter = new ArrayAdapter<String> ( inflater.getContext(), android.R.layout.simple_list_item_1, country );
		setListAdapter(adapter);
		return super.onCreateView(inflater, container, savedInstanceState);
	}
	
	@Override
	public void onActivityCreated ( Bundle savedInstanceState )
	{
		super.onActivityCreated(savedInstanceState);
		
		OnItemLongClickListener listener = new OnItemLongClickListener() 
		{
			@Override
			public boolean onItemLongClick ( AdapterView<?> arg0, View arg1, int position, long id )
			{
				Toast.makeText(getActivity().getBaseContext(), country[position], Toast.LENGTH_SHORT ).show();
				return false;
			}
		};
		
		getListView().setOnItemLongClickListener(listener);
	}
}