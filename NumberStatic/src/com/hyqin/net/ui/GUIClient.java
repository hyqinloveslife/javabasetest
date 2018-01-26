package com.hyqin.net.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUIClient {
	public static final String statue = "客户端";
	public static void main(String[] args) throws Exception {
		 JFrame f = new JFrame();
	        f.setTitle("客户端");

	        f.setSize(400, 300);
	        f.setLocation(600, 200);
	        f.setLayout(null);

	        JButton b = new JButton("发送");
	        b.setBounds(10, 10, 80, 30);
	        f.add(b);

	        final JTextField tf = new JTextField();
	        tf.setBounds(10, 110, 80, 30);
	        f.add(tf);

	        final JTextArea ta = new JTextArea();
	        ta.setBounds(110,10, 200, 300);
	        ta.setEditable(false);
	        ta.setLineWrap(true);
	        ta.setWrapStyleWord(true);
	        f.add(ta);

	        f.add(new JScrollPane(ta));
	        
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        f.setVisible(true);

	        final Socket s = new Socket("127.0.0.1", 9999);

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

	        b.addActionListener(new ActionListener() {

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
