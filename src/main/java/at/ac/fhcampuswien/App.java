package at.ac.fhcampuswien;

import java.util.Random;
import java.util.Scanner;

public class App {

    // Implement all methods as public static
    public static void oneMonthCalendar(int numberOfDaysInMonth, int firstWeekdayOfMonth){
        int[] allowedNumberOfDaysInMonth = {28,30,31};
        final int  MIN_WEEKDAY = 1;
        final int MAX_WEEKDAY = 7;

        StringBuilder LineOfCalender = new StringBuilder();
        final char dateSeparator = ' ';
        final char bufferForOneDigitDates = ' ';
        final String noDate = "  ";

        // Bei ungültiger Eingabe der Tage in einem Monat wird das Programm abgebrochen
        if (numberOfDaysInMonth != allowedNumberOfDaysInMonth[0] &&
                numberOfDaysInMonth != allowedNumberOfDaysInMonth[1] &&
                numberOfDaysInMonth != allowedNumberOfDaysInMonth[2] ){
            return;
        }
        // Bei ungültiger Eingabe des Wochentags wird das Programm abgebrochen
        if(firstWeekdayOfMonth <= MIN_WEEKDAY || firstWeekdayOfMonth >= MAX_WEEKDAY){
            return;
        }

        int currentWeekDay = 1;
        // Variable wird verwendet, um auch in der Schleife die "Leeren" Tage anzuzeigen.
        int startValueOfOutputLoop = 2 - firstWeekdayOfMonth;
        for (int currentDate = startValueOfOutputLoop  ; currentDate <= numberOfDaysInMonth ; currentDate++,currentWeekDay++ ){

            if (currentDate <= 0){
                LineOfCalender.append(noDate);
            } else {
                if(currentDate < 10) LineOfCalender.append(bufferForOneDigitDates);
                LineOfCalender.append(currentDate);
            }

            // Datumstrennung einsetzten.
            LineOfCalender.append(dateSeparator);

            if(currentWeekDay == MAX_WEEKDAY || currentDate == numberOfDaysInMonth){
                System.out.println(LineOfCalender);
                // String "ausleeren"
                LineOfCalender.setLength(0);
                currentWeekDay = 0;
            }
        }
    }

    public static long[] lcg(long seed){
        final long MODUL = (long) Math.pow(2,31);
        final short INCREMENT = 12345;
        final int FACTOR = 1103515245;

        long[] pseudoRandomNumbers = new long[10];

        for (int i = 0 ; i <= 9 ; i++){
            if(i==0)    pseudoRandomNumbers[i] = (FACTOR * seed + INCREMENT) % MODUL;
            else        pseudoRandomNumbers[i] = (FACTOR * pseudoRandomNumbers[i-1] + INCREMENT) % MODUL;
        }
        return pseudoRandomNumbers;
    }

    public static void guessingGame(int numberToGuess){
        Scanner scanner = new Scanner(System.in);

        int numberOfGuesses = 1;
        do {
            System.out.print("Guess number " + numberOfGuesses + ": ");
            int currentGuess = scanner.nextInt();

            if (currentGuess == numberToGuess){
                System.out.println("You won wisenheimer!");
                return;
            }
            if (currentGuess < numberToGuess)  System.out.println("The number AI picked is higher than your guess.");
            else if(numberOfGuesses != 10){
                System.out.println("The number AI picked is lower than your guess.");
            }

            numberOfGuesses ++;
        } while (numberOfGuesses <= 10);
        System.out.println("You lost! Have you ever heard of divide & conquer?");
    }

    public static int randomNumberBetweenOneAndHundred(){
        Random rnd = new Random();
        // Man muss "1" addieren, sonst sind die Zahlen von 0 bis 99
        return (rnd.nextInt(100) + 1);
    }

    public static boolean swapArrays(int[] arrayOne, int[] arrayTwo){
        if (arrayOne.length != arrayTwo.length) return false;
        for (int i = 0 ; i < arrayOne.length ; i++){
            int temp = arrayOne[i];
            arrayOne[i] = arrayTwo[i];
            arrayTwo[i] = temp;
        }
        return true;
    }
    public static String camelCase(String originalText){
        char[] originalTextArray = originalText.toCharArray();
        StringBuilder camelCaseText = new StringBuilder();

        final char SPACE = 32;
        final char UPPERCASE_A = 65;
        final char UPPERCASE_Z = 90;
        final char LOWERCASE_A = 97;
        final char LOWERCASE_Z = 122;

        final boolean SWITCH_TO_LOWER_CASE = false;
        final boolean SWITCH_TO_UPPER_CASE = true;

        boolean nextLetterStartsWord = true;

        for (char c : originalTextArray) {
            // Leerzeichen führen dazu, dass der nächste Buchstabe groß geschrieben wird.
            if (c == SPACE) nextLetterStartsWord = true;

            else if (c >= UPPERCASE_A && c <= UPPERCASE_Z) {
                // Bei Großbuchstaben wird kontrolliert, ob gerade ein Wort beginnt. Je nachdem wird es groß oder klein geschrieben.
                if (nextLetterStartsWord) {
                    camelCaseText.append(c);
                    nextLetterStartsWord = false;
                } else camelCaseText.append(switchCaseOfLetter(c, SWITCH_TO_LOWER_CASE));

            } else if (c >= LOWERCASE_A && c <= LOWERCASE_Z) {
                // Bei Kleinbuchstaben wird kontrolliert, ob gerade ein Wort beginnt. Je nachdem wird es groß oder klein geschrieben.
                if (nextLetterStartsWord) {
                    camelCaseText.append(switchCaseOfLetter(c, SWITCH_TO_UPPER_CASE));
                    nextLetterStartsWord = false;
                } else camelCaseText.append(c);
            }
        }
        return camelCaseText.toString();
    }

    private static char switchCaseOfLetter(char letterToSwitch, boolean switchToUpperCase){
        final int NUMERICAL_SEPARATOR_OF_LOWER_AND_UPPER_CASE_LETTERS_IN_ASCII = 32;

        if (switchToUpperCase)
            return (char)(letterToSwitch - NUMERICAL_SEPARATOR_OF_LOWER_AND_UPPER_CASE_LETTERS_IN_ASCII);
        else
            return (char)(letterToSwitch + NUMERICAL_SEPARATOR_OF_LOWER_AND_UPPER_CASE_LETTERS_IN_ASCII);
    }

    public static int checkDigit(int[] digits){
        int sum = 0;
        if (digits.length >= 10) return -1;
        for (int i = 0 ; i<digits.length; i++){
            sum += digits[i] * (i + 2);
        }
        int result = 11 - (sum % 11);
        if(result == 10) return 0;
        if(result == 11) return 5;
        return result;
    }


    public static void main(String[] args) {

        // Task 1 - Test
            // App.oneMonthCalendar(31,6);

        // Task 2 - Test
            // long[] test = App.lcg(0);
            // for (int i=0;i < test.length ; i++ ){
            //     System.out.println(test[i]);
            // }

        // Task 3
            // App.guessingGame(randomNumberBetweenOneAndHundred());


    }
}