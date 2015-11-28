import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Пользователь on 28.11.2015.
 */
public class InputFile {
    private String InFile;
    private List<String> numbers;

    public InputFile () throws IOException {
        BufferedReader readerstream = new BufferedReader(new InputStreamReader(System.in));
        InFile = readerstream.readLine();

        BufferedReader reader = new BufferedReader(new FileReader(InFile));
        String line;
        numbers = new ArrayList<String>();
        while ((line = reader.readLine()) != null){
            numbers.add(line);
        }

        reader.close();
    }

    public String getInFile() {
        return InFile;
    }

    public List<String> getNumbers() {
        return numbers;
    }
}
