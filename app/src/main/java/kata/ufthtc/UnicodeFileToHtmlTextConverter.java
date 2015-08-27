package kata.ufthtc;

import org.apache.commons.lang.StringEscapeUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by benwu on 14-6-10.
 */
public class UnicodeFileToHtmlTextConverter {
    private String fullFilenameWithPath;

    public UnicodeFileToHtmlTextConverter(String fullFilenameWithPath) {
        this.fullFilenameWithPath = fullFilenameWithPath;
    }

    public String convertToHtml() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(fullFilenameWithPath));

        String line = reader.readLine();
        String html = "";
        while (line != null) {
            html += StringEscapeUtils.escapeHtml(line);
            html += "<br />";
            line = reader.readLine();
        }
        return html;

    }
}
