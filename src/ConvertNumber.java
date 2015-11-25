import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Пользователь on 25.11.2015.
 */
public class ConvertNumber
{
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("G:\\1.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("G:\\2.txt"));
        String line;
        List<String> numbers = new ArrayList<String>();
        while ((line = reader.readLine()) != null){
            numbers.add(line);
        }
        List<String> result = new ArrayList<String>();
        List<String> error = new ArrayList<String>();
        for (int i = 0; i < numbers.size(); i++) {
            if ((numbers.get(i).length() == 12) && (numbers.get(i).substring(0,2).equals("+7"))){
                result.add(numbers.get(i));
            }
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
        for (int i = 0; i < error.size(); i++) {
            writer.write("-----ERROR----\n");
            writer.write(error.get(i) + "\n");
        }
        reader.close();
        writer.close();
    }

}
