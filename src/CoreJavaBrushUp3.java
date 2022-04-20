
public class CoreJavaBrushUp3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//STRING IS AN OBJECT. String LITERAL - if you create 2 variables s, s1 (for example) then s1 variable will not store new memory and
		//point to the value for variable s.
		String s = "Nimisha Pathak";
		String s1 = "Nimisha Pathak";
		
		//String variables created with NEW variable, it will create new memory for every variable.
		
		String s2 = new String("dishant");
		String s3 = new String("dishant");
		
		
		String s4 = "nimisha pathak parramatta";
		
		String[] splittedStrings = s4.split(" ");
		System.out.println(splittedStrings[0]);
		System.out.println(splittedStrings[1]);
		System.out.println(splittedStrings[2]);
		
		String[] splittedStrings1 = s4.split("pathak");
		System.out.println(splittedStrings1[0].trim()); // to trim the white space before and after the string characters
		System.out.println(splittedStrings1[1]);
		
		//Below for loop prints every character in string stored in s4 variable in ascending order
		for(int i = 0; i<s4.length(); i++)
		{
			System.out.println(s4.charAt(i));
		}
		
		//Below for loop prints every character in string stored in s4 variable in DESCENDING order
		for(int i = s4.length()-1; i>=0; i--)
		{
			System.out.println(s4.charAt(i));
		}
		
		
	}

}
