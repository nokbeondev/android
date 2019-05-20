package com.kitri.awt;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GBB extends Frame implements ActionListener{
	
	Panel p1 = new Panel(new GridLayout(1, 3, 10, 0));
	Panel p2 = new Panel(new GridLayout(1, 3, 10, 0));
	Panel p3 = new Panel(new GridLayout(1, 3, 10, 0));
	Panel p4 = new Panel(new GridLayout(1, 3, 10, 0));
	
	Button rock = new Button("ROCK");
	Button scissor = new Button("SCISSOR");
	Button paper = new Button("PAPER");
	Button close = new Button("Close");
	
	private int userNum;
	private static int randomNum;
	
	
	Label resultL = new Label("result");
	Label userL = new Label("user");
	Label comL = new Label("com");
	Label vsL = new Label("VS");
	Label emtpy1L = new Label();
	Label emtpy2L = new Label();	
	Label emtpy3L = new Label();	
	Label emtpy4L = new Label();	
	
	
	public GBB() {
		super("GBB Game");
		this.setLayout(new GridLayout(4, 1, 0, 10));
		
		p1.add(userL);
		p1.add(vsL);
		p1.add(comL);
		this.add(p1);
		
		p2.add(emtpy1L);
		p2.add(resultL);
		p2.add(emtpy2L);
		this.add(p2);
		
		p3.add(rock);
		p3.add(scissor);
		p3.add(paper);
		this.add(p3);
		
		p4.add(emtpy3L);
		p4.add(emtpy4L);
		p4.add(close);
		this.add(p4);
		
		this.setVisible(true);
		this.setBounds(300, 300, 500, 500);
		rock.addActionListener(this);
		scissor.addActionListener(this);
		paper.addActionListener(this);
		close.addActionListener(this);
		
	}
	
	public static void main(String[] args) {
		new GBB();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		randomNum = (int) (Math.round(Math.random()*1000) % 3);

		if (e.getSource() == scissor) {
			
			userNum = 0;
			userL.setText("Scissor");
			comL.setText(comChoice());
			resultL.setText(result());
		}
		
		if (e.getSource() == rock) {
			userNum = 1;
			userL.setText("Rock");
			comL.setText(comChoice());
			resultL.setText(result());
		}
		
		if (e.getSource() == paper) {

			userNum = 2;
			userL.setText("Paper");
			comL.setText(comChoice());
			resultL.setText(result());
		}
		
		if (e.getSource() == close) {
			System.exit(0);
		}
	}
	
	private String result() {
		if(randomNum == userNum) {
			return "Drew";
		}else if((randomNum+1)%3==userNum){
			return "Win";
		}else {
			return "Lose";
		}
	}
	
	private String comChoice() {
		
		if(randomNum == 0) {
			return "Scissor";
		}else if(randomNum == 1) {
			return "Rock";
		}else {
			return "Paper";
		}
	}

	
}
