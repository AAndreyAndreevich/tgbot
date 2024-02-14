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

    @XmlElement(name = "Vname")
    private String name;

    @XmlElement(name = "Vnominal")
    private int nominal;

    @XmlElement(name = "Vcourse")
    private double course;

    @XmlElement(name = "Vcode")
    private String code;

    @XmlElement(name = "VchCode")
    private String chCode;
}