package com.padcmyanmar.tedtalk.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.tedtalk.R;

import com.padcmyanmar.tedtalk.data.vo.TalksVOs;
import com.padcmyanmar.tedtalk.viewholders.ViewHolderWatchNextDetails;

import java.util.ArrayList;
import java.util.List;

public class AdapterTedTalksDetails extends RecyclerView.Adapter<ViewHolderWatchNextDetails> {
    private List<TalksVOs> mtalksVOs;
    int mtedId;

    public AdapterTedTalksDetails() {
        mtalksVOs = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolderWatchNextDetails onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.activity_watch_next_details, parent, false);
        return new ViewHolderWatchNextDetails(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderWatchNextDetails holder, int position) {

        if(mtedId<8) {
            holder.setTedsWatchData(mtalksVOs.get(mtedId++));
        }
        else {
            holder.setTedsWatchData(mtalksVOs.get(position));
        }

    }


    @Override
    public int getItemCount() {
        return mtalksVOs.size()-9;
    }

    public void setMtalksVos(List<TalksVOs> mtalksVOs, String tedId) {
        this.mtalksVOs = mtalksVOs;
        mtedId = Integer.parseInt(tedId);
        notifyDataSetChanged();
    }
}
