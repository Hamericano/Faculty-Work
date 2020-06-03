package decoders;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class TextStreamDecoder {
    private final ITextDecoder decoder;

    public TextStreamDecoder(ITextDecoder decoder)
    {
        this.decoder = decoder;
    }

    public void decode(BufferedInputStream inputStream, BufferedOutputStream outStream) throws IOException, IllegalArgumentException, Exception
    {
        if (inputStream == null || outStream == null)
        {
            throw new IllegalArgumentException("Input and output streams must be set");
        }
        Scanner reader = new Scanner(inputStream);
        String encoderId = "";

        encoderId = reader.nextLine();

        if (!encoderId.equals(decoder.getIdentifier()))
            throw new Exception("Invalid file for the specified decoder");

        while(reader.hasNextLine())
        {
            String currentLine = reader.nextLine();
            String decodedLine = decoder.decode(currentLine);
            outStream.write(decodedLine.getBytes());
            outStream.write(System.lineSeparator().getBytes());
        }
        outStream.flush();

    }
}
