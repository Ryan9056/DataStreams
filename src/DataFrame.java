import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class DataFrame extends JFrame {

    JPanel mainPnl;
    JPanel displayPnl;
    JPanel controlPnl;

    JTextArea displayTA;
    JScrollPane scroller;


    JButton quitBtn;


    String word;

    ArrayList<Integer> linenumbers = new ArrayList<>();




    public DataFrame()
    {


        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createDisplayPanel();
        mainPnl.add(displayPnl, BorderLayout.CENTER);

        createControlPanel();
        mainPnl.add(controlPnl, BorderLayout.SOUTH);

        add(mainPnl);
        setSize(810, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }





    private void createDisplayPanel()
    {

        displayPnl = new JPanel();
        displayTA = new JTextArea(10, 35);
        displayTA.setFont(new Font("Georgia", Font.PLAIN, 14));
        displayTA.setEditable(false);

        word = JOptionPane.showInputDialog("Input a word you would like to search for");


        linenumbers = DataProcess.lineread(word);

        for (int i = 0; i < linenumbers.size(); i++) {
            displayTA.append("Your word was found on line: " + linenumbers.get(i) + "\n");
        }


        scroller = new JScrollPane(displayTA);
        displayPnl.add(scroller);
    }


    private void createControlPanel()
    {
        controlPnl = new JPanel();
        controlPnl.setLayout(new GridLayout(1, 1));


        quitBtn = new JButton("Quit!");
        quitBtn.setFont(new Font("Verdana", Font.PLAIN, 20));
        quitBtn.addActionListener((ActionEvent ae) -> {
                    System.exit(0);
                }
        );


        controlPnl.add(quitBtn);

    }
}
