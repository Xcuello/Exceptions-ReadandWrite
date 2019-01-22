package rocks.zipcode;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author leon on 18/11/2018.
 */
public class SpecialCharDocument extends Document {

    public SpecialCharDocument(String fileName) throws IOException {

        super(fileName);
    }

    @Override
    public void write(String contentToBeWritten) {

        if (isSpecialCharacters(contentToBeWritten)) {

            super.write(contentToBeWritten);

        } else {

            throw new IllegalArgumentException();
        }
    }

    private Boolean isSpecialCharacters(String s) {

        Pattern pattern = Pattern.compile("[^\\w\\s]");
        Matcher matcher = pattern.matcher(s);

        return matcher.find();
    }
}
