
import java.util.*;

public class GradingStudents {

    /*
     * Complete the gradingStudents function below.
     * https://www.hackerrank.com/challenges/grading/problem
     */
    static void gradingStudents(int[] grades) {
        /*
         * Write your code here.
         */
    	GradingStudents gradingstu = new GradingStudents();
    	gradingstu.printFinalGradesForArray(gradingstu.checkGrades(grades));

    }

    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine().trim());

        int[] arr = new int[n];

        for(int ar_i = 0; ar_i < n; ar_i++){
        	arr[ar_i] = scan.nextInt();
        }
        gradingStudents(arr);

    }
    
    private int fiveMinus_getModuloOfFive(int grade_to_compare_against)
    {
    	int result_value = 0;
    	
    	result_value = grade_to_compare_against % 5;
    	//Values are always going to be less than 5 so this produces a postive number
    	result_value = 5 - result_value;
    	
    	return result_value;
    }
    
    private int updateOrKeepValueForModulo(int grade_to_compare_against, int modulo_value)
    {
    	int result_value = 0;
    	
    	if (grade_to_compare_against < 38)
    	{
    		//Keeping this as is as its a failing grade
    		result_value = grade_to_compare_against;
    	}
    	else
    	{
    		if(modulo_value == 0)
        	{
        		//Keeping this as its a modulo of 5
        		result_value = grade_to_compare_against;
        	}
        	
        	if(modulo_value < 3)
        	{
        		//Keeping this as its a modulo of 5
        		result_value = grade_to_compare_against + modulo_value;
        	}
        	
        	if(modulo_value >= 3)
        	{
        		//Keeping this as its a modulo of 5
        		result_value = grade_to_compare_against;
        	}
    	}

    	return result_value;
    }
    
    private int[] checkGrades(int[] grades)
    {
    	int[] result_grades = new int[grades.length];
    	
    	for(int i=0; i<grades.length; i++)
    	{
    		int modulo = this.fiveMinus_getModuloOfFive(grades[i]);
    		int grade = this.updateOrKeepValueForModulo(grades[i], modulo);
    		result_grades[i] = grade;
    	}
    	
    	return result_grades;
    }
    
    private void printFinalGradesForArray(int[] result_grades)
    {
    	for(int i=0; i<result_grades.length; i++)
    	{
    		System.out.println(result_grades[i]);
    	}
    }
    
}
