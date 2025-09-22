package OOPs.quiz;

import java.util.Scanner;

public class Quiz {
   private Question[] questions;

   public Quiz(Question[] questions) {
      this.questions = questions;
   }

   public void start() {
      Scanner sc = new Scanner(System.in);
      int score = 0;

      for (Question q : questions) {
         q.displayQuestion();
         System.out.print("Your answer (1-4): ");
         int answer = sc.nextInt() - 1;

         if (q.isCorrect(answer)) {
            System.out.println("Correct!\n");
            score++;
         } else {
            System.out.println("Wrong!\n");
         }
      }

      System.out.println("Quiz Over! Your score: " + score + "/" + questions.length);
      sc.close();
   }
}
