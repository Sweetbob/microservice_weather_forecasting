package com.echo.helloworld.utils;

import com.echo.helloworld.vo.City;
import com.echo.helloworld.vo.Province;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class ExtraUtils {

    public static List<City> getListOfCities() {
        Province province = null;
        File file = new File(ExtraUtils.class.getClassLoader().getResource("citylist.xml").getPath());
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Province.class);
            Unmarshaller unmarshaller = null;
            unmarshaller = jaxbContext.createUnmarshaller();
            province = (Province) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return province.getCities();
    }
}
