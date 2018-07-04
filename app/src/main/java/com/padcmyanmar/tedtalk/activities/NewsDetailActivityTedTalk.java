package com.padcmyanmar.tedtalk.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padcmyanmar.tedtalk.R;
import com.padcmyanmar.tedtalk.adapters.AdapterTedTalksDetails;
import com.padcmyanmar.tedtalk.data.model.TedTalksModel;
import com.padcmyanmar.tedtalk.data.vo.TalksVOs;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;


public class NewsDetailActivityTedTalk extends BaseActivity {
    @BindView(R.id.iv_details_top_image)
    ImageView ivDetailsImg;
    @BindView(R.id.tv_speaker_name)
    TextView tvSpeakerName;
    @BindView(R.id.tv_details_title)
    TextView tvDetailTitle;
    @BindView(R.id.tv_description)
    TextView tvDescription;
    @BindView(R.id.tv_top_name)
    TextView tvTopName;
    @BindView(R.id.cimv_messi)
    CircleImageView circleImageView;
    AdapterTedTalksDetails adapterTedTalksDetails;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail_ted_talk);
        ButterKnife.bind(this, this);

        RecyclerView recyclerView = findViewById(R.id.rv_detail);
        adapterTedTalksDetails = new AdapterTedTalksDetails();

        recyclerView.setAdapter(adapterTedTalksDetails);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));


        String talksId = getIntent().getStringExtra("talk_id");
        TalksVOs talksVOs = TedTalksModel.getObj().getTedTalksById(talksId);
        adapterTedTalksDetails.setMtalksVos(TedTalksModel.getObj().getmTalkVoList(),talksId);
        bind(talksVOs);


    }

    public void bind(TalksVOs talksVOs) {
        Glide.with(ivDetailsImg.getContext())
                .load(talksVOs.getImgUrl())
                .into(ivDetailsImg);
        tvSpeakerName.setText(talksVOs.getSpeakers().getName());
        tvDetailTitle.setText(talksVOs.getTitle());
        tvDescription.setText(talksVOs.getDescription());
        tvTopName.setText(talksVOs.getSpeakers().getName());
        Glide.with(circleImageView.getContext())
                .load(talksVOs.getImgUrl())
                .into(circleImageView);

    }

}
