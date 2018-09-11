package com.echo.helloworld.vo;

import java.io.Serializable;

public class Forecast implements Serializable {

    private String date;
    private String high;
    private String fengli;
    private String low;
    private String fengxiang;
    private String type;

    public String getDate() {
        return date;
    }

    public String getHigh() {
        return high;
    }

    public String getFengli() {
        return fengli;
    }

    public String getLow() {
        return low;
    }

    public String getFengxiang() {
        return fengxiang;
    }

    public String getType() {
        return type;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public void setFengli(String fengli) {
        this.fengli = fengli;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public void setFengxiang(String fengxiang) {
        this.fengxiang = fengxiang;
    }

    public void setType(String type) {
        this.type = type;
    }
}
