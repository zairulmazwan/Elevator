package Elevetor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Elevetor {
	
	static int i=5;
	static int levelRequest=0;
	static LinkedList<Integer> levelList = new LinkedList<Integer>();
	
	public static void main(String[] args) throws InterruptedException {
	
		Thread t2 = new Thread() {
			@Override
			public void run() {
				Scanner input = new Scanner(System.in);
				System.out.println("Input a level to go : ");
				levelRequest = input.nextInt();
				System.out.println("You are going to level: "+levelRequest);
				levelList.add(levelRequest);
				
				while(levelRequest!=-1) {
					try {
						Fifo();
						System.out.println("Input a level to go : ");
						levelRequest = input.nextInt();
						if (levelRequest!=-1) {
							System.out.println("You are going to level: "+levelRequest);
							levelList.add(levelRequest);
						
						}
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				input.close();
				System.out.println("The elevator is temporary not in service!");
				
			}
		};
		t2.start();	
	}
	
	
	public static void Fifo() throws InterruptedException {
		
			if(!levelList.isEmpty()) {
				
				int level = levelList.getFirst();
				
				long start = System.currentTimeMillis();
				System.out.println("level request "+levelRequest);
				//System.out.println("i "+i);
				while (level>i) {
					String string = String.format("%s", i);
					System.out.print(string);
				
					Thread.sleep(1000);
					i++;
					
				}
				//System.out.println("XXX");
				while (level<i) {
					String string = String.format("%s", i);
					System.out.print(string);
				
					Thread.sleep(1000);
					i--;
				}
					System.out.println("You have arrived level "+levelRequest);
					levelList.removeFirst();
					Thread.sleep(2000);
				}	
			}	
			
	}





