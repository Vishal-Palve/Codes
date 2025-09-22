package OOPs.quiz;

public class Main {
    public static void main(String[] args) {
        Question[] questions = {
                new Question("What is the capital of India?",
                        new String[]{"Mumbai", "Delhi", "Kolkata", "Chennai"}, 1),

                new Question("Which language runs in a browser?",
                        new String[]{"Java", "Python", "C++", "JavaScript"}, 3),

                new Question("Who developed Java?",
                        new String[]{"James Gosling", "Guido van Rossum", "Dennis Ritchie", "Mark Zuckerberg"}, 0)
        };

        Quiz quiz = new Quiz(questions);
        quiz.start();
    }
}

