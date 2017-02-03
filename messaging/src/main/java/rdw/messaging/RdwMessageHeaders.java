package rdw.messaging;

import org.springframework.messaging.MessageHeaders;

/**
 * Pre-defined names and prefixes to be used for setting and/or retrieving RDW message properties
 * from/to {@link org.springframework.messaging.Message Message} Headers.<br/>
 */
public class RdwMessageHeaders {

    public static final String ContentType = MessageHeaders.CONTENT_TYPE;

    public static final String Prefix = "rdw_";

    public static final String Content = Prefix + "content";    // TRT_V0, StudentReg, etc.
}
