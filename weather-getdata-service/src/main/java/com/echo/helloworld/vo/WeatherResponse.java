package com.echo.helloworld.vo;

import java.io.Serializable;

public class WeatherResponse implements Serializable {

    private Weather data;
    private Integer status;
    private String desc;

    public void setData(Weather weather) {
        this.data = weather;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Weather getData() {
        return data;
    }

    public Integer getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }
}
