package com.virtusa.test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberToWordConverter {

	public static void main(String[] args) {
		
		String inputNum = "567534563";
		StringBuffer numInWord = new StringBuffer();
		System.out.println("Input Numer: " + inputNum);
		
		String numPart1 = "";
		String numPart2 = "";
		String numPart3 = "";
		
		int numLenght = inputNum.length();
		
		if(numLenght > 9) {
			
			System.out.println("Invalid range of number");
			
		} else if(numLenght > 6 && numLenght <= 9) {
			
			numPart1 = inputNum.substring(0, numLenght-6);
			numPart2 = inputNum.substring(numLenght-6, numLenght-3);
			numPart3 = inputNum.substring(numLenght-3);
			
		} else if(numLenght > 3 && numLenght <= 6) {
			
			numPart2 = inputNum.substring(0, numLenght-3);
			numPart3 = inputNum.substring(numLenght-3);
			
		} else {
			numPart3 = inputNum;
		}
		
		if (!numPart1.isEmpty()) {
			numInWord.append(getWord(numPart1)  + " Million ");
			
		}
		
		if (!numPart2.isEmpty()) {
			
			numInWord.append(getWord(numPart2) + " Thousand ");
			
		}
		
		
		numInWord.append(getWord(numPart1));
		
		System.out.println("The Number in words is: " + numInWord.toString());
	}
	
	/*
	 * 
	 */
	private static String getWord(String Part) {
		
		StringBuffer s = new StringBuffer();
		for(int i=0; i<Part.length(); i++) {
			String digit = Part.substring(i,i+1);
			if(Part.length() == 3 && i==0) {
				s.append(" " + getWordDigit(digit) + " Hundered ");
			} else if (i==1 && !digit.equals("1")){
				s.append(" " + tenthWord(digit));
			} else if (i==1 && digit.equals("1")){
				s.append(" " + tenToNinteen(digit));
			} else {
				s.append(" " + getWordDigit(digit));
			}
		}
		
		return s.toString();
		
	}
	
	
	private static String getWordDigit(String digit) {
		Map wordMap = new HashMap();
		wordMap.put("1", "One");
		wordMap.put("2", "Two");
		wordMap.put("3", "Three");
		wordMap.put("4", "Four");
		wordMap.put("5", "Five");
		wordMap.put("6", "Six");
		wordMap.put("7", "Seven");
		wordMap.put("8", "Eight");
		wordMap.put("9", "Nine");
		wordMap.put("10", "Ten");
		
		return (String)wordMap.get(digit);
	}
	
	private static String tenthWord(String digit) {
		Map wordMap = new HashMap();
		wordMap.put("2", "Twenty");
		wordMap.put("3", "Thirty");
		wordMap.put("4", "Fourty");
		wordMap.put("5", "Fifty");
		wordMap.put("6", "Sixty");
		wordMap.put("7", "Seventy");
		wordMap.put("8", "Eighty");
		wordMap.put("9", "Ninety");
		
		return (String)wordMap.get(digit);
	}
	
	private static String tenToNinteen(String digit) {
		Map wordMap = new HashMap();
		wordMap.put("11", "Eleven");
		wordMap.put("12", "Tweleve");
		wordMap.put("13", "Thirteen");
		wordMap.put("14", "Fourteen");
		wordMap.put("15", "Fifteen");
		wordMap.put("16", "Sixteen");
		wordMap.put("17", "Seventeen");
		wordMap.put("18", "Eighteen");
		wordMap.put("19", "Nineteen");
		
		return (String)wordMap.get(digit);
	}

}
