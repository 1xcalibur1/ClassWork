package com.example.themoviekeeper.ui;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.themoviekeeper.R;
import com.example.themoviekeeper.db.MyMovieCategory;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static android.support.v7.recyclerview.R.styleable.RecyclerView;

/**
 * Created by Xcalibur on 01/01/2017.
 */

public class RecyclerViewAdapter_Edit extends RecyclerView.Adapter<RecyclerViewAdapter_Edit.MyViewHolder> {

    private Activity activity;
    private ArrayList<MyMovieCategory> myMovieCategoryArrayList;
    private LayoutInflater inflater;

    public RecyclerViewAdapter_Edit(Activity activity, ArrayList<MyMovieCategory> myMovieCategoryArrayList) {

        this.activity = activity;
        this.myMovieCategoryArrayList = myMovieCategoryArrayList;

        inflater = LayoutInflater.from(activity);

    }

    @Override

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = inflater.inflate(R.layout.view_edit, parent, false);

        RecyclerViewAdapter_Edit.MyViewHolder holder = new RecyclerViewAdapter_Edit.MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        String description_name = myMovieCategoryArrayList.get(position).getCategory_name();
        String description_content = myMovieCategoryArrayList.get(position).getCategory_description();

        holder.tv_view_edit_description_name.setText(description_name);
        holder.et_view_edit_description.setText(description_content);
    }



    @Override
    public int getItemCount() {
        return myMovieCategoryArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private  TextView tv_view_edit_description_name;
        private  EditText et_view_edit_description;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_view_edit_description_name = (TextView)itemView.findViewById(R.id.tv_category_name_edit);
            et_view_edit_description = (EditText)itemView.findViewById(R.id.et_category_desc_edit);
        }
    }

    public MyMovieCategory getItem(int position){
        return myMovieCategoryArrayList.get(position);
    }
}
