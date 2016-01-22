import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class extractFeatures {
	static int windowSize=10;
	static int overlappingSize=5;
	
	public static double average(LinkedList<Double> values)
	{
		double avg = 0.0;
	    int counter = 0;
	    for (double b : values) {
	            avg += b;
	            counter++;
	        }
	    return avg / counter;
	}

	public static void readFile() throws Exception
	{
		double initialTimeStamp;
		
		// Open the file
		FileInputStream fstream = new FileInputStream("C:\\Users\\ZahiD-PC\\Desktop\\gait-data\\gait-data\\o1-76-si.txt");
		InputStreamReader istream= new InputStreamReader(fstream);
		BufferedReader br = new BufferedReader(istream);

		String strLine;

		//Read first line to get the initial timestamp.
		strLine = br.readLine();
		String[] str = null;
		str = strLine.split("	");
        initialTimeStamp=Double.parseDouble(str[0]);
        
        // linkedlist to hold values
        LinkedList<Double> values= new LinkedList<Double>();
        values.add(Double.parseDouble(str[1]));
        
        
		
		//Read File Line By Line
		while ((strLine = br.readLine()) != null)   {
			str = strLine.split("	");

			if((initialTimeStamp+windowSize)>= Double.parseDouble(str[0]))
			{
			 values.add(Double.parseDouble(str[1]));
		     // Print the content on the console
			}
			else
			{
			System.out.println (values);
			System.out.println (average(values));
			values= new LinkedList<Double>();
	        initialTimeStamp=Double.parseDouble(str[0]);
	        values.add(Double.parseDouble(str[1]));
			}

		}

		//Close the input stream
		br.close();
	}
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		readFile();

	}

}
