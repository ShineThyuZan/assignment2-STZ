package com.padcmyanmar.tedtalk.events;

import com.padcmyanmar.tedtalk.data.vo.TalksVOs;

import java.util.List;

public class SuccessGetTedTedEvent {
   private List<TalksVOs> talksVOs;

    public SuccessGetTedTedEvent(List<TalksVOs> talksVOs) {
        this.talksVOs = talksVOs;
    }

    public List<TalksVOs> getTalksVOs() {
        return talksVOs;
    }
}
