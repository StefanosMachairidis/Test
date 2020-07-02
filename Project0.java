/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project0;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author George.Pasparakis
 */
public class Project0 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner user_input = new Scanner(System.in);
//        String name = question1("What is your name?", user_input);
        makeTheQuestionsAndPrint(user_input);
    }

    // question template   
    public static String makeAQuestion(String message, Scanner user_input) {
        System.out.println(message);
        String return_input = user_input.next();
        return (return_input);
    }

    // What is your name?
    public static String question1(String message, Scanner user_input) {
        String return_input = makeAQuestion(message, user_input);
        return (return_input);
    }

    // What year you were born?
    public static Integer question2(String message, Scanner user_input) {
        String answer = makeAQuestion(message, user_input);
        Integer return_input = Integer.parseInt(answer);
        return (return_input);
    }

    // What is the name of the city you were born?
    public static String question3(String message, Scanner user_input) {
        String return_input = makeAQuestion(message, user_input);
        return (return_input);
    }

    // Are you married?
    public static boolean question4(String message, Scanner user_input) {
        String answer = makeAQuestion(message, user_input);
        boolean return_input;
        if (answer.equals("yes") || answer.equals("Yes") || answer.equals("YES")) {
            return_input = true;
        } else {
            return_input = false;
        }
        return (return_input);
    }

    // How many years have you been married?
    public static int question4a(String message, Scanner user_input) {
        String answer = makeAQuestion(message, user_input);
        int return_input = Integer.parseInt(answer);
        return (return_input);
    }

    // What year did you get married?
    public static int question4b(String message, Scanner user_input) {
        String answer = makeAQuestion(message, user_input);
        int return_input = Integer.parseInt(answer);
        return (return_input);
    }

    // Do you have any children?
    public static boolean question4c(String message, Scanner user_input) {
        String answer = makeAQuestion(message, user_input);
        boolean return_input;
        if (answer.equals("yes") || answer.equals("Yes") || answer.equals("YES")) {
            return_input = true;
        } else {
            return_input = false;
        }
        return (return_input);
    }

    // How many children do you have?
    public static int question4d(String message, Scanner user_input) {
        String answer = makeAQuestion(message, user_input);
        int return_input = Integer.parseInt(answer);
        return (return_input);
    }

    // What is the name of your i child?
    public static String question4e(String message, Scanner user_input) {
        String return_input = makeAQuestion(message, user_input);
        return (return_input);
    }

    // What is the age of your i child?
    public static int question4f(String message, Scanner user_input) {
        String answer = makeAQuestion(message, user_input);
        int return_input = Integer.parseInt(answer);
        return (return_input);
    }

    // What is your favourite color?
    public static String question5(String message, Scanner user_input) {
        String return_input = makeAQuestion(message, user_input);
        return (return_input);
    }

    public static String ordinal(int i) {
        return i % 100 == 11 || i % 100 == 12 || i % 100 == 13 ? i + "th" : i
                + new String[]{"th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th"}[i % 10];
    }

    // group all questions together
    public static void makeTheQuestionsAndPrint(Scanner user_input) {
        int q4a_answer = 0;
        int q4b_answer = 0;
        boolean q4c_answer = false;
        int q4d_answer = 0;
        ArrayList<String> names_of_children = new ArrayList<String>();
        ArrayList<Integer> ages_of_children = new ArrayList<Integer>();

        String q1_answer = question1("What is your name? ", user_input);
        Integer q2_answer = question2("What year you were born? ", user_input);
        String q3_answer = question3("What is the name of the city you were born? ", user_input);
        boolean q4_answer = question4("Are you married? ", user_input);
        if (q4_answer == true) {
            q4a_answer = question4a("How many years have you been married? ", user_input);
            q4b_answer = question4b("What year did you get married? ", user_input);
            q4c_answer = question4c("Do you have any children? ", user_input);
            if (q4c_answer) {
                q4d_answer = question4d("How many children do you have? ", user_input);
                if (q4d_answer > 0) {
                    for (int i = 0; i < q4d_answer; i++) {
                        String name = question4e("What is the name of your " + ordinal(i + 1) + " child? ", user_input);
                        Integer age = question4f("What is the age of your " + ordinal(i + 1) + " child? ", user_input);
                        names_of_children.add(name);
                        ages_of_children.add(age);
                    }
                }
            }
        }
        String q5_answer = question5("What is your favourite color? ", user_input);
        printTheOutput(q1_answer, q2_answer, q3_answer, q4_answer, q4a_answer, q4b_answer, q4c_answer, q4d_answer, names_of_children, ages_of_children, q5_answer);

    }

    // Dear {name}, your were born in {year} so you are {age} and born in the city of {city}.
    // You are not married and your favourite color is {color}.
    // and you don't have any children.
    // and you have X children.
    // The name of your i child is {nameOfChild_i} and was born in the year of {bornYearChild_i}.
    // Your favourite color is {color}.
    public static void printTheOutput(String name, Integer year, String city, boolean married, int years_married,
            int year_of_marriage, boolean have_children, int no_of_children,
            ArrayList<String> names_of_children, ArrayList<Integer> ages_of_children, String color) {
        System.out.println("Dear " + name + ", your were born in "
                + year + " so you are " + (2020 - year)
                + " and born in the city of " + city + ".");
        if (married == true) {
            System.out.print("You have been married for " + years_married + " years and you got married in " + year_of_marriage);
            if (!have_children) {
                System.out.println(" and you don't have any children.");
            } else {
                System.out.print(" and you have " + no_of_children);
                if (1 == no_of_children) {// + " children.");
                    System.out.print(" child.");
                } else {
                    System.out.println(" children.");
                }
                // print the details of all the children
                for (int i = 0; i < names_of_children.size(); i++) {
                    System.out.println("The name of your " + ordinal(i) + " is " + names_of_children.get(i)
                            + " and was born in the year of " + (2020 - ages_of_children.get(i)
                            + "."));
                }
            }
            System.out.println("Your favourite color is " + color + ".");
        } else {
            System.out.println("You are not married and your favourite color is " + color + ".");
        }
    }

}

//public static String ordinal(int i) {
//    String[] sufixes = new String[] { "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th" };
//    switch (i % 100) {
//    case 11:
//    case 12:
//    case 13:
//        return i + "th";
//    default:
//        return i + sufixes[i % 10];
//
//    }
//}
//
//
//
//public static void main(String[] args) {
//    int[] edgeCases = { 0, 1, 2, 3, 4, 5, 10, 11, 12, 13, 14, 20, 21, 22, 23, 24, 100, 101, 102, 103, 104, 111, 112, 113, 114 };
//    for (int edgeCase : edgeCases) {
//        System.out.println(ordinal(edgeCase));
//    }
//}

