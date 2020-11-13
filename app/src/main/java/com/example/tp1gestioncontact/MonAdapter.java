package com.example.tp1gestioncontact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MonAdapter extends BaseAdapter {
    ArrayList<Contact> contacts;
    Context context;

    public MonAdapter(Context context, ArrayList<Contact> contacts) {
        this.context=context;
        this.contacts=contacts;

    }

    @Override
    public int getCount() {
        // nombre de views
        return contacts.size();
    }

    @Override
    public Contact getItem(int position) {
        return contacts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater ly=LayoutInflater.from(context);
        LinearLayout l= (LinearLayout) ly.inflate(R.layout.view_contact,null);
        TextView tvNom=l.findViewById(R.id.tvnom_viewcontact);
        TextView tvPrenom=l.findViewById(R.id.tvprenom_viewcontact);
        TextView tvNum=l.findViewById(R.id.tvnum_viewcontact);

        Contact contact=getItem(position);

        tvNom.setText(contact.getNom());
        tvPrenom.setText(contact.getPrenom());
        tvNum.setText(contact.getNumero());
        return l;
    }
}
