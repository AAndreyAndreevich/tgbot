package hw03.tgbot.dto;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "GetCursOnDateXMLResult")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class GetCursOnDateXmlResult {

    @XmlElementWrapper(name = "ValuteData", namespace = "")
    @XmlElement(name = "ValuteCursOnDate", namespace = "")
    private List<ValuteCursOnDate> valuteData = new ArrayList<>();
}