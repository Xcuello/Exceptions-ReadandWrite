package rocks.zipcode;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author leon on 16/11/2018.
 */
public class NumericCharDocument extends Document {

    public NumericCharDocument(String fileName) throws IOException {

        super(fileName);
    }

    @Override
    public void write(String contentToBeWritten) {

        if (isNumeric(contentToBeWritten)) {

            super.write(contentToBeWritten);

        } else {

            throw new IllegalArgumentException();
        }
    }

    private Boolean isNumeric(String s) {

        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(s);

        return matcher.find();
    }
}
