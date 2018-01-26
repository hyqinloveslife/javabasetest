package com.hyqin.net.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUIServer {
	public static final String statue = "客户端";
	public static void main(String[] args) throws Exception {
		
		JFrame f = new JFrame();
		f.setTitle("服务端");
		
		f.setSize(400,300);
		f.setLocation(100, 200);
		f.setLayout(null);
		
		JButton btn = new JButton("发送");
		btn.setBounds(10, 10, 80, 30);
		f.add(btn);
		
		final JTextField tf = new JTextField();
		tf.setBounds(10, 110, 80, 30);
		f.add(tf);
		
		final JTextArea ta = new JTextArea();
        ta.setBounds(110,10, 200, 300);
        ta.setEditable(false);
        f.add(ta);
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        
        ServerSocket ss = new ServerSocket(9999);
        System.out.println("listenning on port:9999");
        
        final Socket s =  ss.accept();        
        new Thread() {
            public void run() {
                while (true) {
                    try {
                        DataInputStream dis = new DataInputStream(
                                s.getInputStream());
                        String text = dis.readUTF();
                        ta.append(statue+": "+text+"\r\n");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        }.start();
        
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String text = tf.getText();
                ta.append(text+"\r\n");

                try {
                    DataOutputStream dos = new DataOutputStream(
                            s.getOutputStream());
                    dos.writeUTF(text);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        
	}
}
