import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Denis Nichik on 25.11.2015.
 */
public class ConvertNumber {

    public static void main(String[] args) throws IOException {

        BufferedReader readerstream = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Укажите файл с телефонными номерами:");
        String InFile;

        InputFile inputfile = new InputFile();

        while (true) {
            try {
                InFile = readerstream.readLine();
                inputfile.readFile(InFile);
                break;
            } catch (FileNotFoundException e) {
                System.out.println("Файл не найден! Проверьте путь к файлу и введите его еще раз!");
            }
        }
        List<String> result = new ArrayList<String>();
        List<String> error = new ArrayList<String>();
        for (int i = 0; i < inputfile.getNumbers().size(); i++) {

//            Проверка на налицие дефисов в номере и их удаление
            if (inputfile.getNumbers().get(i).length() > 12) {
                String tmp = "";
                for (int j = 0; j < inputfile.getNumbers().get(i).length(); j++) {
                    if (inputfile.getNumbers().get(i).charAt(j) != '-')
                        tmp += inputfile.getNumbers().get(i).charAt(j);
                }
                inputfile.getNumbers().set(i, tmp);
            }
//            Конец проверки и удаления дефисов

            //Если номер содержит 12 знаков и начинается с +7, добавляем в результат
            if ((inputfile.getNumbers().get(i).length() == 12) && (inputfile.getNumbers().get(i).substring(0, 2).equals("+7"))) {
                result.add(inputfile.getNumbers().get(i));
            }
            //Если номер содержит 11 знаков и начинается с 7 или 8, меняем на +7 и добавляем в результат
            else if ((inputfile.getNumbers().get(i).length() == 11) && ((inputfile.getNumbers().get(i).substring(0, 1).equals("8")) || (inputfile.getNumbers().get(i).substring(0, 1).equals("7")))) {
                String tmp;
                tmp = inputfile.getNumbers().get(i).substring(1, inputfile.getNumbers().get(i).length());
                result.add("+7" + tmp);
            } else
                error.add(inputfile.getNumbers().get(i));
        }
        OutFile outFile = new OutFile();
        outFile.writeFile(InFile, result, error);
    }
}
