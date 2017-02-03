package rdw.model;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;

public class XmlUtils {

    public static TDSReport tdsReportFromXml(final InputStream is) {
        try {
            final JAXBContext jaxbContext = JAXBContext.newInstance("rdw.model");
            final Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (TDSReport) unmarshaller.unmarshal(is);
        } catch (final JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public static String tdsReportToXml(final TDSReport report) {
        try {
            final JAXBContext jaxbContext = JAXBContext.newInstance("rdw.model");
            final Marshaller marshaller = jaxbContext.createMarshaller();
            final StringWriter writer = new StringWriter();
            marshaller.marshal(report, writer);
            return writer.toString();
        } catch (final JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public static void tdsReportToXml(final TDSReport report, final OutputStream os) {
        try {
            final JAXBContext jaxbContext = JAXBContext.newInstance("rdw.model");
            final Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.marshal(report, os);
        } catch (final JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
