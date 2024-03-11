// Java code for 
// the above approach
import java.util.*;
class Largest_Lexicograplical_String{

// Function to find the
// largest lexicographical
// String with given constraints.
static String getLargestString(String s,
							int k)
{
// Vector containing frequency
// of each character.
int []frequency_array = new int[26];

// Assigning frequency 
for (int i = 0;
		i < s.length(); i++) 
{
	frequency_array[s.charAt(i) - 'a']++;
}

// Empty String of 
// String class type
String ans = "";

// Loop to iterate over
// maximum priority first.
for (int i = 25; i >= 0;)
{
	// If frequency is greater than
	// or equal to k.
	if (frequency_array[i] > k) 
	{
	// Temporary variable to 
	// operate in-place of k.
	int temp = k;
	String st = String.valueOf((char)(i + 'a'));
	while (temp > 0) 
	{
		// Concatenating with the
		// resultant String ans.
		ans += st;
		temp--;
	}

	frequency_array[i] -= k;

	// Handling k case by adjusting
	// with just smaller priority
	// element.
	int j = i - 1;
	
	while (j >= 0 && frequency_array[j] <= 0) 
	{
		j--;
	}

	// Condition to verify if index
	// j does have frequency
	// greater than 0;
	if (j >= 0 && frequency_array[j] > 0  ) 
	{
		String str = String.valueOf((char)(j + 'a'));
		ans += str;
		frequency_array[j] -= 1;
	}
	else
	{
		// If no such element is found
		// than String can not be
		// processed further.
		break;
	}
	}

	// If frequency is greater than 0
	// and less than k.
	else if (frequency_array[i] > 0) 
	{
	// Here we don't need to fix K
	// consecutive element criteria.
	int temp = frequency_array[i];
	frequency_array[i] -= temp;
	String st = String.valueOf((char)(i + 'a'));
	
	while (temp > 0) 
	{
		ans += st;
		temp--;
	}
	}

	// Otherwise check for next
	// possible element.
	else
	{
	i--;
	}
}
return ans;
}

// Driver code
public static void main(String[] args)
{
String S = "zzaaa";
int k = 2;
System.out.print(getLargestString(S, k));
}
}

// This code is contributed by shikhasingrajput
