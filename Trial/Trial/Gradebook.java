import java.io.FileReader;
import java.util.Scanner;

public class GradeBook
{
    //declaring the variables
    double quizPoints;
    int totalOfQuizzes;
    double examPoints;
    int totalOfExams;
    double homeworkPoints;
    int totalOfHomeworks;
    double projectPoints;
    int totalOfProjects;


    // setting the variables' values to 0
    public StudentGrade()
    {
        quizPoints = 0;
        totalOfQuizzes = 0;
        examPoints = 0;
        totalOfExams = 0;
        homeworkPoints = 0;
        totalOfHomeworks = 0;
        projectPoints = 0;
        totalOfProjects = 0;
    }
    public double getQuizAverage()
    {
        double avg = quizPoints/totalOfQuizzes;
        return avg;
    }
    public double getExamAverage()
    {
        double avg = examPoints/totalOfExams;
        return avg;
    }
    public double getHomeworkAverage()
    {
        double avg = homeworkPoints/totalofHomeworks;
        return avg;
    }
    public double getProjectAverage()
    {
        double avg = projectPoints/totalofProjects;
        return avg;
    }
    public void addGrade (String category, double grade)
    {
        if(category.equals("QUIZZES"))
        {
            quizPoints = quizPoints+grade;
            totalOfQuizzes = totalOfQuizzes+1;
        }
        else if(category.equals("EXAMS"))
        {
            examPoints = examPoints+grade;
            totalOfExams = totalOfExams+1;
        }
        else if(category.equals("HOMEWORKS"))
        {
            homeworkPoints = homeworkPoints+grade;
            totalOfHomeworks = totalOfHomeworks+1;
        }
        else if(category.equals("PROJECTS"))
        {
            projectPoints = projectPoints+grade;
            totalOfProjects = totalOfProjects+1;
        }
    }
    public double getFinalNumberGrade()
    {
        double finalNumGrade = (getQuizAverage()*0.20)+(getExamAverage()+0.30)+(getHomeworkAverage()+0.25)+(getProjectAverage()+0.25);
        return Math.ceil(finalNumGrade);
    }
    public getCourseLetterGrade (double weightGrade)
    {
        if(weightGrade >= 90.00){
            return "A";
        }
        else if(weightGrade >= 80.00){
            return "B";
        }
        else if(weightGrade >= 70.00){
            return "C";
        }
        else if(weightGrade >= 60.00){
            return "D";
        }
        else{
            return "F";
        }
        return null;
    }
    public void readGradesFile(String filename)
    {
        String c1, c2, c3, c4;
        try
        {
            Scanner fin = new Scanner(new FileReader(filename));
            while(fin.hasNext())
            {
                c1 = fin.nextLine();
                for(int i = 0 ; i<5;i++)
                {
                    addGrade(c1,fin.nextDouble());
                }
                c2 = fin.nextLine();
                c2 = fin.nextLine();
                for(int i = 0 ; i<2;i++)
                {
                    addGrade(c2,fin.nextDouble());
                    c3 = fin.nextLine();
                    c3 = fin.nextLine();
                for(int i = 0 ; i<7;i++)
                {
                    addGrade(c3,fin.nextDouble());
                }
                    c4 = fin.nextLine();
                    c4 = fin.nextLine();

                    addGrade(c4,fin.nextDouble());
                }

                fin.close();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void writeOutput()
    {
        System.out.print("Quiz Average: "+getQuizAverage()+"\n");
        System.out.print("Exam Average: "+getExamAverage()+"\n");
        System.out.print("Homework Average: "+getHomeworkAverage()+"\n");
        System.out.print("Project Average: "+getProjectAverage()+"\n");
        System.out.print("Final Number Grade Average: "+getFinalNumberGrade()+"\n");
        System.out.print("Course Letter Grade Average: "+ getCourseLetterGrade()+"\n");
    }

}