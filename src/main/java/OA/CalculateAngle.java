package OA;

public class CalculateAngle {
    private void getAngle(int hours, int minutes) {
        // In one minute, minute needle moves ~ 6 degree, hours moves 0.5 degree

        int totalMinutes = (hours * 60) + minutes;
        double hourAngle = (totalMinutes % 360) * 0.5;
        double minuteAngle = (totalMinutes % 60) * 6;

        System.out.println(Math.abs(hourAngle - minuteAngle));
    }

    public static void main(String[] args) {
        CalculateAngle calculateAngle = new CalculateAngle();
        calculateAngle.getAngle(12, 30);
        calculateAngle.getAngle(3, 30);
    }
}
