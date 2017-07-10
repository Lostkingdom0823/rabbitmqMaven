package com.biz_united.rabbitmqMaven;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		entryChattingRoom.addActionListener(LoginAction);;
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
			messageWindow.setBounds(5, 5, 578, 500);
		}
		return messageWindow;
	}
	
	private JTextArea getTextInputArea(){
		if(inputTextArea==null){
			inputTextArea
		}
		return inputTextArea;
	}
	
	private ActionListener LoginAction = new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(!inputUserName.getText().equals("")){
				chattingRoomSetup = new ChattingRoomSetup(inputUserName.getText());
				entryChattingRoom();
			}
		}
	};
	
	private void entryChattingRoom(){
		JPanel jPanel = (JPanel) getContentPane();
		setSize(600,700);
		add(getMessageWindow(),null);
		jPanel.setBounds(5, 510, 578, 180);
		jPanel.remove(text);
		jPanel.remove(inputUserName);
		jPanel.remove(entryChattingRoom);
		repaint();
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args){
		new ChattingRoom();
	}

}
