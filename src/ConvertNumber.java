import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Denis Nichik on 25.11.2015.
 */
public class ConvertNumber
{
    public static void main(String[] args) throws IOException {


        BufferedReader readerstream = new BufferedReader(new InputStreamReader(System.in));
        String inputFile = readerstream.readLine();

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile.substring(0, inputFile.length()-4) + "_Ready.txt"));
        String line;
        List<String> numbers = new ArrayList<String>();
        while ((line = reader.readLine()) != null){
            numbers.add(line);
        }
        List<String> result = new ArrayList<String>();
        List<String> error = new ArrayList<String>();
        for (int i = 0; i < numbers.size(); i++) {

//            Проверка на налицие дефисов в номере и их удаление
            if (numbers.get(i).length()>12){
                String tmp = "";
                for (int j = 0; j < numbers.get(i).length(); j++) {
                    if (numbers.get(i).charAt(j) != '-')
                        tmp += numbers.get(i).charAt(j);
                }
                numbers.set(i, tmp);
            }
//            Конец проверки и удаления дефисов

            //Если номер содержит 12 знаков и начинается с +7, добавляем в результат
            if ((numbers.get(i).length() == 12) && (numbers.get(i).substring(0,2).equals("+7"))){
                result.add(numbers.get(i));
            }
            //Если номер содержит 11 знаков и начинается с 7 или 8, меняем на +7 и добавляем в результат
            else if ((numbers.get(i).length() == 11) && ((numbers.get(i).substring(0,1).equals("8")) || (numbers.get(i).substring(0,1).equals("7")))){
                String tmp;
                tmp = numbers.get(i).substring(1, numbers.get(i).length());
                result.add("+7" + tmp);
            }
            else
                error.add(numbers.get(i));
        }
        
        for (int i = 0; i < result.size(); i++) {
            writer.write(result.get(i) + "\n");

        }
        writer.write("-----ERROR----\n");
        for (int i = 0; i < error.size(); i++) {

            writer.write(error.get(i) + "\n");
        }
        System.out.println("Было добавлено: " + result.size() + " номеров.");
        System.out.println("С ошибками: " + error.size() + " номеров");
        reader.close();
        writer.close();
    }

}
