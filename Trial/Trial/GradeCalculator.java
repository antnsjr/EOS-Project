import java.util.Scanner;

public class GradeCalculator
{

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String filename;

        System.out.println("Enter the file name containing student grades"); filename = sc.nextLine();

        GradeBook gradeEntry = new gradeEntry();

        gradeEntry.readGradesFile(filename);

        gradeEntry.writeOutput();
    }

}