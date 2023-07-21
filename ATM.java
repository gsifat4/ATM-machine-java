import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATM {
    private double balance;
    private JFrame frame;
    private JLabel balanceLabel;
    private JTextField amountField;

    public ATM() {
        balance = 0.0;
        frame = new JFrame("ATM");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 1));
        frame.getContentPane().setBackground(new Color(240, 240, 240));

        balanceLabel = new JLabel("Your current balance: $" + balance);
        balanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 18));
        frame.add(balanceLabel);

        JPanel transactionPanel = new JPanel();
        transactionPanel.setLayout(new GridLayout(2, 2));
        transactionPanel.setBackground(new Color(200, 200, 200));

        JLabel amountLabel = new JLabel("Enter amount:");
        transactionPanel.add(amountLabel);

        amountField = new JTextField();
        transactionPanel.add(amountField);

        JButton depositButton = new JButton("Deposit");
        depositButton.setBackground(new Color(0, 153, 0));
        depositButton.setForeground(Color.WHITE);
        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performDeposit();
            }
        });
        transactionPanel.add(depositButton);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setBackground(new Color(204, 0, 0));
        withdrawButton.setForeground(Color.WHITE);
        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performWithdraw();
            }
        });
        transactionPanel.add(withdrawButton);

        frame.add(transactionPanel);

        JButton checkBalanceButton = new JButton("Check Balance");
        checkBalanceButton.setBackground(new Color(0, 102, 204));
        checkBalanceButton.setForeground(Color.WHITE);
        checkBalanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkBalance();
            }
        });
        frame.add(checkBalanceButton);

        frame.setVisible(true);
    }

    private void checkBalance() {
        JOptionPane.showMessageDialog(frame, "Your current balance: $" + balance);
    }

    private void performDeposit() {
        String input = amountField.getText();
        double amount = Double.parseDouble(input);
        if (amount > 0) {
            balance += amount;
            JOptionPane.showMessageDialog(frame, "Deposit successful.");
            updateBalanceLabel();
        } else {
            JOptionPane.showMessageDialog(frame, "Invalid amount. Please try again.");
        }
    }

    private void performWithdraw() {
        String input = amountField.getText();
        double amount = Double.parseDouble(input);
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            JOptionPane.showMessageDialog(frame, "Withdrawal successful.");
            updateBalanceLabel();
        } else {
            JOptionPane.showMessageDialog(frame, "Invalid amount or insufficient funds. Please try again.");
        }
    }

    private void updateBalanceLabel() {
        balanceLabel.setText("Your current balance: $" + balance);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ATM();
            }
        });
    }
}
