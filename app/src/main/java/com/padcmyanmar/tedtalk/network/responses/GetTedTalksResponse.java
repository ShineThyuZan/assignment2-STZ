package com.padcmyanmar.tedtalk.network.responses;

import com.google.gson.annotations.SerializedName;
import com.padcmyanmar.tedtalk.data.vo.TalksVOs;

import java.util.List;

public class GetTedTalksResponse {


    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("page")
    private String page;

    @SerializedName("ted_talks")
    private List<TalksVOs> talksVOs;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getPage() {
        return page;
    }

    public List<TalksVOs> getTalksVOs() {
        return talksVOs;
    }

    public boolean isResponseOk() {
        return (code == 200 && talksVOs != null);
    }
}
