package com.biz_united.rabbitmqMaven;

import java.awt.BorderLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ChattingRoom extends javax.swing.JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//
	private JButton entryChattingRoom;
	private JTextArea inputUserName;
	private JLabel text;
	private ChattingRoomSetup chattingRoomSetup;
	private JTextArea inputTextArea;
	private JButton sendText;
	
	//
	private JScrollPane messageWindow;
	

	public ChattingRoom(){
		super();
		this.setLayout(null);
		this.setSize(300, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.getContentPane().setLayout(null);
		this.add(getInputUserName(),null);
		this.add(getText(),null);
		this.add(getLoginButton(),null);
		entryChattingRoom.addActionListener(loginAction);;
		this.setTitle("Login");
		this.setVisible(true);
	}
	
	private JButton getLoginButton(){
		if(entryChattingRoom==null){
			entryChattingRoom=new JButton();
			entryChattingRoom.setBounds(100, 110, 80, 25);
			entryChattingRoom.setText("Login");	
		}
		return entryChattingRoom;
	}
	
	private JTextArea getInputUserName (){
		if(inputUserName==null){
			inputUserName = new JTextArea();
			inputUserName.setBounds(130, 60, 110, 18);
		}
		return inputUserName;
	}
	
	private JLabel getText(){
		if(text==null){
			text= new JLabel();
			text.setBounds(45, 60, 80, 18);
			text.setText("User Name:");
		}
		return text;
	}
	
	private JScrollPane getMessageWindow(){
		if(messageWindow==null){
			messageWindow=new JScrollPane();
			messageWindow.setBounds(5, 5, 578, 400);
		}
		return messageWindow;
	}
	
	private JTextArea getTextInputArea(){
		if(inputTextArea==null){
			inputTextArea = new JTextArea();
			inputTextArea.setBounds(5, 410, 500, 145);
		}
		return inputTextArea;
	}
	
	private JButton getSendButton(){
		if(sendText == null){
			sendText=new JButton();
			sendText.setText("Send");
			sendText.setBounds(510, 460, 70, 40);
		}
		return sendText;
	}
	
	private ActionListener loginAction = new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(!inputUserName.getText().equals("")){
				chattingRoomSetup = new ChattingRoomSetup(inputUserName.getText());
				entryChattingRoom();
			}
		}
	};
	
	private ActionListener sendMessage = new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(!inputTextArea.getText().equals("")){
				try {
					chattingRoomSetup.sendMessage(chattingRoomSetup.getChannel(), inputTextArea.getText());
					inputTextArea.setText(null);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	};
	
	private void entryChattingRoom(){
		JPanel jPanel = (JPanel) getContentPane();
		setSize(600,600);
		add(getMessageWindow(),null);
		jPanel.setBounds(5, 510, 578, 180);
		jPanel.remove(text);
		jPanel.remove(inputUserName);
		jPanel.remove(entryChattingRoom);
		jPanel.add(getTextInputArea(),null);
		jPanel.add(getSendButton(), null);
		sendText.addActionListener(sendMessage);
		repaint();
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args){
		new ChattingRoom();
	}

}
