package com.smk627751.dungeon;

import java.util.Scanner;

public class Dungeon {

	private int dungeon(char[][] room, int adX, int adY, int mX, int mY, int goldX, int goldY)
	{
		if((adX < 0 || adY > room[0].length) || (adY < 0 || adY > room.length))
		{
			System.out.println("Adventurer is outside the room");
			return 0;
		}
		if((goldX < 0 || goldY > room[0].length) || (goldY < 0 || goldY > room.length))
		{
			System.out.println("gold is outside the room");
			return 0;
		}
		room[adX][adY] = 'A';
		room[mX][mY] = 'M';
		room[goldX][goldY] = 'G';
		int adG = (Math.abs(adX - goldX) + Math.abs(adY - goldY));
		int mG = (Math.abs(mX - goldX) + Math.abs(mY - goldY));
		if(adG <= mG)
		{
			return adG;
		}
		return 0;
	}
	public static void main(String[] args) {
		Dungeon obj = new Dungeon();
		Scanner sc = new Scanner(System.in);
		System.out.println("Dimensions of the dungeon(Row x Column): ");
		char[][] room = new char[sc.nextInt()][sc.nextInt()];
		System.out.println("Position of adventurer: ");
		int adX = sc.nextInt() - 1;
		int adY = sc.nextInt() - 1;
		System.out.println("Position of Monster: ");
		int mX = sc.nextInt() - 1;
		int mY = sc.nextInt() - 1;
		System.out.println("Position of gold: ");
		int goldX = sc.nextInt() - 1;
		int goldY = sc.nextInt() - 1;
		sc.close();
		int min = obj.dungeon(room, adX, adY, mX, mY, goldX, goldY);
		for(char[] a: room)
		{
			for(char n : a)
			{
				System.out.print(n+" ");
			}
			System.out.println();
		}
		if(min == 0)
		{
			System.out.println("No possible solution");
		}
		else
		{
			System.out.println("Minimum number of steps: "+ min);
		}
	}

}
