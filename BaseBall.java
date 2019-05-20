//package com.kitri.awt;
//
//import java.awt.BorderLayout;
//import java.awt.Button;
//import java.awt.Color;
//import java.awt.Font;
//import java.awt.Frame;
//import java.awt.GridLayout;
//import java.awt.Label;
//import java.awt.LayoutManager;
//import java.awt.Panel;
//import java.awt.TextArea;
//import java.awt.TextField;
//
//import javafx.scene.layout.Border;
//
//public class BaseBall extends Frame {
//	
//	Panel pE = new Panel();
//	Panel pS = new Panel();
//	Panel pC = new Panel();
//
//	
//	TextArea ta = new TextArea();
//	
//	TextField tf = new TextField();
//	Label l = new Label("Input Number", Label.CENTER);
//	
//	Button newGame = new Button("New Game");
//	Button dap = new Button("Result");
//	Button clear = new Button("Clear");
//	Button exit = new Button("Exit");
//	
//	public BaseBall() {
//		super("Number Baseball Game");
//		pS.setLayout(new BorderLayout());
//		l.setBackground(Color.orange);
//		l.setForeground(new Color(255,0,0));
//		pS.add("West", l);
//		pS.add("Center", tf);
//		
//		pE.setLayout(new GridLayout(4, 1, 0, 50));
//		
//		Font f = new Font("굴림", Font.ITALIC, 20);
//		
//		newGame.setFont(f);
//		dap.setFont(f);
//		clear.setFont(f);
//		exit.setFont(f);
//		
//		pE.add(newGame);
//		pE.add(dap);
//		pE.add(clear);
//		pE.add(exit);
//		
//		pC.setLayout(new BorderLayout(0, 5));
//		ta.setFont(f);
//		ta.setEditable(false); // 수정을 막는 함수
//		//ta.setEnabled(false); // 사용 자체를 막는 함수
//		pC.add("Center", ta);
//		pC.add("South", pS);
//		
//		this.setLayout(new BorderLayout(10, 0));
//		this.add("Center", pC);
//		this.add("East", pE);
//		
//
//		setSize(600, 450);
//		setLocation(200, 100);
//		setVisible(true);
//		
//		tf.requestFocus();		
//	}
//	
//	public static void main(String[] args) {
//		new BaseBall();
//	}
//}
