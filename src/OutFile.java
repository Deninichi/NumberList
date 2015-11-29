import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Пользователь on 28.11.2015.
 */
public class OutFile {
        private BufferedWriter writer;
        private String inFile;

    public OutFile(String inFile) throws IOException {
        this.inFile = inFile;
        writer = new BufferedWriter(new FileWriter(inFile.substring(0, inFile.length()-4) + "_Ready.txt"));


    }

    public void writeFile() throws IOException {
        for (int i = 0; i < ConvertNumber.getResult().size(); i++) {
            writer.write(ConvertNumber.getResult().get(i) + "\n");

        }
        writer.write("-----ERROR----\n");
        for (int i = 0; i < ConvertNumber.getError().size(); i++) {

            writer.write(ConvertNumber.getError().get(i) + "\n");
        }
        System.out.println("Было добавлено: " + ConvertNumber.getResult().size() + " номеров.");
        System.out.println("С ошибками: " + ConvertNumber.getError().size() + " номеров");
        System.out.println("Сохранено в файле: " + inFile.substring(0, inFile.length()-4) + "_Ready.txt");
        writer.close();
    }
}
