package cupidQuiz;

import java.util.ArrayList;
import java.util.Scanner;

public class cupidQuizDriver {
	public static void main(String[] args) {

		System.out.println("Hello. Welcome to The cupidQuiz. " + "Press a to begin.");

		Scanner scan = new Scanner(System.in);
//--------------------------------------------------------------------------------------
//stupid check

		int score = 0;
		// Person 1
		String name1 = "x", perfectDate1 = "x", dinner1 = "x", dwarf1 = "x", color1 = "x", pet1 = "x", princess1 = "x";

		// Person 2
		String name2 = "x", perfectDate2 = "x", dinner2 = "x", dwarf2 = "x", color2 = "x", pet2 = "x", princess2 = "x";

		// arrays
		String[] P1Array = new String[6];
		String[] P2Array = new String[6];
		String[] ContentsSub = { "the", "i", "go", "would", "for", "my", "favorite", " is ", "color", "animal",
				"perfect", "date", "be", "then", "probably", "going", "a", "and", "or", "in", "want", "to", "maybe",
				"at", "with", "side", "of", "get", "like", "on", "eat", "some", "?", ".", ",", "s", "say", "eating",
				"i", "love", "ed" };

		System.out.println("line 30");
		// scan in first person
		String start;
		start = scan.nextLine();
		System.out.println("Please answer every question in a complete sentence.");
		if (start.compareTo("a") == 0) {

			System.out.println("Please enter your name");
			name1 = scan.nextLine();

			System.out.println("What is your perfect date?");
			perfectDate1 = scan.nextLine();

			System.out.println("What is your perfect dinner? ");
			dinner1 = scan.nextLine();

			System.out.println("What is your favorite dwarf from snow white?");
			dwarf1 = scan.nextLine();

			System.out.println("What is your favorite color?");
			color1 = scan.nextLine();

			System.out.println("What is your favorite animal?");
			pet1 = scan.nextLine();

			System.out.println("What is your favorite disney princess?");
			princess1 = scan.nextLine();

			// System.out.println(name1+perfectDate1+dinner1+dwarf1+color1+pet1+princess1);
			System.out.println("line 60");
			//System.out.println("Hit Enter");

			P1Array[0] = perfectDate1.toLowerCase();
			P1Array[1] = dinner1.toLowerCase();
			P1Array[2] = dwarf1.toLowerCase();
			P1Array[3] = color1.toLowerCase();
			P1Array[4] = pet1.toLowerCase();
			P1Array[5] = princess1.toLowerCase();

			System.out.println(" line 69");
			
			
			
			
			
			for (String P1 : P1Array) {
				System.out.println(" inside for P1");
				for (String C : ContentsSub) {
					System.out.println("inside for C");
					while (P1.indexOf(C) >= 0) {
						System.out.println(" inside while C exists");
						if ((P1.indexOf(C) >= 1)) {
							if(((P1.length()-C.length())) >= (P1.indexOf(C))) {
								System.out.println(" inside nested if ");
								P1 = P1.substring(0, P1.indexOf(C)+1)
										+ P1.substring((P1.indexOf(C) + (C.length())-1), P1.length());
								System.out.println(P1);
							} else {
								System.out.println(" inside nested else ");
								P1 = P1.substring(0, P1.indexOf(C)+1)
										+ P1.substring((P1.indexOf(C) + (C.length())-1), P1.length());
								System.out.println(P1);
							}
						} else if (P1.indexOf(C) == 0) {
							System.out.println("inside else");
							P1 = P1.substring(((C.trim()).length()),(P1.length()));
						} // end of nested if else
					} // end of for compacting string through substring
				} // end of for loop
				System.out.println(P1);
			} // end of while loop
		} // end of if 1st person
		System.out.println("line 84");
// start of 2nd person
		String start2;
		System.out.println("Please pass your device to the next player," + " then press a to begin.");
		start2 = scan.nextLine();
		if (start2.compareTo("a") == 0) {
			System.out.println("Please enter your name");
			name2 = scan.nextLine();
			System.out.println("What is your perfect date?");
			perfectDate2 = scan.nextLine();
			System.out.println("What is your perfect dinner?");
			dinner2 = scan.nextLine();
			System.out.println("What is your favorite dwarf from snow white?");
			dwarf2 = scan.nextLine();
			System.out.println("What is your favorite color?");
			color2 = scan.nextLine();
			System.out.println("What is your favorite animal?");
			pet2 = scan.nextLine();
			System.out.println("What is your favorite disney princess?");
			princess2 = scan.nextLine();

//fill array2 with trimmed questions
//one question
			P2Array[0] = perfectDate2.toLowerCase().trim();
			P2Array[1] = dinner2.toLowerCase().trim();
			P2Array[2] = dwarf2.toLowerCase().trim();
			P2Array[3] = color2.toLowerCase().trim();
			P2Array[4] = pet2.toLowerCase().trim();
			P2Array[5] = princess2.toLowerCase().trim();

//checking if the array has any of the designated bland words 
//that can be removed from the array before separating it 
//ATM all words in one question, in one position
			for (String P2 : P2Array) {
				for (String x : ContentsSub) {
					while (P2.indexOf(x) >= 0) {
						if (P2.indexOf(x) >= 0) {
							if (P2.indexOf(x) > 1) {
								P2 = P2.substring(0, P2.indexOf(x))
										+ P2.substring((P2.indexOf(x) + (x.length() - 1)), P2.length());
							} else if (P2.indexOf(x) <= 1) {
								P2 = P2.substring((P2.indexOf(x.trim()) + (x.length() - 1)), P2.length());
							} // end of nested if else
						} // end of if statement
					} // end of for compacting string through substring
				} // end of for loop
//				System.out.println(P2);
			} // end of while loop
		} // end of if 2nd person

//stores each word separately in a different index in the array 
//selectArray1 and selectArray2 
		//our x player values are the total count
		int xP1 = 0;
		int xP2 = 0;
		int c = 0;
		int i = 0;
		for(String p: P1Array) {
			xP1 += countWords(p);
		}// end of for loop 
		for(String p: P2Array) {
			xP2 += countWords(p);
		}// end of for loop 
		String[] selectArray1 = new String[xP1];
		String[] selectArray2 = new String[xP2];
		
		for (String p1 : P1Array) {
			while (p1.indexOf(" ") > 0) {
				selectArray1[c] = p1.substring(0, (p1.indexOf(" ")));
				p1 = p1.substring(p1.indexOf(" "), p1.length() + 1);
				c++;
			} // end of while loop
		} // end of for loop
		for (String p2 : P2Array) {
			while (p2.indexOf(" ") > 0) {
				selectArray2[i] = p2.substring(0, (p2.indexOf(" ") - 1));
				p2 = p2.substring(p2.indexOf(" "), p2.length() + 1);
				i++;
			} // end of while loop
		} // end of for loop

//printing array contents		
		System.out.println("array 1");
		for (String a : selectArray1) {
			System.out.print(a + ", ");
		}
		System.out.println("array 2");
		for (String a : selectArray2) {
			System.out.print(a + ", ");
		}

//cross referencing arrays
		for (String d1 : selectArray1) {
			for (String d2 : selectArray2) {
				if (d1.equals(d2)) {
					score += 1;
				} // end of if statement
			} // end of for loop player 2
		} // end of for loop player 1

//print scores
		System.out.println("score = " + score);

	}// end of main

//Tester Method
	public static int countWords(String s) {

		int wordCount = 0;

		boolean word = false;
		int endOfLine = s.length() - 1;

		for (int i = 0; i < s.length(); i++) {
			if (Character.isLetter(s.charAt(i)) && i != endOfLine) {
				word = true;
			} else if (!Character.isLetter(s.charAt(i)) && word) {
				wordCount++;
				word = false;
			} else if (Character.isLetter(s.charAt(i)) && i == endOfLine) {
				wordCount++;
			}
		}
		return wordCount;
	}
}// end of class
