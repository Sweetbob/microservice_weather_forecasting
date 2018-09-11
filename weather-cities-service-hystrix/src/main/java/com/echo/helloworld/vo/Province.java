package com.echo.helloworld.vo;


import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "province")
@XmlAccessorType(XmlAccessType.FIELD)
public class Province {

    @XmlAttribute(name = "name")
    private String provinceName;
    @XmlElement(name = "county")
    private List<City> cities;

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public List<City> getCities() {
        return cities;
    }
}
