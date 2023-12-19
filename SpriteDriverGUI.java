import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
//from   www.java2s.com
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.event.*;
public class SpriteDriverGUI{
	public static void main(String avg[]) throws Exception {

		Sprite sprite = new Sprite();
		String fileName = "English_pattern_playing_cards_deck.svg.png";
		sprite.getSpriteSheet(fileName);  // this knows the size of a card
//		BufferedImage imgKS = sprite.getSprite(0, 12);  // 4 Suits X 13 Ranks
//		BufferedImage img10c = sprite.getSprite(3, 9);  // 4 Suits X 13 Ranks
//		                                                // 0 spades, 1 hearts, 2 diamonds, 3 clubs
		HashMap<String, ImageIcon> imageMap = new HashMap<String, ImageIcon>();
		for (int j=0;j<4;j++) {
			String temp = "";
			String temp1 = "";
			if (j == 0) {
				temp = "S";
			} else if (j == 1) {
				temp = "H";
			} else if (j == 2) {
				temp = "D";
			} else {
				temp = "C";
			}

			for (int i = 0; i < 13; i++) {
				if (i == 0) {
					temp1 = "A";
				} else if (i == 10) {
					temp1 = "J";
				} else if (i == 11) {
					temp1 = "Q";
				} else if (i == 12) {
					temp1 = "K";
				} else {
					temp1 = Integer.toString(i + 1);
				}
				BufferedImage imgSample = sprite.getSprite(j, i);
				ImageIcon iconSample = new ImageIcon(imgSample.getScaledInstance(100, 200, imgSample.getType()));
				imageMap.put(temp1 + temp, iconSample);
			}
		}

		ArrayList<JLabel> sampleList = new ArrayList<JLabel>();

		JFrame mainFrame = new JFrame("Game");


		JFrame frame1 = new JFrame();
		JFrame frame2 = new JFrame();
		JFrame frame3 = new JFrame();
		JLabel label = new JLabel("Toilet Solitaire Game");
		JLabel end = new JLabel("Game Over");

		final String[] Score = {"Your Score is 4"};
		frame1.add(label);
		frame1.setLayout(new FlowLayout());
		frame1.setSize(500, 480);
		frame2.setLayout(new FlowLayout());
		frame2.setSize(500,450);
		//frame2.pack();
		frame3.setLayout(new FlowLayout());
		frame3.setSize(500, 480);
		final JLabel[] score = {new JLabel(Score[0])};
		frame2.add(score[0]);
		frame3.add(end);

		JButton button1 = new JButton("Start");
		Font font = new Font("Arial", Font.BOLD, 16);
		button1.setFont(font);

		final int[] count = {4};
		button1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				game.Start();
				frame1.setVisible(false);
				frame2.setVisible(true);
				System.out.println(game.getHandCards());
				frame2.add(score[0]);
				for(String temp:game.getHandCards()){
					JLabel lbl = new JLabel();
					lbl.setIcon(imageMap.get(temp));
					frame2.add(lbl);
					sampleList.add(lbl);
				}
				frame2.pack();
				frame2.invalidate();
				frame2.validate();

			}
		});


		frame1.add(button1);
		frame1.setVisible(true);



		JButton myButton = new JButton("ADD CARD");
		myButton.setFont(font);
		myButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Component[] components = frame2.getContentPane().getComponents();
				for(Component component:components){
					if(component instanceof JLabel)
					{
						frame2.remove(component);
					}
				}
				frame2.remove(score[0]);
				if(count[0]>51){
					frame2.setVisible(false);
					frame3.add(score[0]);
					if(game.getHandCards().size()<5){
						JLabel win = new JLabel("You Win");
						frame3.add(win);
					} else if (game.getHandCards().size()==0) {
						JLabel superwin = new JLabel("SuperWin");
						frame3.add(superwin);
					}else{
						JLabel lost = new JLabel("You Lost");
						frame3.add(lost);
					}
					frame3.setVisible(true);
				}else {
					game.addCard();
					count[0] = count[0] + 1;
					Score[0] = "Your Score " + String.valueOf(game.getHandCards().size());
					score[0] = new JLabel(Score[0]);
					frame2.add(score[0]);
					for (String temp : game.getHandCards()) {
						JLabel lb = new JLabel();
						lb.setIcon(imageMap.get(temp));
						frame2.add(lb);
					}
					frame2.pack();
					frame2.invalidate();
					frame2.validate();
					System.out.println(Score[0]);
				}

			}

		});

		JButton myButton1 = new JButton("Remove Pair");
		myButton1.setFont(font);
		myButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Component[] components = frame2.getContentPane().getComponents();
				for(Component component:components){
					if(component instanceof JLabel)
					{
						frame2.remove(component);
					}
				}

				frame2.remove(score[0]);
				game.removePair();
				Score[0] = "Your Score is "+String.valueOf(game.getHandCards().size());
				score[0] = new JLabel(Score[0]);
				frame2.add(score[0]);
				for(String temp:game.getHandCards()) {
					JLabel lb = new JLabel();
					lb.setIcon(imageMap.get(temp));
					frame2.add(lb);
				}
				frame2.pack();
				frame2.invalidate();
				frame2.validate();
			}
		});

		JButton myButton2 = new JButton("Remove Middle Two");
		myButton2.setFont(font);
		myButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Component[] components = frame2.getContentPane().getComponents();
				for(Component component:components){
					if(component instanceof JLabel)
					{
						frame2.remove(component);
					}
				}
				frame2.remove(score[0]);
				game.removeTwoPair();
				Score[0] = "Your Score is "+String.valueOf(game.getHandCards().size());
				score[0] = new JLabel(Score[0]);
				frame2.add(score[0]);
				for(String temp:game.getHandCards()) {
					JLabel lb = new JLabel();
					lb.setIcon(imageMap.get(temp));
					frame2.add(lb);
				}
				frame2.pack();
				frame2.invalidate();
				frame2.validate();
			}
		});

		JButton myButton3 = new JButton("Remove Four");
		myButton3.setFont(font);
		myButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Component[] components = frame2.getContentPane().getComponents();
				for(Component component:components){
					if(component instanceof JLabel)
					{
						frame2.remove(component);
					}
				}
				frame2.remove(score[0]);
				game.removeFourPair();
				Score[0] = "Your Score is "+String.valueOf(game.getHandCards().size());
				score[0] = new JLabel(Score[0]);
				frame2.add(score[0]);
				for(String temp:game.getHandCards()) {
					JLabel lb = new JLabel();
					lb.setIcon(imageMap.get(temp));
					frame2.add(lb);
				}
				frame2.pack();
				frame2.invalidate();
				frame2.validate();
			}
		});

		JButton myButton4 = new JButton("Remove House Cards");
		myButton4.setFont(font);
		myButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int super_count = 0;
				Component[] components = frame2.getContentPane().getComponents();
				for(Component component:components){
					if(component instanceof JLabel)
					{
						frame2.remove(component);
					}
				}
				frame2.remove(score[0]);
				game.removeHouseRule(super_count);
				super_count=super_count+1;
				Score[0] = "Your Score is "+String.valueOf(game.getHandCards().size());
				score[0] = new JLabel(Score[0]);
				frame2.add(score[0]);
				for(String temp:game.getHandCards()) {
					JLabel lb = new JLabel();
					lb.setIcon(imageMap.get(temp));
					frame2.add(lb);
					sampleList.add(lb);
				}
				frame2.pack();
				frame2.invalidate();
				frame2.validate();
			}
		});

		frame2.add(score[0]);
		frame2.add(myButton);
		frame2.add(myButton1);
		frame2.add(myButton2);
		frame2.add(myButton3);
		frame2.add(myButton4);
		frame3.add(score[0]);



	  }
}
