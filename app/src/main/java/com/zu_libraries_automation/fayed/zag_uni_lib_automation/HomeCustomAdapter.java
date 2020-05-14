package com.zu_libraries_automation.fayed.zag_uni_lib_automation;

/**
 * Created by Gemy on 3/6/2017.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Gemy on 3/6/2017.
 */

public class HomeCustomAdapter extends BaseAdapter {

    Context context ;
    ArrayList<Faculties> faculties ;

    public HomeCustomAdapter(Context context, ArrayList<Faculties> faculties) {
        this.context = context;
        this.faculties = faculties;
    }

    public interface ClickListener {
        public void itemClicked(View view ,int position);
    }

    ClickListener clickListener =null;

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public int getCount() {
        return faculties.size();
    }

    @Override
    public Object getItem(int i) {
        return faculties.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.my_card_view_model,viewGroup,false);
        }
        final Holder holder = new Holder();

        holder.faculty_name = (TextView) view.findViewById(R.id.home_faculty_title);
        holder.faculty_icon = (ImageView) view.findViewById(R.id.home_faculty_img);

        holder.faculty_name.setText(faculties.get(position).getFacultyName());
        holder.faculty_icon.setImageResource(faculties.get(position).getFacultyIcon());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,faculties.get(position).getFacultyName(), Toast.LENGTH_SHORT).show();

                if(clickListener!=null){
                    clickListener.itemClicked(view,position);
                }
            }
        });

        return view;
    }

    private class Holder{
        TextView faculty_name ;
        ImageView faculty_icon;
    }
}
