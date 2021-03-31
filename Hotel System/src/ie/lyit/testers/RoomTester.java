package ie.lyit.testers;

import java.util.ArrayList;

import ie.lyit.hotel.Room;

public class RoomTester {

	public static void main(String[] args) {
		//single beds
		Room r1 = new Room(1,0,60,1);
		Room r2 = new Room(1,0,60,2);
		Room r3 = new Room(1,0,60,3);
		Room r4 = new Room(1,0,60,4);
		Room r5 = new Room(1,0,60,5);
		
		//double beds
		Room r6 = new Room(2,0,85,6);
		Room r7 = new Room(2,0,85,7);
		Room r8 = new Room(2,0,85,8);
		Room r9 = new Room(2,0,85,9);
		Room r10 = new Room(2,0,85,10);
		
		//family beds
		Room r11 = new Room(2,2,120,11);
		Room r12 = new Room(2,2,120,12);
		Room r13 = new Room(2,2,120,13);
		Room r14 = new Room(2,2,120,14);
		Room r15 = new Room(2,2,120,15);
		
		//add elements to array list
		ArrayList<Room> rooms = new ArrayList<Room>();
		rooms.add(r1);
		rooms.add(r2);
		rooms.add(r3);
		rooms.add(r4);
		rooms.add(r5);
		rooms.add(r6);
		rooms.add(r7);
		rooms.add(r8);
		rooms.add(r9);
		rooms.add(r10);
		rooms.add(r11);
		rooms.add(r12);
		rooms.add(r13);
		rooms.add(r14);
		rooms.add(r15);
		
		for(Room tempRoom:rooms)
			System.out.println(tempRoom);
	}

}
