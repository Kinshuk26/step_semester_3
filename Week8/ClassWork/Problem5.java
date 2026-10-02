import java.util.*;

public class Problem5 {
    private interface Transport {
        String type();
        double calculateFare();
    }

    private static class Bus implements Transport {
        private final double distance;

        Bus(double distance) {
            this.distance = distance;
        }

        public String type() {
            return "BUS";
        }

        public double calculateFare() {
            return Math.min(2.0 + 0.10 * distance, 10.0);
        }
    }

    private static class Train implements Transport {
        private final double distance;

        Train(double distance) {
            this.distance = distance;
        }

        public String type() {
            return "TRAIN";
        }

        public double calculateFare() {
            return 3.0 + 0.15 * distance;
        }
    }

    private static class Metro implements Transport {
        private final double distance;
        private final double peakHourFactor;

        Metro(double distance, double peakHourFactor) {
            this.distance = distance;
            this.peakHourFactor = peakHourFactor;
        }

        public String type() {
            return "METRO";
        }

        public double calculateFare() {
            return (1.50 + 0.20 * distance) * peakHourFactor;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int journeyCount = Integer.parseInt(scanner.nextLine().trim());
        List<Transport> journeys = new ArrayList<>();

        for (int i = 0; i < journeyCount; i++) {
            String[] fields = scanner.nextLine().trim().split("\\s+");
            String type = fields[0];
            double distance = Double.parseDouble(fields[1]);

            switch (type) {
                case "BUS":
                    journeys.add(new Bus(distance));
                    break;
                case "TRAIN":
                    journeys.add(new Train(distance));
                    break;
                case "METRO":
                    journeys.add(new Metro(distance, Double.parseDouble(fields[2])));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown transport type: " + type);
            }
        }

        double total = 0.0;
        for (Transport journey : journeys) {
            double fare = journey.calculateFare();
            System.out.printf(Locale.ROOT, "%s: %.2f%n", journey.type(), fare);
            total += fare;
        }
        System.out.printf(Locale.ROOT, "Total: %.2f%n", total);
    }
}