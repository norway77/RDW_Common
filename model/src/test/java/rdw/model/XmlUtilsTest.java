package rdw.model;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

import static org.assertj.core.api.Assertions.assertThat;

public class XmlUtilsTest {

    @Test
    public void itShouldUnmarshalSampleTDSReport() {
        final TDSReport tdsReport = XmlUtils.tdsReportFromXml(this.getClass().getResourceAsStream("/TDSReport.sample.xml"));
        assertSampleTDSReport(tdsReport);
    }

    @Test
    public void itShouldRoundtripSampleTDSReport() throws UnsupportedEncodingException {
        TDSReport tdsReport = XmlUtils.tdsReportFromXml(this.getClass().getResourceAsStream("/TDSReport.sample.xml"));
        final String xml = XmlUtils.tdsReportToXml(tdsReport);
        tdsReport = XmlUtils.tdsReportFromXml(new ByteArrayInputStream(xml.getBytes("UTF-8")));
        assertSampleTDSReport(tdsReport);
    }

    public void assertSampleTDSReport(final TDSReport tdsReport) {
        assertThat(tdsReport).isNotNull();
        // spot check a few values
        assertThat(tdsReport.getTest().getAcademicYear()).isEqualTo(2014);
        assertThat(tdsReport.getExaminee().getKey()).isEqualTo(922171);
        assertThat(tdsReport.getExaminee().getExamineeAttributeOrExamineeRelationship()).hasSize(27);
        assertThat(tdsReport.getOpportunity().getTaName()).isEqualTo("Ringnell, Brandi");
        assertThat(tdsReport.getOpportunity().getScore()).hasSize(12);
        assertThat(tdsReport.getOpportunity().getScore().stream()
                .filter(score -> score.getMeasureOf().equals("Overall") && score.getMeasureLabel().equals("PerformanceLevel"))
                .findFirst().get().getValue()).isEqualTo("2");
        assertThat(tdsReport.getToolUsage().get(0).getToolPage().get(0).getGroupId()).isEqualTo("I-200-22489");
    }
}