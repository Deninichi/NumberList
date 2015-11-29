import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Denis Nichik on 25.11.2015.
 */
public class ConvertNumber {
    private static List<String> result;
    private static List<String> error;

    public static void main(String[] args) throws IOException {

        InputFile inputfile = new InputFile();

        result = new ArrayList<String>();
        error = new ArrayList<String>();
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
        OutFile outFile = new OutFile(inputfile.getInFile());
    }
    public static List<String> getResult() {
        return result;
    }

    public static List<String> getError() {
        return error;
    }
}
