package com.smk627751.dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dungeon {
	private void leftPath(List<List<Integer>> list, int[][] room, int startX, int startY, int endX, int endY)
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
				if(room[startX][startY + 1] != 'P')
				startY++;
				
				else if(room[startX - 1][startY] != 'P')
				startX--;
				
				else if(room[startX + 1][startY] != 'P')
				startX++;
			}
			if(startY > endY)
			{
				if(room[startX][startY - 1] != 'P')
				startY--;
				
				else if(room[startX - 1][startY] != 'P')
				startX--;
				
				else if(room[startX + 1][startY] != 'P')
				startX++;
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
				if(startX + 1 < room.length && room[startX + 1][startY] != 'P')
				startX++;
				
				else if(startY + 1 < room[0].length && room[startX][startY + 1] != 'P')
				startY++;
				
				else if(startY - 1 >= 0 && room[startX][startY - 1] != 'P')
				startY--;
			}
			if(startX > endX)
			{
				if(startX - 1 >= 0 && room[startX - 1][startY] != 'P')
				startX--;
				
				else if(startY + 1 < room[0].length && room[startX][startY + 1] != 'P')
				startY++;
				
				else if(startY - 1 >= 0 && room[startX][startY - 1] != 'P')
				startY--;
			}
		}
		
	}
	
	private void rightPath(List<List<Integer>> list, int[][] room, int startX, int startY, int endX, int endY)
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
				if(startX + 1 < room.length && room[startX + 1][startY] != 'P')
					startX++;
					
				else if(startY + 1 < room[0].length && room[startX][startY + 1] != 'P')
				startY++;
				
				else if(startY - 1 >= 0 && room[startX][startY - 1] != 'P')
				startY--;
			}
			if(startX > endX)
			{
				if(startX - 1 >= 0 && room[startX - 1][startY] != 'P')
					startX--;
					
				else if(startY + 1 < room[0].length && room[startX][startY + 1] != 'P')
				startY++;
				
				else if(startY - 1 >= 0 && room[startX][startY - 1] != 'P')
				startY--;
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
					
				else if(startX - 1 >= 0 && room[startX - 1][startY] != 'P')
				startX--;
				
				else if(startX + 1 < room.length && room[startX + 1][startY] != 'P')
				startX++;
			}
			if(startY > endY)
			{
				if(startY - 1 >= 0 && room[startX][startY - 1] != 'P')
					startY--;
					
				else if(startX - 1 >= 0 && room[startX - 1][startY] != 'P')
				startX--;
				
				else if(startX + 1 < room.length && room[startX + 1][startY] != 'P')
				startX++;
			}
		}
	}
	private void path(List<List<Integer>> list, int[][] room, int startX, int startY, int endX, int endY)
	{
		if((startX + 1 < room.length && room[startX + 1][startY] == 'P') || (startX - 1 >= 0 && room[startX - 1][startY] == 'P') 
				|| (startY + 1 < room[0].length && room[startX][startY + 1] == 'P') || (startY - 1 >= 0 && room[startX][startY - 1] == 'P'))
		{
			return;
		}
		if(startX < endX)
		{
			leftPath(list, room, startX, startY, endX, endY);
		}
		else
		{
			rightPath(list, room, startX, startY, endX, endY);
		}
	}
	
	private void dungeon(int[][] room, int adX, int adY, int goldX, int goldY, List<List<Integer>> list)
	{
		
		if((adX < 0 || adY > room[0].length) || (adY < 0 || adY > room.length))
		{
			System.out.println("Adventurer is outside the room");
			return;
		}
		if((goldX < 0 || goldY > room[0].length) || (goldY < 0 || goldY > room.length))
		{
			System.out.println("gold is outside the room");
			return;
		}
		room[adX][adY] = 'A';
		room[goldX][goldY] = 'G';
		
		int startX = adX, startY = adY, endX = goldX, endY = goldY;

		path(list, room, startX, startY, endX, endY);
		
	}
	public static void main(String[] args) {
		Dungeon obj = new Dungeon();
		List<List<Integer>> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Dimensions of the dungeon(Row x Column): ");
		int[][] room = new int[sc.nextInt()][sc.nextInt()];
		System.out.println("Position of adventurer: ");
		int adX = sc.nextInt() - 1;
		int adY = sc.nextInt() - 1;
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
		sc.close();
		obj.dungeon(room, adX, adY, goldX, goldY,list);
		int min = list.size() - 1;
		if(min <= 0)
		{
			System.out.println("No possible solution");
		}
		else
		{
			System.out.println("Minimum number of steps: "+ min);
			System.out.print("Path: ");
			for(int i = 0; i < list.size() - 1; i++)
			{
				System.out.print("("+list.get(i).get(0)+","+list.get(i).get(1)+")->");
			}
			System.out.print("("+list.get(min).get(0)+","+list.get(min).get(1)+")");
		}
	}

}
