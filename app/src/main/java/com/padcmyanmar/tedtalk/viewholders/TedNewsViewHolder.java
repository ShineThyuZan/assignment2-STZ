package com.padcmyanmar.tedtalk.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padcmyanmar.tedtalk.R;
import com.padcmyanmar.tedtalk.data.vo.TalksVOs;
import com.padcmyanmar.tedtalk.delegate.NewsDelegateTedTalk;

import butterknife.BindView;
import butterknife.ButterKnife;


public class TedNewsViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_top)
    TextView tvTop;
    @BindView(R.id.tv_bottom)
    TextView tvBottom;
    @BindView(R.id.iv_show)
    ImageView ivShow;
    @BindView(R.id.tv_time)
    TextView tvTime;
    private NewsDelegateTedTalk newsDelegateTedTalk;
    private TalksVOs mTalksVOs;

    public TedNewsViewHolder(View itemView, final NewsDelegateTedTalk newsDelegateTedTalk) {

        super(itemView);
        this.newsDelegateTedTalk = newsDelegateTedTalk;
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newsDelegateTedTalk.onTapView(mTalksVOs);
            }
        });
    }

    public static String secondToMinute(double duringInSecond) {
        String minute = String.valueOf((int) duringInSecond / 60);
        int second = (int)duringInSecond%60;
        String sec;
        if(second<10){
            sec = "0"+String.valueOf(second);
        }
        else {
            sec= String.valueOf(second);
        }
        return minute + ":" + sec;
    }

    public void setTedsNewsData(TalksVOs talksVOs) {
        mTalksVOs = talksVOs;
        tvTop.setText(mTalksVOs.getSpeakers().getName());
        tvBottom.setText(mTalksVOs.getTitle());
        Glide.with(ivShow.getContext())
                .load(mTalksVOs.getImgUrl())
                .into(ivShow);
        tvTime.setText(secondToMinute(mTalksVOs.getDuringInSec()));


    }
}
