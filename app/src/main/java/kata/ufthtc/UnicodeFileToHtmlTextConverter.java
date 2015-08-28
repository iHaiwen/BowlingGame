package kata.ufthtc;

import org.apache.commons.lang.StringEscapeUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/**
 * Created by benwu on 14-6-10.
 */
public class UnicodeFileToHtmlTextConverter {
    private java.io.Reader reader;

    public UnicodeFileToHtmlTextConverter(String fullFilenameWithPath) throws FileNotFoundException {
        this.reader = new FileReader(fullFilenameWithPath);
    }

    public UnicodeFileToHtmlTextConverter(Reader reader) {
        this.reader = reader;
    }

    public UnicodeFileToHtmlTextConverter(Reader reader, StringEscaper stringEscaper) {

    }

    public String convertToHtml() throws IOException {
        BufferedReader reader = new BufferedReader(this.reader);

        String line = reader.readLine();
        String html = "";
        while (line != null) {
            //TODO-working-on: Depending on the third party library violates the Dependency Inversion Principle and Open-Closed Principle
            html += this.stringEscaper.escapeHtml(line);
            html += "<br />";
            line = reader.readLine();
        }
        return html;

    }
}
