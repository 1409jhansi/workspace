package com.market;

import java.io.BufferedReader;
import java.io.FileReader;

public class WordCount {

	public static void main(String[] args) {

		try {

			// Open our comma separated lotto number file

			BufferedReader reader = new BufferedReader(new FileReader(
					"C:\\lottomax.csv"));

			// Create array to hold 50 digits, 0 through 49 (even though drawn
			// numbers are between 1 and 49 inclusive)

			int[] numbers = new int[50];

			// Initialize all counts to zero.

			for (int i = 0; i < 50; i++) {

				numbers[i] = 0;

			}

			// Read each line of the file and split the columns using the commas

			String draw;

			while ((draw = reader.readLine()) != null) {

				String[] pieces = draw.split(",");

				// For columns 4 through 10 we are going to take the number,
				// convert it to an integer

				// and use that integer as the index for our array. Increment
				// the count by 1 for that index.

				for (int j = 4; j <= 10; j++) {

					int drawnNumber = Integer.parseInt(pieces[j]);

					numbers[drawnNumber]++;

				}

			}

			reader.close();

			// Loop through array of counts to print them and their frequency.

			for (int i = 0; i < 50; i++) {

				System.out.println(i + ": " + numbers[i]);

			}

		} catch (Exception e) {

			System.out
					.println("There was a problem opening and processing the file.");

		}

	}

}
