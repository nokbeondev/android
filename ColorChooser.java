package com.kitri.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class ColorChooser extends Frame implements AdjustmentListener, ActionListener {
	
	Panel pScrollR = new Panel();
	Panel pScrollG = new Panel();
	Panel pScrollB = new Panel();
	Panel empty1 = new Panel();
	Panel empty2 = new Panel();
	Panel empty3 = new Panel();
	Panel empty4 = new Panel();

	Panel pScrollAll = new Panel(new GridLayout(7, 1, 0, 10));

	Panel colorP = new Panel();
	Panel colorLabel = new Panel(new BorderLayout());
	Panel colorAll = new Panel(new BorderLayout());
	
	Label lR = new Label("RED");
	Label lG = new Label("GREEN");
	Label lB = new Label("BLUE");
	Label colorL = new Label("color label");
	
	Button exit = new Button("CLOSE");
	
	Scrollbar sbarR = new Scrollbar(Scrollbar.HORIZONTAL, 128, 10, 0, 265);
	Scrollbar sbarG = new Scrollbar(Scrollbar.HORIZONTAL, 128, 10, 0, 265);
	Scrollbar sbarB = new Scrollbar(Scrollbar.HORIZONTAL, 128, 10, 0, 265);

	ColorChooser(){
		super("Color Chooser");
		this.setLayout(new GridLayout(1, 2, 0, 10));
		
		lR.setBackground(Color.red);
		lG.setBackground(Color.GREEN);
		lB.setBackground(Color.BLUE);
		
		pScrollR.setLayout(new BorderLayout(20, 0));
		pScrollR.add("West", lR);
		pScrollR.add("Center", sbarR);
		
		pScrollG.setLayout(new BorderLayout(20, 0));
		pScrollG.add("West", lG);
		pScrollG.add("Center", sbarG);
		
		pScrollB.setLayout(new BorderLayout(20, 0));
		pScrollB.add("West", lB);
		pScrollB.add("Center", sbarB);
		
		pScrollAll.add(empty1);
		pScrollAll.add(pScrollR);
		pScrollAll.add(empty2);
		pScrollAll.add(pScrollG);
		pScrollAll.add(empty3);
		pScrollAll.add(pScrollB);
		pScrollAll.add(empty4);
		
		colorLabel.add("Center", colorL);
		colorLabel.add("East", exit);
		
		
		
		colorAll.add("South", colorLabel);
		colorAll.add("Center", colorP);
		
		this.add("West", pScrollAll);
		this.add("Center", colorAll);
		
		this.setBounds(200, 200, 600, 400);
		this.setVisible(true);
		// Event 등록
		exit.addActionListener(this);
		sbarR.addAdjustmentListener(this);
		sbarG.addAdjustmentListener(this);
		sbarB.addAdjustmentListener(this);
		
		chooseColor();

	}
	
	public static void main(String[] args) {
		new ColorChooser();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}

	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) {
		chooseColor();
	}

	private void chooseColor() {
		int r, g, b;
		r = sbarR.getValue();
		g = sbarG.getValue();
		b = sbarB.getValue();
		
		colorL.setText("R : " + r + ", G : " + g + ", B : " + b);
		colorP.setBackground(new Color(r, g, b));
	}
	
}
