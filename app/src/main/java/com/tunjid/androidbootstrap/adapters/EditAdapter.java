package com.tunjid.androidbootstrap.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.tunjid.androidbootstrap.R;
import com.tunjid.androidbootstrap.core.abstractclasses.BaseRecyclerViewAdapter;
import com.tunjid.androidbootstrap.core.abstractclasses.BaseViewHolder;

import java.util.List;

public class EditAdapter extends BaseRecyclerViewAdapter<EditAdapter.ViewHolder, BaseRecyclerViewAdapter.AdapterListener> {

    private List<String> list;

    public EditAdapter(List<String> list) {
        setHasStableIds(true);
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        View itemView = LayoutInflater.from(context).
                inflate(R.layout.viewholder_edit, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int recyclerViewPosition) {
        holder.bind(list.get(recyclerViewPosition));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public long getItemId(int position) {
        return list.get(position).hashCode();
    }

    static class ViewHolder extends BaseViewHolder {

        EditText editText;

        ViewHolder(View itemView) {
            super(itemView);
            editText = (EditText) itemView;
        }

        void bind(String text) {
            editText.setText(text);
        }
    }
}
