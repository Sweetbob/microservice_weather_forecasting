package com.echo.helloworld.vo;

import java.io.Serializable;
import java.util.List;

public class Weather implements Serializable {

    private Yesterday yesterday;
    private List<Forecast> forecast;
    private String city;
    private String aqi;
    private String ganmao;
    private String wendu;

    public Yesterday getYesterday() {
        return yesterday;
    }

    public void setYesterday(Yesterday yesterday) {
        this.yesterday = yesterday;
    }

    public void setForecast(List<Forecast> forecast) {
        this.forecast = forecast;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAqi(String aqi) {
        this.aqi = aqi;
    }

    public void setGanmao(String ganmao) {
        this.ganmao = ganmao;
    }

    public void setWendu(String wendu) {
        this.wendu = wendu;
    }

    public List<Forecast> getForecast() {
        return forecast;

    }

    public String getCity() {
        return city;
    }

    public String getAqi() {
        return aqi;
    }

    public String getGanmao() {
        return ganmao;
    }

    public String getWendu() {
        return wendu;
    }



}
