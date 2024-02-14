package hw03.tgbot.service;

import hw03.tgbot.dto.GetCursOnDateXML;
import hw03.tgbot.dto.GetCursOnDateXmlResponse;
import hw03.tgbot.dto.ValuteCursOnDate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.client.core.WebServiceTemplate;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class CentralRussianBankService extends WebServiceTemplate {

    @Value("${cbr.api.url}")
    private String cbrApi;

    public List<ValuteCursOnDate> getCurrenciesFromCbr() throws DatatypeConfigurationException {
        final GetCursOnDateXML getCursOnDateXml = new GetCursOnDateXML();
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(new Date());

        XMLGregorianCalendar xmlGregCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
        getCursOnDateXml.setOnDate(xmlGregCal);

        GetCursOnDateXmlResponse response = (GetCursOnDateXmlResponse) marshalSendAndReceive(cbrApi, getCursOnDateXml);

        if (response == null) {
            throw new IllegalStateException("Не удалось получить ответ от службы ЦБ РФ");
        }

        final List<ValuteCursOnDate> courses = response.getGetCursOnDateXmlResult().getValuteData();
        courses.forEach(course -> course.setName(course.getName().trim()));
        return courses;
    }

    public ValuteCursOnDate getCourseForCurrency(String code) throws DatatypeConfigurationException {
        return getCurrenciesFromCbr().stream().filter(currency -> code.equals(currency.getChCode())).findFirst().get();
    }
}