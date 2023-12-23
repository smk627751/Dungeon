package com.smk627751.dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dungeon {

	private void path(List<List<Integer>> list, int startX, int startY, int endX, int endY)
	{
		if(startX < endX)
		{
			while(true)
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
					startY++;
				}
				if(startY > endY)
				{
					startY--;
				}
			}
			while(true)
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
					startX++;
				}
				if(startX > endX)
				{
					startX--;
				}
			}
			
			}
		else
		{
			while(true)
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
					startX++;
				}
				if(startX > endX)
				{
					startX--;
				}
			}
			while(true)
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
					startY++;
				}
				if(startY > endY)
				{
					startY--;
				}
			}
		}
	}
	private int dungeon(char[][] room, int adX, int adY, int mX, int mY, int tX, int tY, int goldX, int goldY, List<List<Integer>> list)
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
		room[tX][tY] = 'T';
		room[goldX][goldY] = 'G';
		int adG = (Math.abs(adX - goldX) + Math.abs(adY - goldY));
		int mG = (Math.abs(mX - goldX) + Math.abs(mY - goldY));
		int startX = adX, startY = adY, endX = goldX, endY = goldY;
		
		if(adG <= mG)
		{
			path(list, startX, startY, endX, endY);
			return adG;
		}
		else
		{
			List<Integer> l = new ArrayList<>();
			l.add((startX + 1));
			l.add((startY + 1));
			if(!list.contains(l))
			{
				list.add(l);
			}
			path(list, startX, startY, tX, tY);
			path(list, tX, tY, endX, endY);
			adG = (Math.abs(adX - tX) + Math.abs(adY - tY)) + (Math.abs(tX - goldX) + Math.abs(tY - goldY));
			return adG;
		}
		
	}
	public static void main(String[] args) {
		Dungeon obj = new Dungeon();
		List<List<Integer>> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Dimensions of the dungeon(Row x Column): ");
		char[][] room = new char[sc.nextInt()][sc.nextInt()];
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
		sc.close();
		int min = obj.dungeon(room, adX, adY, mX, mY, tX, tY, goldX, goldY, list);
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
			System.out.print("Path: ");
			for(int i = 0; i < list.size() - 1; i++)
			{
				System.out.print("("+list.get(i).get(0)+","+list.get(i).get(1)+")->");
			}
			System.out.print("("+list.get(list.size() - 1).get(0)+","+list.get(list.size() - 1).get(1)+")");
		}
	}

}
