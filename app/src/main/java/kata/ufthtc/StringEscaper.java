package kata.ufthtc;

import org.apache.commons.lang.StringEscapeUtils;

/**
 * Author: haiwen.li
 * Time: 8/28/15 10:22 AM
 * <p/>
 * 字符串装换器
 */

public class StringEscaper {

    public String escapeHtml(String originalString) {
        return StringEscapeUtils.escapeHtml(originalString);
    }
}
