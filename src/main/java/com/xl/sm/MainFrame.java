package com.xl.sm;

import com.xl.sm.entity.Department;
import com.xl.sm.factory.DaoFactory;
import com.xl.sm.factory.ServiceFactotry;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName MainFrame
 * @Description TODO
 * @Author 1
 * @Date 2020/11/19
 **/
public class MainFrame extends Frame {
    private JPanel mainPanel;
    private JButton yuanButton;
    private JButton classButton;
    private JButton stuButton;
    private JButton jcButton;
    private JPanel topPanel;
    private JPanel centerPanel;
    private JPanel departmentPanel;
    private JPanel classPanel;
    private JPanel studentPanel;
    private JPanel rewardPanel;
    private JLabel timeLabel;

    private final CardLayout c;

    public MainFrame(){

        c = new CardLayout();
        centerPanel.setLayout(c);
        centerPanel.add("1",departmentPanel);
        centerPanel.add("2",classPanel);
        centerPanel.add("3",studentPanel);
        centerPanel.add("4",rewardPanel);
        yuanButton.addActionListener( e -> {
            c.show(centerPanel,"1");
        });
        classButton.addActionListener( e -> {
            c.show(centerPanel,"2");
        });
        stuButton.addActionListener( e -> {
            c.show(centerPanel,"3");
        });
        jcButton.addActionListener( e -> {
            c.show(centerPanel,"4");
        });
        showDepartments();

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        timeLabel.setText(df.format(new Date()));
        //updateTime();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MainFrame");
        frame.setContentPane(new MainFrame().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        new MainFrame();

        
    }

    /**
     * 显示所有院系信息
     */
    private void showDepartments(){
        //移除原有数据
        departmentPanel.removeAll();
        //从service层获取所有院系列表
        java.util.List<Department> departmentList = ServiceFactotry.getDepartmentServiceInstance().selectAll();
        //获取总数
        int len = departmentList.size();
        //根据院系总数算出行数（每行4个）
        int row = len% 4 == 0 ? len / 4 : len /4 + 1;
        //创建一个网格布局，每行4列，指定水平和垂直间距
        GridLayout gridLayout = new GridLayout(row,4,15,15);
        departmentPanel.setLayout(gridLayout);
        for(Department department : departmentList){
            //给每个院系对象创建一个面板
            JPanel depPanel = new JPanel();
            //设置合适大小
            depPanel.setPreferredSize(new Dimension(200,200));
            //将院系名称设置给面板标题
            depPanel.setBorder(BorderFactory.createTitledBorder(department.getDepartmentName()));
            //新建一个JLabel标签，用来防治院系logo，并指定大小
            JLabel logoLabel = new JLabel("<html><img src='"+ department.getLogo() + "' width='350' height='200'/></html>");
            //图标标签加入院系面板
            depPanel.add(logoLabel);
            //院系面板加入主题内容面板
            departmentPanel.add(depPanel);
            //刷新主题内容面板
            departmentPanel.revalidate();
        }
    }

    private void updateTime(){
        SimpleDateFormat df;
        while(true){
            df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            timeLabel.setText(df.format(new Date()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
