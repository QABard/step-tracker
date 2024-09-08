public class Converter {
    private static final double STEP_LENGTH_KM = 0.00075;
    private static final double STEP_KCALS = 0.05;
    double convertToKm(int steps) {
        return steps * STEP_LENGTH_KM;
    }
    double convertStepsToKilocalories(int steps) {
        return steps * STEP_KCALS;
    }


}
