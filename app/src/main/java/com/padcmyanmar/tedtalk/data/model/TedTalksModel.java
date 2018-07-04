package com.padcmyanmar.tedtalk.data.model;

import com.padcmyanmar.tedtalk.data.vo.TalksVOs;
import com.padcmyanmar.tedtalk.events.SuccessGetTedTedEvent;
import com.padcmyanmar.tedtalk.network.RetorfitDataAgentImpl;
import com.padcmyanmar.tedtalk.network.TedTalksNewsDataAgent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TedTalksModel {
    private static TedTalksModel obj;
    private List<TalksVOs> mTalkVoList;
    private Map<String, TalksVOs> mTedsMap;

    private TedTalksNewsDataAgent tedTalksNewsDataAgent;
    private static final String DUMMY_ACCESS_TOKEN = "b002c7e1a528b7cb460933fc2875e916";

    private TedTalksModel() {
        //tedTalksNewsDataAgent = HttpUrlConnectionTedTalksNewsDataAgentImpl.getObjInstance();
        tedTalksNewsDataAgent = RetorfitDataAgentImpl.getObjectInstance();
        mTedsMap = new HashMap<>();
        EventBus.getDefault().register(this);
    }

    public static TedTalksModel getObj() {
        if (obj == null) {
            obj = new TedTalksModel();
        }
        return obj;


    }

    public TalksVOs getTedTalksById(String tedId) {
        return mTedsMap.get(tedId);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onSuccessGetTedtalks(SuccessGetTedTedEvent event) {
        for (TalksVOs talksVOs : event.getTalksVOs()) {
            mTedsMap.put(talksVOs.getTedId(), talksVOs);
        }
        mTalkVoList = event.getTalksVOs();
    }

    public void loadTedNewsList() {
        tedTalksNewsDataAgent.loadTedNewsList(1, DUMMY_ACCESS_TOKEN);
    }

    public Map<String, TalksVOs> getmTedsMap() {
        return mTedsMap;
    }

    public List<TalksVOs> getmTalkVoList() {
        return mTalkVoList;
    }
}
