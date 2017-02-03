package rdw.messaging;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageHeaderAccessor;

/**
 * A {@link org.springframework.messaging.support.MessageHeaderAccessor}
 * implementation giving access to RDW-specific headers.<br/>
 *
 * In theory, this could be refactored so each step of the ingest pipeline has its own set of
 * headers and accessor. However, this approach is sufficient for now.
 */
public class RdwMessageHeaderAccessor extends MessageHeaderAccessor {

    /**
     * Wrap a message's headers.
     *
     * @param message message to extract headers from
     * @return a new RdwMessageHeaderAccessor
     */
    public static RdwMessageHeaderAccessor wrap(Message<?> message) {
        return new RdwMessageHeaderAccessor(message);
    }


    public RdwMessageHeaderAccessor setContent(final String content) {
        setHeader(RdwMessageHeaders.Content, content);
        return this;
    }

    public String getContent() {
        return (String) getHeader(RdwMessageHeaders.Content);
    }


    private RdwMessageHeaderAccessor(final Message<?> message) {
        super(message);
    }
}