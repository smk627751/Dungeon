package com.smk627751.dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dungeon {
	private void leftPath(List<List<Integer>> list, int[][] room, boolean isMonster, int startX, int startY, int endX, int endY)
	{
		while(startY < room[0].length)
		{
			List<Integer> l = new ArrayList<>();
			l.add((startX + 1));
			l.add((startY + 1));
			if(!list.contains(l))
			{
				list.add(l);
			}
			if(startY == endY)
			{
				break;
			}
			if(startY < endY)
			{
				if(isMonster || room[startX][startY + 1] != 'P')
				startY++;
				
				else if(room[startX + 1][startY] != 'P')
				startX++;
				
				else if(room[startX - 1][startY] != 'P')
				startX--;
				
				else return;
			}
			if(startY > endY)
			{
				if(isMonster || room[startX][startY - 1] != 'P')
				startY--;
				
				else if(room[startX + 1][startY] != 'P')
				startX++;
				
				else if(room[startX - 1][startY] != 'P')
				startX--;
				
				else return;
			}
		}
		while(startX < room.length)
		{
			List<Integer> l = new ArrayList<>();
			l.add((startX + 1));
			l.add((startY + 1));
			if(!list.contains(l))
			{
				list.add(l);
			}
			if(startX == endX)
			{
				break;
			}
			if(startX < endX)
			{
				if(isMonster || startX + 1 < room.length && room[startX + 1][startY] != 'P')
				startX++;
				
				else if(startY + 1 < room[0].length && room[startX][startY + 1] != 'P')
				startY++;
				
				else if(startY - 1 >= 0 && room[startX][startY - 1] != 'P')
				startY--;
				
				else return;
			}
			if(startX > endX)
			{
				if(isMonster || startX - 1 >= 0 && room[startX - 1][startY] != 'P')
				startX--;
				
				else if(startY + 1 < room[0].length && room[startX][startY + 1] != 'P')
				startY++;
				
				else if(startY - 1 >= 0 && room[startX][startY - 1] != 'P')
				startY--;
				
				else return;
			}
		}
		
	}
	
	private void rightPath(List<List<Integer>> list, int[][] room, boolean isMonster, int startX, int startY, int endX, int endY)
	{
		while(startX < room.length)
		{
			List<Integer> l = new ArrayList<>();
			l.add((startX + 1));
			l.add((startY + 1));
			if(!list.contains(l))
			{
				list.add(l);
			}
			if(startX == endX)
			{
				break;
			}
			if(startX < endX)
			{
				if(isMonster || startX + 1 < room.length && room[startX + 1][startY] != 'P')
					startX++;
					
				else if(startY + 1 < room[0].length && room[startX][startY + 1] != 'P')
				startY++;
				
				else if(startY - 1 >= 0 && room[startX][startY - 1] != 'P')
				startY--;
				
				else return;
			}
			if(startX > endX)
			{
				if(isMonster || startX - 1 >= 0 && room[startX - 1][startY] != 'P')
					startX--;
					
				else if(startY + 1 < room[0].length && room[startX][startY + 1] != 'P')
				startY++;
				
				else if(startY - 1 >= 0 && room[startX][startY - 1] != 'P')
				startY--;
				
				else return;
			}
		}
		while(startY < room[0].length)
		{
			List<Integer> l = new ArrayList<>();
			l.add((startX + 1));
			l.add((startY + 1));
			if(!list.contains(l))
			{
				list.add(l);
			}
			if(startY == endY)
			{
				break;
			}
			if(startY < endY)
			{
				if(startY + 1 < room[0].length &&room[startX][startY + 1] != 'P')
				startY++;
					
				else if(startX + 1 < room.length && room[startX + 1][startY] != 'P')
				startX++;
				
				else if(startX - 1 >= 0 && room[startX - 1][startY] != 'P')
				startX--;
				
				else return;
			}
			if(startY > endY)
			{
				if(startY - 1 >= 0 && room[startX][startY - 1] != 'P')
				startY--;
				
				else if(startX + 1 < room.length && room[startX + 1][startY] != 'P')
				startX++;
				
				else if(startX - 1 >= 0 && room[startX - 1][startY] != 'P')
				startX--;
				
				else return;
			}
		}
	}
	private void path(List<List<Integer>> list, int[][] room, boolean isMonster, int startX, int startY, int endX, int endY)
	{
		if(startX < endX)
		{
			leftPath(list, room, isMonster, startX, startY, endX, endY);
		}
		else
		{
			rightPath(list, room, isMonster, startX, startY, endX, endY);
		}
	}
	
	private void dungeon(int[][] room, boolean isMonster, int startX, int startY, int endX, int endY, List<List<Integer>> list)
	{
		
		if((startX < 0 || startY > room[0].length) || (startY < 0 || startY > room.length))
		{
			System.out.println("Adventurer is outside the room");
			return;
		}
		if((endX < 0 || endY > room[0].length) || (endY < 0 || endY > room.length))
		{
			System.out.println("gold is outside the room");
			return;
		}

		path(list, room, isMonster, startX, startY, endX, endY);
		
	}
	public static void main(String[] args) {
		Dungeon obj = new Dungeon();
		List<List<Integer>> adPath = new ArrayList<>();
		List<List<Integer>> mPath = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Dimensions of the dungeon(Row x Column): ");
		int[][] room = new int[sc.nextInt()][sc.nextInt()];
		System.out.println("Position of adventurer: ");
		int adX = sc.nextInt() - 1;
		int adY = sc.nextInt() - 1;
		System.out.println("Position of Monster: ");
		int mX = sc.nextInt() - 1;
		int mY = sc.nextInt() - 1;
		System.out.println("Position of Trigger: ");
		int tX = sc.nextInt() - 1;
		int tY = sc.nextInt() - 1;
		System.out.println("Position of gold: ");
		int goldX = sc.nextInt() - 1;
		int goldY = sc.nextInt() - 1;
		System.out.println("Enter the number of pits: ");
		int pits = sc.nextInt();
		for(int i = 0; i < pits; i++)
		{
			System.out.println("Position of pit "+(i + 1)+": ");
			room[sc.nextInt() - 1][sc.nextInt() - 1] = 'P';
		}
		room[adX][adY] = 'A';
		room[goldX][goldY] = 'G';
		room[mX][mY] = 'M';
		sc.close();
		obj.dungeon(room, false, adX, adY, goldX, goldY,adPath);
		obj.dungeon(room, true, mX, mY, goldX, goldY, mPath);
		int adMin = adPath.size() - 1;
		int mMin = mPath.size() - 1;
		
		if(adMin <= mMin)
		{
			System.out.println("Minimum number of steps: "+ adMin);
			
			System.out.print("Adventurer Path: ");
			for(int i = 0; i < adPath.size() - 1; i++)
			{
				System.out.print("("+adPath.get(i).get(0)+","+adPath.get(i).get(1)+")->");
			}
			System.out.print("("+adPath.get(adMin).get(0)+","+adPath.get(adMin).get(1)+")\n");
			
			System.out.print("Monster Path: ");
			for(int i = 0; i < mPath.size() - 1; i++)
			{
				System.out.print("("+mPath.get(i).get(0)+","+mPath.get(i).get(1)+")->");
			}
			System.out.print("("+mPath.get(mMin).get(0)+","+mPath.get(mMin).get(1)+")");
		}
		
		else
		{
			adPath.clear();
			mPath.clear();
			obj.dungeon(room, false, adX, adY, tX, tY,adPath);
			obj.dungeon(room, false, tX, tY, goldX, goldY,adPath);
			
			adMin = adPath.size() - 1;
			System.out.println("Minimum number of steps: "+ adMin);
			
			System.out.print("Adventurer Path: ");
			for(int i = 0; i < adPath.size() - 1; i++)
			{
				System.out.print("("+adPath.get(i).get(0)+","+adPath.get(i).get(1)+")->");
			}
			System.out.print("("+adPath.get(adMin).get(0)+","+adPath.get(adMin).get(1)+")\n");
		}
	}

}
