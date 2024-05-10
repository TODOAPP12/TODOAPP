// Ben
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class theApp {
    // Create a frame 
    public JFrame frame = new JFrame("Popup Example"); 
    
    // Create a custom panel with absolute positioning 
    public JPanel panel = new JPanel(null); 

    // Function to determine the winner
    public static String determineWinner(int[] board) {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i * 3] == board[i * 3 + 1] && board[i * 3 + 1] == board[i * 3 + 2]) {
                if (board[i * 3] == 1) {
                    return "Black wins";
                } else if (board[i * 3] == 2) {
                    return "Blue wins";
                }
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[i] == board[i + 3] && board[i + 3] == board[i + 6]) {
                if (board[i] == 1) {
                    return "Black wins";
                } else if (board[i] == 2) {
                    return "Blue wins";
                }
            }
        }

        // Check diagonals
        if ((board[0] == board[4] && board[4] == board[8]) ||
            (board[2] == board[4] && board[4] == board[6])) {
            if (board[4] == 1) {
                return "Black wins";
            } else if (board[4] == 2) {
                return "Blue wins";
            }
        }

        // If no winner yet
        return "No winner yet";
    }

    public void theApp() {
        final boolean[] turn = {true}; // Declare as final array to be effectively final
        final boolean[] used = {false, false, false, false, false, false, false, false, false};
        final int[] board = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        

        // Create buttons
        JButton[] buttons = new JButton[9];
        for (int i = 0; i < 9; i++) {
            final int buttonIndex = i; // Capture button index in lambda expression
            buttons[i] = new JButton("");
            buttons[i].setBounds((i % 3) * 100, (i / 3) * 100, 100, 100);
            buttons[i].addActionListener(e -> {
                
                // Create a pop-up message dialog 
                if (turn[0] && !used[buttonIndex]) {

                    // manzoor
                    turn[0] = false;
                    buttons[buttonIndex].setBackground(Color.BLACK);
                    updatePage();
                    board[buttonIndex] = 1;

                // Ben
                } else if (!used[buttonIndex]) {

                    // manzoor
                    turn[0] = true;
                    buttons[buttonIndex].setBackground(Color.BLUE);
                    updatePage();
                    board[buttonIndex] = 2;
                }
                // Ben
                used[buttonIndex] = true;

                if(determineWinner(board) != "No winner yet") {
                    JOptionPane.showMessageDialog(frame, determineWinner(board), "Popup Message", JOptionPane.INFORMATION_MESSAGE); 
                }
            });
            panel.add(buttons[i]);
        }
        
        updatePage();
    }

    // Manzoor
    public void updatePage() {
        // Set the custom panel as the content pane of the frame 
        frame.setContentPane(panel);
        // Set frame size and make it visible 
        frame.setSize(315, 339); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setVisible(true); 
    }
}
