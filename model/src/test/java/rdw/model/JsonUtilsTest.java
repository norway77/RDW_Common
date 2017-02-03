package rdw.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonUtilsTest {

    @Test
    public void itShouldDeserializeContentMetaData() {
        final ContentMetaData metaData = assertAssessment("iab.json");
        assertThat(metaData.getIdentification().getEffectiveDate()).isEqualTo("20160701");
        assertThat(metaData.getIdentification().getPeriod()).isEqualTo("2016");
        assertThat(metaData.getPerformanceLevels().getLevel3().getCutPoint()).isEqualTo(1400);
        assertThat(metaData.getClaims().getClaim2().getName()).isEqualTo("Writing");
        assertThat(metaData.getSource().getCallbackUrl()).isEqualTo("http://cnn.com");
    }

    @Test
    public void itShouldDeserializeAsmt1() {
        // "content":"assessment" instead of "Content":"assessment"
        // "Period":"2017-01-01" instead of "Period":"2017" (?)
        final ContentMetaData metaData = assertAssessment("asmt1.json");
        assertThat(metaData.getIdentification().getPeriod()).isEqualTo("2017-01-01");
    }

    @Test
    public void itShouldDeserializeSR1() {
        final ContentMetaData metaData = assertStudentRegistration("sr1.json");
        assertThat(metaData.getIdentification().getYear()).isEqualTo(2015);
    }

    private ContentMetaData assertAssessment(final String resource) {
        return assertContentMetaData(resource, "assessment");
    }

    private ContentMetaData assertStudentRegistration(final String resource) {
        return assertContentMetaData(resource, "StudentRegistration");
    }

    private ContentMetaData assertContentMetaData(final String resource, final String content) {
        final ContentMetaData metaData = JsonUtils.contentMetaDataFromJson(JsonUtilsTest.class.getResourceAsStream("/" + resource));
        assertThat(metaData).isNotNull();
        assertThat(metaData.getContent()).isEqualTo(content);
        return metaData;
    }


}