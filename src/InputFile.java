import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Пользователь on 28.11.2015.
 */
public class InputFile extends JFrame {
    private String InFile;
    private List<String> numbers;
    private File file;

    public InputFile () throws IOException {
//        super("ConvNumber - Форматирование телефонных номеров.");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        JPanel panel = new JPanel();
//        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

//        panel.add(Box.createVerticalGlue());

//        final JLabel label = new JLabel("Укажите список телефонных номеров в текстовом файле.");
//        label.setAlignmentX(CENTER_ALIGNMENT);
//        panel.add(label);

//        panel.add(Box.createRigidArea(new Dimension(10, 10)));

//        JButton button = new JButton("Выбрать файл");
//        button.setAlignmentX(CENTER_ALIGNMENT);

//        button.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                JFileChooser fileopen = new JFileChooser();
//                int ret = fileopen.showDialog(null, "Открыть файл");
//                if (ret == JFileChooser.APPROVE_OPTION) {
//                    File file = fileopen.getSelectedFile();
//                    label.setText(file.getName());
//                }
//            }
//        });

//        panel.add(button);
//        panel.add(Box.createVerticalGlue());
//        getContentPane().add(panel);

//        setPreferredSize(new Dimension(460, 120));
//        pack();
//        setLocationRelativeTo(null);
//        setVisible(true);


        BufferedReader readerstream = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Укажите файл с телефонными номерами:");
        InFile = readerstream.readLine();
    }

    public void readFile() throws IOException {
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

//    public File getFile() {
//        return file;
//    }
}
