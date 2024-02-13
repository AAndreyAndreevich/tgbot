package hw03.tgbot.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ValuteCursOnDate")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class ValuteCursOnDate {

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "nominal")
    private int nominal;

    @XmlElement(name = "course")
    private double course;

    @XmlElement(name = "code")
    private String code;

    @XmlElement(name = "chCode")
    private String chCode;
}