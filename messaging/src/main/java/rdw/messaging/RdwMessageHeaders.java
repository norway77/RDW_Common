package rdw.messaging;

import org.springframework.messaging.MessageHeaders;

/**
 * Pre-defined names and prefixes to be used for setting and/or retrieving RDW message properties
 * from/to {@link org.springframework.messaging.Message Message} Headers.<br/>
 * <p>
 * The naming convention uses prefixes to scope a header. Thus, all these will have "rdw_" as the
 * prefix. Additional prefixes may be used to further scope a header. The header key itself should
 * be camel-cased. For example, rdw_attr_shoeSize.
 * </p>
 */
public class RdwMessageHeaders {

    public static final String ContentType = MessageHeaders.CONTENT_TYPE;

    public static final String Prefix = "rdw_";

    public static final String Content = Prefix + "content";    // TRT_V0, StudentReg, etc.
}
