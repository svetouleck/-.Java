import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
	static eHandler handler = new eHandler();;
	static JComboBox list;
	static JTextArea text1;
	static JTextArea text2;
	static JScrollPane sc2;
	static JScrollPane sc1;
	static JLabel keyWordLabel;
	static JTextField keyWordText;
	static JButton clearButton;
	static JButton doButton;


	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 500);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel(null);
		frame.add(panel, BorderLayout.CENTER);

		//Режим программы
		list = new JComboBox();
		list.setEditable(true);
		list.addItem("Шифрование");
		list.addItem("Дешифровка");
		list.setBounds(200, 20, 200, 20);

		//Поле 1
		text1 = new JTextArea("Введите исходный текст", 8, 10);
		sc1 = new JScrollPane(text1);
		text1.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		text1.setTabSize(10);
		text1.setLineWrap(true);
		text1.setWrapStyleWord(true);
		sc1.setBounds(20, 50, 260, 300);

		//Поле 2
		text2 = new JTextArea("Здесь будет находиться результат", 8, 10);
		sc2 = new JScrollPane(text2);
		sc2.setBounds(310, 50, 260, 300);
		text2.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		text2.setTabSize(10);
		text2.setLineWrap(true);
		text2.setWrapStyleWord(true);

		//Кодовое слово
		keyWordLabel = new JLabel("Введите ключ");
		keyWordText = new JTextField(10);
		keyWordLabel.setBounds(180, 370, 100, 20);
		keyWordText.setBounds(290, 370, 100, 20);

		//кнопки
		clearButton = new JButton("Очистить");
		doButton = new JButton("Выполнить");
		clearButton.setBounds(180, 410, 100, 20);
		doButton.setBounds(300, 410, 100, 20);
		clearButton.addActionListener(handler);
		doButton.addActionListener(handler);

		//добавление на панель
		panel.add(list);
		panel.add(sc1);
		panel.add(sc2);
		panel.add(keyWordLabel);
		panel.add(keyWordText);
		panel.add(clearButton);
		panel.add(doButton);
		frame.setContentPane(panel);


		frame.setVisible(true);
	}
		static class eHandler implements ActionListener {
			public void actionPerformed(ActionEvent e) {
					if (e.getSource() == clearButton) {
						keyWordText.setText(null);
						text1.setText("Введите исходный текст");
						text2.setText("Здесь будет находиться результат");
					}
					if (e.getSource() == doButton) {
						String mode = (String) list.getSelectedItem();
						if (mode == "Шифрование"){
							try {
								String dataIn = text1.getText();
								String keyword = keyWordText.getText();
								String dataOut = Caesar.encryption(Integer.parseInt(keyword), dataIn);
								text2.setText(dataOut);
							}catch (Exception ex) {
								JOptionPane.showMessageDialog(null, "При шифровании ключ должен быть числом");
							}
						}
						if (mode == "Дешифровка"){
							String dataIn = text1.getText();
							String keyword = keyWordText.getText();
							try {
								Integer.parseInt(keyword);
								JOptionPane.showMessageDialog(null, "При дешифровке ключ должен быть строкой, а не числом");
							} catch (Exception exxx){
								String dataOut = Caesar.decoding(keyword,dataIn);
								text2.setText(dataOut);
							}

						}



				}
			}
		}
}
