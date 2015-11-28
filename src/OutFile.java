import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Пользователь on 28.11.2015.
 */
public class OutFile {

    public OutFile() throws IOException {
        System.out.println(ConvertNumber.getInFile());
        BufferedWriter writer = new BufferedWriter(new FileWriter(ConvertNumber.getInFile().substring(0, ConvertNumber.getInFile().length()-4) + "_Ready.txt"));

        for (int i = 0; i < ConvertNumber.getResult().size(); i++) {
            writer.write(ConvertNumber.getResult().get(i) + "\n");

        }
        writer.write("-----ERROR----\n");
        for (int i = 0; i < ConvertNumber.getError().size(); i++) {

            writer.write(ConvertNumber.getError().get(i) + "\n");
        }
        System.out.println("Было добавлено: " + ConvertNumber.getResult().size() + " номеров.");
        System.out.println("С ошибками: " + ConvertNumber.getError().size() + " номеров");

        writer.close();

    }
}
