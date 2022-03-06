package daily.ongoing.finished;

public class DayOfTheWeek_1185 {

    public static String run(int day, int month, int year) {

        //1971.0101=friday
        int years = year - 1971;
        String[] names = { "Thursday", "Friday", "Saturday","Sunday", "Monday", "Tuesday", "Wednesday"};
        int[] months= {31,28,31,30,31,30,31,31,30,31,30,31};
        int days = 0;
        for(int i=0;i<month-1;i++){
            days = months[i]+days;
        }
        days = days + day;

        days = days + 365 * years;

        for(int currYear=1971;currYear<=year;currYear++) {
            if ((currYear % 400 == 0) || (currYear % 4 == 0 && currYear % 100 != 0)) {
                if (currYear == year) {
                    if (month > 2 ) {
                        days++;
                    }
                } else {
                    days++;
                }

            }
        }
        return names[days % 7];

    }

}
