import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TodoList {
    public static void main(String[] args) {
        TodoList app = new TodoList();
        app.toDoframe(); // toDoframe 메서드 호출
    }

    public void toDoframe() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("ToDo List");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setPreferredSize(new Dimension(400, 300));

                frame.setLayout(new BorderLayout());

                JTextField inputField = new JTextField();
                JButton addButton = new JButton("Add ToDo");
                JButton deleteButton = new JButton("Delete ToDo");
                JButton editButton = new JButton("Edit ToDo");

                DefaultListModel<String> listModel = new DefaultListModel<>();
                JList<String> todoList = new JList<>(listModel);
                todoList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                JScrollPane scrollPane = new JScrollPane(todoList);

                addButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String input = inputField.getText();
                        if (!input.trim().isEmpty()) {
                            listModel.addElement(input);
                            inputField.setText("");
                        } else {
                            JOptionPane.showMessageDialog(frame, "Please enter a ToDo item.");
                        }
                    }
                });

                deleteButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        int selectedIndex = todoList.getSelectedIndex();
                        if (selectedIndex != -1) {
                            listModel.remove(selectedIndex);
                        } else {
                            JOptionPane.showMessageDialog(frame, "Please select a ToDo item to delete.");
                        }
                    }
                });

                editButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        int selectedIndex = todoList.getSelectedIndex();
                        if (selectedIndex != -1) {
                            String newInput = JOptionPane.showInputDialog(frame, "Edit ToDo:", listModel.getElementAt(selectedIndex));
                            if (newInput != null && !newInput.trim().isEmpty()) {
                                listModel.set(selectedIndex, newInput);
                            }
                        } else {
                            JOptionPane.showMessageDialog(frame, "Please select a ToDo item to edit.");
                        }
                    }
                });

                JPanel panel = new JPanel();
                panel.setLayout(new BorderLayout());
                panel.add(inputField, BorderLayout.CENTER);
                panel.add(addButton, BorderLayout.WEST);
                panel.add(deleteButton, BorderLayout.EAST);
                panel.add(editButton, BorderLayout.SOUTH);

                frame.getContentPane().add(panel, BorderLayout.NORTH);
                frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                frame.setLocation(dim.width / 2 - 200, dim.height / 2 - 150);

                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
