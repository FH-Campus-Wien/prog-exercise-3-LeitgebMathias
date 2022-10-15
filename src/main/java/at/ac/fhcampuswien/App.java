package at.ac.fhcampuswien;

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




    public static void main(String[] args) {

        // Task 1
        // App.oneMonthCalendar(31,6);

        /* Task 2
            long[] test = App.lcg(0);
            for (int i=0;i < test.length ; i++ ){
                System.out.println(test[i]);
            }
        */


    }
}