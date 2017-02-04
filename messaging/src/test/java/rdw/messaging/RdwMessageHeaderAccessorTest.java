package rdw.messaging;

import org.junit.Test;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import static org.assertj.core.api.Assertions.assertThat;
import static rdw.messaging.RdwMessageHeaderAccessor.wrap;

public class RdwMessageHeaderAccessorTest {

    @Test
    public void itShouldSetAndGetContent() {
        final String content = "TRT_V0";
        final Message message = MessageBuilder.createMessage("payload", wrap(null)
                .setContent(content)
                .getMessageHeaders());

        assertThat(message.getHeaders().containsKey(RdwMessageHeaders.Content)).isTrue();
        assertThat(wrap(message).getContent()).isEqualTo(content);
    }
}
