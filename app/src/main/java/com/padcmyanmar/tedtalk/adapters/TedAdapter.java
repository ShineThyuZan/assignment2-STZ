package com.padcmyanmar.tedtalk.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.tedtalk.R;
import com.padcmyanmar.tedtalk.data.vo.TalksVOs;
import com.padcmyanmar.tedtalk.delegate.NewsDelegateTedTalk;
import com.padcmyanmar.tedtalk.viewholders.TedNewsViewHolder;

import java.util.ArrayList;
import java.util.List;


public class TedAdapter extends RecyclerView.Adapter<TedNewsViewHolder> {
    private NewsDelegateTedTalk newsDelegateTedTalk;
    private List<TalksVOs> mtalksVOs;

    public TedAdapter(NewsDelegateTedTalk newsDelegateTedTalk) {
        this.newsDelegateTedTalk = newsDelegateTedTalk;
        mtalksVOs = new ArrayList<>();
    }

    @NonNull
    @Override
    public TedNewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());//layout inflater obj
        View view = layoutInflater.inflate(R.layout.activity_list, parent, false);

        return new TedNewsViewHolder(view, newsDelegateTedTalk);
    }

    @Override
    public void onBindViewHolder(@NonNull TedNewsViewHolder holder, int position) {
        holder.setTedsNewsData(mtalksVOs.get(position));
    }


    @Override
    public int getItemCount() {
        return mtalksVOs.size();
    }


    public void setTedNewsList(List<TalksVOs> talksVOs){
        mtalksVOs = talksVOs;
        notifyDataSetChanged();

    }
}
