import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Denis Nichik on 28.11.2015.
 */
public class InputFile {
    private List<String> numbers;

    public InputFile(){
    }

    public void readFile(String InFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(InFile));
        String line;
        numbers = new ArrayList<String>();
        while ((line = reader.readLine()) != null) {
                numbers.add(line);
        }
        reader.close();
    }

    public List<String> getNumbers() {
        return numbers;
    }
}
