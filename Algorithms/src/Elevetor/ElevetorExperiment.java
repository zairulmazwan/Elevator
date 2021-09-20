package Elevetor;

import java.util.LinkedList;

public class ElevetorExperiment {
	
	static int currentLevel = 5;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList<Integer> levelList = new LinkedList<Integer>();
		levelList.add(4);
		levelList.add(1);
		levelList.add(8);
		//levelList.add(6);
		//levelList.add(4);
		//levelList.add(3);
		
		System.out.println("The elevator will go to these floors : "+levelList);
		try {
			FIFO(levelList);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
	
	
	public static void FIFO (LinkedList<Integer> floors) throws InterruptedException {
		
		System.out.println("The current floor is : "+currentLevel);
		long timeStart = System.currentTimeMillis();
		while(!floors.isEmpty()) {
			
			int l = floors.getFirst();
			
			while(l>currentLevel) {
				String string = String.format("%s", currentLevel);
				System.out.print(string);
			
					Thread.sleep(1000);
			
					currentLevel++;
			}
			
			while(l<currentLevel) {
				String string = String.format("%s", currentLevel);
				System.out.print(string);
				Thread.sleep(1000);
				currentLevel--;
			}
			System.out.println("\nYou have arrived level "+currentLevel);
			floors.removeFirst();
			Thread.sleep(2000);
		}
		
		long endtime = System.currentTimeMillis();
		double time = (endtime-timeStart)/1000;
		System.out.println("Duration : "+time+ " seconds");
	}

}
