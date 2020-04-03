package netflix.app;

public class Helper {
    public static double getPercentage(double part, double total) {
        return Math.round(part * 100 / total);
    }

    public static double getPercentage(int part, int total) {
        return Math.round((double)part * 100 / total);
    }

    public static double getPartFromPercentage(double percent, double total) {
        return ((percent * total) / 100);
    }
}
