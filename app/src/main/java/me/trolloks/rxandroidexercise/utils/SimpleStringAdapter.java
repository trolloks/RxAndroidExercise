package me.trolloks.rxandroidexercise.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import me.trolloks.rxandroidexercise.R;

/**
 * Created by rikus on 2017/06/15.
 */

public class SimpleStringAdapter extends RecyclerView.Adapter<SimpleStringAdapter.ViewHolder> {

    private final Context mContext;
    private final List<String> mStrings = new ArrayList<>();

    public SimpleStringAdapter(Context context){
        mContext = context;
    }

    public void setStrings(List<String> newStrings) {
        mStrings.clear();
        mStrings.addAll(newStrings);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.string_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mColorDisplay.setText(mStrings.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, mStrings.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mStrings.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView mColorDisplay;

        public ViewHolder(View view) {
            super(view);
            mColorDisplay = (TextView) view.findViewById(R.id.color_display);
        }
    }
}
