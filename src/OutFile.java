import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by Denis Nichik on 28.11.2015.
 */
public class OutFile {

    public OutFile() {
    }

    public void writeFile(String inFile, List<String> result, List<String> error) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(inFile.substring(0, inFile.length()-4) + "_Ready.txt"));
        for (int i = 0; i < result.size(); i++) {
            writer.write(result.get(i) + "\n");

        }
        writer.write("-----ERROR----\n");
        for (int i = 0; i < error.size(); i++) {

            writer.write(error.get(i) + "\n");
        }
        System.out.println("Было добавлено: " + result.size() + " номеров.");
        System.out.println("С ошибками: " + error.size() + " номеров");
        System.out.println("Сохранено в файле: " + inFile.substring(0, inFile.length()-4) + "_Ready.txt");
        writer.close();
    }
}
