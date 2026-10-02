import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem4 {
    private interface Question {
        String type();
        double grade();
    }

    private static class MultipleChoiceQuestion implements Question {
        private final String correctAnswer;
        private final String studentAnswer;
        private final double points;

        MultipleChoiceQuestion(String correctAnswer, String studentAnswer, double points) {
            this.correctAnswer = correctAnswer;
            this.studentAnswer = studentAnswer;
            this.points = points;
        }

        public String type() {
            return "MCQ";
        }

        public double grade() {
            return studentAnswer.equals(correctAnswer) ? points : 0.0;
        }
    }

    private static class TrueFalseQuestion implements Question {
        private final String correctAnswer;
        private final String studentAnswer;
        private final double points;

        TrueFalseQuestion(String correctAnswer, String studentAnswer, double points) {
            this.correctAnswer = correctAnswer;
            this.studentAnswer = studentAnswer;
            this.points = points;
        }

        public String type() {
            return "TF";
        }

        public double grade() {
            return studentAnswer.equals(correctAnswer) ? points : 0.0;
        }
    }

    private static class EssayQuestion implements Question {
        private final String correctAnswer;
        private final String studentAnswer;
        private final double points;

        EssayQuestion(String correctAnswer, String studentAnswer, double points) {
            this.correctAnswer = correctAnswer;
            this.studentAnswer = studentAnswer;
            this.points = points;
        }

        public String type() {
            return "ESSAY";
        }

        public double grade() {
            String answer = studentAnswer.toLowerCase(Locale.ROOT);
            int matches = 0;
            for (String keyword : correctAnswer.split(",")) {
                String normalizedKeyword = keyword.trim().toLowerCase(Locale.ROOT);
                if (!normalizedKeyword.isEmpty() && answer.contains(normalizedKeyword)) {
                    matches++;
                }
            }

            if (matches >= 2) {
                return points * 0.75;
            }
            return matches == 1 ? points * 0.50 : 0.0;
        }
    }

    private static List<String> tokenize(String line) {
        List<String> tokens = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\\"([^\\\"]*)\\\"|(\\S+)").matcher(line);
        while (matcher.find()) {
            tokens.add(matcher.group(1) != null ? matcher.group(1) : matcher.group(2));
        }
        return tokens;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int questionCount = Integer.parseInt(scanner.nextLine().trim());
        List<Question> questions = new ArrayList<>();

        for (int i = 0; i < questionCount; i++) {
            List<String> fields = tokenize(scanner.nextLine());
            String type = fields.get(0);
            String correctAnswer = fields.get(2);
            String studentAnswer = fields.get(3);
            double points = Double.parseDouble(fields.get(4));

            switch (type) {
                case "MCQ":
                    questions.add(new MultipleChoiceQuestion(correctAnswer, studentAnswer, points));
                    break;
                case "TF":
                    questions.add(new TrueFalseQuestion(correctAnswer, studentAnswer, points));
                    break;
                case "ESSAY":
                    questions.add(new EssayQuestion(correctAnswer, studentAnswer, points));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown question type: " + type);
            }
        }

        double total = 0.0;
        for (Question question : questions) {
            double score = question.grade();
            System.out.printf(Locale.ROOT, "%s: %.2f%n", question.type(), score);
            total += score;
        }
        System.out.printf(Locale.ROOT, "Total Score: %.2f%n", total);
    }
}