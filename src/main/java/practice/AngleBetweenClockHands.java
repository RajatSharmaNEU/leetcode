package practice;

public class AngleBetweenClockHands {

    public static int calculateAngle(int hours, int minutes) {
        if(hours == 12) {
            hours = 0;
        }

        if(minutes == 60) {
            hours = hours +1;
            minutes = 0;
        }

        // For full round
        // Minute hand take 360 degree in every hour ==> 60 minutes for 360 degree ==>  In 1 minute, minute hand move 6 degree
        // Hour hand take 360 degree in 12 hours ==> 12 * 60 minutes for 360 degree ==> In 1 minute, hour hand move 0.5 degree
        // But hour hand also need to consider intermediate minutes
        // total minutes, corresponding to hours will be (hours * 60 + minutes) ==> total minutes * 0.5;

        // Total minutes passed since 12 or 0 hours --> (hours * 60 + minutes);
        int hourAngle = (int)(0.5 * (hours * 60 + minutes));
        int minuteAngle = minutes * 6;

        return Math.abs(hourAngle-minuteAngle);
    }

    public static void main(String[] args) {
        System.out.println(calculateAngle(12, 30));
        System.out.println(calculateAngle(3, 30));
    }
}
