package com.echo.weather_eureka_client.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "county")
@XmlAccessorType(XmlAccessType.FIELD)
public class City {

    @XmlAttribute(name = "id")
    private String cityId;
    @XmlAttribute(name = "name")
    private String cityName;
    @XmlAttribute(name = "weatherCode")
    private String weatherCode;

    public String getCityId() {
        return cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public String getWeatherCode() {
        return weatherCode;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setWeatherCode(String weatherCode) {
        this.weatherCode = weatherCode;
    }
}
