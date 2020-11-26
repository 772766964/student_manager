package com.xl.sm;

import com.xl.sm.factory.ServiceFactotry;
import com.xl.sm.utils.ResultEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName AdminLoginFrame
 * @Description TODO
 * @Author 1
 * @Date 2020/11/19
 **/
public class AdminLoginFrame extends Frame {
    private JPanel mainPanel;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton loginButton;
    private JButton cancelButton;
    private JLabel l1;
    private JLabel l2;


    public AdminLoginFrame() {

        JFrame frame = new JFrame("AdminLoginFrame");
        frame.setContentPane(this.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        //frame.pack();
        frame.setVisible(true);

        loginButton.addActionListener(e -> {
            //获得输入的账号和密码，注意密码框组建的使用方法
            String account = textField1.getText().trim(); //trim 去处前后空格
            String password = new String(passwordField1.getPassword()).trim()   ;
            ResultEntity resultEntity = ServiceFactotry.getAdminServiceInstance().adminLogin(account,password);
            JOptionPane.showMessageDialog(mainPanel,resultEntity.getMessage());
            if(resultEntity.getCode() == 0){
                //关闭登陆界面，进入主界面
                this.dispose();
                new MainFrame();
            }else{
                textField1.setText("");
                passwordField1.setText("");
            }
        });
        cancelButton.addActionListener(e -> {
            textField1.setText("");
            passwordField1.setText("");
        });
    }

    public static void main(String[] args) {
        new AdminLoginFrame();
    }

}
