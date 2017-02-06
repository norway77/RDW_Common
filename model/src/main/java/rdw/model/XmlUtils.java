package rdw.model;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.InputStream;
import java.io.StringWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class XmlUtils {
    private static final Logger logger = LoggerFactory.getLogger(XmlUtils.class);

    public static TDSReport tdsReportFromXml(final InputStream is) {
        try {
            // TODO - ?add fields for xml source schema version, and whether it validated?
            return (TDSReport) createUnmarshaller().unmarshal(is);
        } catch (final JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public static String tdsReportToXml(final TDSReport report) {
        try {
            final StringWriter writer = new StringWriter();
            createMarshaller().marshal(report, writer);
            return writer.toString();
        } catch (final JAXBException e) {
            throw new RuntimeException(e);
        }
    }


    private static JAXBContext context;
    private static Schema schema;

    private static JAXBContext getContext() throws JAXBException {
        // although not thread-safe, the worst that happens is double instantiation
        if (context == null) {
            context = JAXBContext.newInstance("rdw.model");
        }
        return context;
    }

    private static Schema getSchema() {
        // although not thread-safe, the worst that happens is double instantiation
        // probably change this once we want to deal with multiple schemas
        if (schema == null) {
            try {
                schema = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI)
                        .newSchema(new StreamSource(XmlUtils.class.getResourceAsStream("/TestResultsTransmissionFormat.xsd")));
            } catch (final SAXException e) {
                // this can't really happen but the code insists we handle it
                logger.warn("Failed to load TRT schema; unmarshalling without validation", e);
                schema = null;
            }
        }
        return schema;
    }

    private static Marshaller createMarshaller() throws JAXBException {
        return getContext().createMarshaller();
    }

    private static Unmarshaller createUnmarshaller() throws JAXBException {
        final Unmarshaller unmarshaller = getContext().createUnmarshaller();
        unmarshaller.setSchema(getSchema());
        return unmarshaller;
    }
}
