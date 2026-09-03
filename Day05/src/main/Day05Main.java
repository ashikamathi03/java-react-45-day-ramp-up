import java.util.Scanner;

public class Day05Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of students: ");
        int students=sc.nextInt();
        System.out.println("Enter the number of Subjects: ");
        int subjects =sc.nextInt();
        int[][] marks=new int[students][subjects];
        for(int i=0;i<students;i++){
            System.out.println("Marks for s"+(i+1)+":");
            for(int j=0;j<subjects;j++){
                marks[i][j]=sc.nextInt();
            }
        }

        int[] totals = new int[students];
        double[] average = new double[students];
        char[] grades = new char[students];


        for (int i = 0; i < students; i++) {
            int sum = 0;
            for (int j = 0; j < subjects; j++) {
                sum += marks[i][j];
            }
            totals[i] = sum;
            average[i] = (double) sum / subjects;

            if (average[i] >= 90) grades[i] = 'A';
            else if (average[i] >= 75) grades[i] = 'B';
            else if (average[i] >= 60) grades[i] = 'C';
            else if (average[i] >= 50) grades[i] = 'D';
            else grades[i] = 'F';
        }


        System.out.println();
        System.out.print("NAME   ");
        for (int j = 1; j <= subjects; j++) {
            System.out.print("SUB" + j + "  ");
        }
        System.out.println("TOTAL   AVG  GRADE");

        for (int i = 0; i < students; i++) {
            System.out.printf("S%-5d", (i + 1));
            for (int j = 0; j < subjects; j++) {
                System.out.printf("%4d  ", marks[i][j]);
            }
            System.out.printf("%5d  %4.1f      %c\n", totals[i], average[i], grades[i]);
        }
        System.out.println();


        int[] subjectHigh = new int[subjects];
        int[] subjectLow = new int[subjects];

        for (int j = 0; j < subjects; j++) {
            int high = marks[0][j];
            int low = marks[0][j];
            for (int i = 1; i < students; i++) {
                if (marks[i][j] > high) high = marks[i][j];
                if (marks[i][j] < low)  low = marks[i][j];
            }
            subjectHigh[j] = high;
            subjectLow[j] = low;
        }

        System.out.print("Subject high:  ");
        for (int j = 0; j < subjects; j++) {
            System.out.printf("%3d   ", subjectHigh[j]);
        }
        System.out.println();

        System.out.print("Subject low:   ");
        for (int j = 0; j < subjects; j++) {
            System.out.printf("%3d   ", subjectLow[j]);
        }
        System.out.println();


        int topperIndex = 0;
        double maxAvg = average[0];
        for (int i = 1; i < students; i++) {
            if (average[i] > maxAvg) {
                maxAvg = average[i];
                topperIndex = i;
            }
        }
        System.out.printf("Class topper: S%d (%.1f)\n\n", (topperIndex + 1), maxAvg);
        System.out.println("Transpose:");
        int[][] transpose = new int[subjects][students];

        for (int i = 0; i < students; i++) {
            for (int j = 0; j < subjects; j++) {
                transpose[j][i] = marks[i][j];
            }
        }


        for (int j = 0; j < subjects; j++) {
            for (int i = 0; i < students; i++) {
                System.out.print(transpose[j][i] + (i == students - 1 ? "" : " "));
            }
            System.out.println();
        }

        sc.close();
    }
}

