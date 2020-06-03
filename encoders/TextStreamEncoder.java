package encoders;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class TextStreamEncoder {
    private ITextEncoder encoder;

    public TextStreamEncoder(ITextEncoder encoder)
    {
        this.encoder = encoder;
    }

    public void encode(BufferedInputStream inputStream, BufferedOutputStream outStream) throws IOException
    {
        if (inputStream == null || outStream == null)
        {
            throw new IllegalArgumentException("Input and output streams must be set");
        }

        Scanner reader = new Scanner(inputStream);
        //BufferedWriter writer = new BufferedWriter(outStream);
        outStream.write(encoder.getIdentifier().getBytes());
        outStream.write(System.lineSeparator().getBytes());
        while(reader.hasNextLine())
        {
            String currentLine = reader.nextLine();
            String encodedLine = encoder.encode(currentLine);
            outStream.write(encodedLine.getBytes());
            outStream.write(System.lineSeparator().getBytes());
        }

        outStream.flush();
    }
}
