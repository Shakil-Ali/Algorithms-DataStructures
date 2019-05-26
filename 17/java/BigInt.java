import java.math.BigInteger;
//import java.util.*;

// Class BigInt
public class BigInt {

    // Variable for ndigits 
    public int ndigits;
    // public for test purposes
    public char data[];
    // Variable for first value
    public int initialValue;

    // Constructor BigInt with integer parameter
    public BigInt(int _ndigits) 
    {
        // Set the gloabl ndigits variable to the arguement 
        this.ndigits = _ndigits;
        // Set the data variable to the index '_ndigits' of the char array
        data = new char[_ndigits];
    }

    // Constructor BigInt with string parameter
    public BigInt(String s) 
    {
        // Set the ndigits variable to the length of the input string
        ndigits = s.length();
        // Make a character array which turns the string into a sequence of characters
        char chArray [] = s.toCharArray();
        // For loop going through the half the size of character array
        for(int i = 0; i < chArray.length/2; i++)
        {
            // Temporary character variable to store index of the character arrau
            char tempo = chArray[i];
            // Set the character index to character array's length minus the value of i  - 1
            chArray[i] = chArray[chArray.length - i - 1];
            // Set the index of the charater array, which has the length of array - i - 1, to the temporary character variable
            chArray[chArray.length - i - 1] = tempo;
        }
        // For loop to iterate the length of the string
        for(int i = 0; i < ndigits; i++)
        {
            // Set data array to the character array
            data = chArray;
            // Integer variable to store the numeric value of the character at index i of the character array
            int numValue = Character.getNumericValue(chArray[i]);
            // Set the data array index i to the numeric value from the integer variable. Have to type cast this integer to a character
            data[i] = (char) numValue;
        }
        // Set data array to the character array
        data = chArray;
    }

    // Method for get
    public char get(int i) 
    {
        // Store the length of the data array 
        int length_of_data = data.length;
        // Conditional if statement to check if the input i is greater than the length of the data array
        if(i >= length_of_data) 
        {
            // If it is return 0
            return 0;
        }
        // Else statement    
        else
        {
            // Return the index i of the data array
            return data[i];
        }        
    }

    // Method for Addition
    public BigInt Add(BigInt y) 
    {
        // Set variables to store the number 1, 0 and an empty array
        int num = 1, cons = 0, myArray [];
        // Conditional to check if the input number is greater than this number
        if(y.ndigits > this.ndigits)
        {
            // If it is add that input variable digits value to the num variable
            num = num + y.ndigits;
        }
        // Else statement
        else
        {
            // Increment the num variable with this digits value
            num = num + this.ndigits;
        }
        // Create a variable to store a big integer
        BigInt store = new BigInt(num);
        // Set myArray size to the size of num
        myArray = new int[num];
        // For loop to iterate 'num' times
        for(int i = 0; i < num; i++)
        {
            // Set the ith index of myarray to this ith digits value, y ith digits value and cons variable
            myArray[i] = this.get(i) + y.get(i) + cons;
            // Conditional to check if myArray index at i is greater than 9
            if(myArray[i] > 9)
            {
                // Set the cons value to 1
                cons = 1;
                // Set myarray index to the modulo 10 of itself (10bits)
                myArray[i] = myArray[i] % 10;
            }
            // Conditional else
            else
            {
                // Set cons go 0
                cons = 0;
            }
            // Set the ith index of the store.data array to the character at index i of myarray
            store.data[i] = Character.valueOf((char)myArray[i]);
        }
        // Return store value
        return store;
    }

    // Method for subtraction
    public BigInt Sub(BigInt y) 
    {
        // Initialise big integer variable to store the length of the data array
        BigInt mem = new BigInt (data.length);
        // Conditional if to check if input y is less than the length of the data variable
        if(data.length > y.data.length) 
        {
            // Create big integer variable to store the length of the data
            BigInt temp_mem = new BigInt(data.length);
            // For loop to iterate through the length of the input y
            for(int i = 0; i < y.data.length; i++) 
            {
                // Set the index i of the temp array to the input ith index of dara array
                temp_mem.data[i] = y.data[i];
            }
            // Set the input data array to the temp data array
            y.data = temp_mem.data;
        }
        // Set the value of a variable to 0
        int k = 0;
        // For loop that iterates the length of the data array
        for (int i = 0; i < data.length; i++) 
        {
            // Set an integer variable to the ith index of the data array minus the input ith index of data array minus the variable k
            int val = data[i] - y.data[i] - k;
            // Conditional to check if the 'val' variable is less than 0
            if(val < 0) 
            {
                // Increment the val variable by 10
                val = val + 10;
                // Set the k variable to 1
                k = 1;
            }
            // Else statement
            else
            {
                // Set the k variable to 0
                k = 0;
            }
            // Set the memory data index to the char typecasted val variable
            mem.data[i] = (char) val;
        }
        // return mem array
        return mem;   
    }

    // Method for shifting
    public BigInt Shift(int n) 
    {
        // Create a new big integer variable to store the length of data array + the input value m
        BigInt shifted1 = new BigInt(this.data.length + n);
        // Iterate for loop data array length times
        for(int i = 0; i < this.data.length; i++)
        {
            // (i+n)th index of the shifted data array is set to the ith index of the data array
            shifted1.data[i+n] = data[i];
        }
        // Return the big integer value shifted1
        return shifted1;
    }

    // Method for Multipplication By Digit
    public BigInt MulByDigit(char c) 
    {
        // Create big integer variable and set to the length of data array + 1
        BigInt mult = new BigInt(data.length + 1);
        // Initialise variable and set valiue to 0
        int k = 0;
        // For loop to iterate the data length
        for(int i = 0; i < data.length; i++)
        {
            // Set the temporary integer to the data array ith index value, multiplied by c and added to k
            int tem = data[i] * c + k;
            // Set the data array of mult to char typecasted temporary value mod 10 
            mult.data[i] = (char)(tem % 10);
            // Set k to the temo value divided by 10
            k = tem / 10;
        }
        // Set multi data - 1 array index to typecasted char value k
        mult.data[mult.data.length - 1] = (char) k;
        // Return the mult variable
        return mult;
    }

    // Method for Mul
    public BigInt Mul(BigInt y) 
    {
        // Set the big integer value of an array to 1 (As it will not work with int 1)
        BigInt a_val = new BigInt(1);
        // Create a string variable to store the input big integers data 
        String inputData = new String(y.data);
        // Create a second string variable to store the input data, reversed
        String reversed1 = new StringBuilder(inputData).reverse().toString();
        // Create integer variable to the length of the reversed string
        int reversedLength = reversed1.length();
        // Create a character array, the size of the reversed string
        char [] tempo = new char[reversedLength];

        // For loop to iterate the same number of times as the length of the reversed string
        for (int i = 0; i < reversedLength; i++) 
        {
            // Set the temporary index i to the typecasted value of the reversed string's character at i + 48
            tempo[i] = (char)(reversed1.charAt(i) + 48);
        }

        // String variable to store tempo character array
        String b_temp = new String(tempo);
        // Big integer to store the new string array above
        BigInteger d_temp = new BigInteger(b_temp);

        // While loop to iterate whilst the big integer is greater than 0
        while (d_temp.compareTo(BigInteger.ZERO) > 0) 
        {
            // Set a variable to the variable added to this
            a_val = a_val.Add(this);
            // Set the temporary big integer to itself subtracted by big integer one
            d_temp = d_temp.subtract(BigInteger.ONE);
        }
        // Return the created variable
        return a_val;
    }

    // Method for Division
    public BigInt Div(BigInt d) 
    {
        // Create big integer variable and set to the value of ndigits
        BigInt dividend = new BigInt(ndigits);

        // For loop to iterate the same length as the data array
        for(int i= 0; i < data.length; i++) 
        {
            // Set the big integer varibales data index i to the index i of the data array
            dividend.data[i] = data[i];
        }

        char [] dividend_data = dividend.data;
        char [] d_data = d.data;

        // Create a string variable to store a new string of dividend's data, which is reversed
        String a = new StringBuilder(new String(dividend_data)).reverse().toString();
        // Create a string variable to store a new string of d's data, which is reversed
        String b = new StringBuilder(new String(d_data)).reverse().toString();


        // Create a character array and set it to the length of a
        char [] temp1 = new char[a.length()];

        // For loop to iterate a's length times
        for (int i = 0; i < a.length(); i++) 
        {
            // Set temps array index i to the type casted character at a's character at index i plus 48
            temp1[i] = (char)(a.charAt(i) + 48);
        }
        

        // Set the variable a to the strng of temp1
        a = new String (temp1);
        // Create a character array to store b.length amount of characters
        char [] temp2 = new char[b.length()];

        // For loop to iterate the length of b        
        for (int i = 0; i < b.length(); i++) 
        {
            // Set the temporary index i to the type casted character i of b + 48
            temp2[i] = (char)(b.charAt(i) + 48);
        }

        // Set b variable to the string of temp2
        b = new String (temp2);

        // Set global initialValue to integer version of a
        initialValue = Integer.parseInt(a);
        // Create integer and store the value of b
        int secondValue = Integer.parseInt(b);
        // Store count in a variable
        long count  = 0;

        // While loop to go whilst intialValue is greater or equal to secValue
        while (initialValue >= secondValue) 
        {
            // Set dividend to dividend sub value of d
            dividend = dividend.Sub(d);
            // Set a to the new string of data of dividend, which is reversed
            a = new StringBuilder(new String(dividend.data)).reverse().toString();
            // Set temp variable to length of a
            temp1 = new char[a.length()];

            // For loop to iterate a length times
            for(int i = 0; i < a.length(); i++) 
            {
                // Set temporary array index tp character at a's index i + 48
                temp1[i] = (char)(a.charAt(i) + 48);
            }

            // Set a to new string of temp1 variable
            a  = new String(temp1);
            // Set intialValue to the integer of a
            initialValue = Integer.parseInt(a);
            // Increment the count
            count++;
        }

        // Create and set string variable to the count 
        String counterString = count + "";
        // Create and set a big integer variable to the counterString array length
        BigInt end = new BigInt(counterString.length());
        // Create character array which stores the counter string array length
        char q [] = new char[counterString.length()];

        // For loop to iterate the counter strings length, with i and j conditions
        for (int i = counterString.length()-1, j = 0; i >= 0; i--, j++) 
        {
            // Set the jth index of q to typecasted character of counter string at counterstring character at i - string 0
            q[j] = (char) (counterString.charAt(i) - '0');
        }
        // Set end's data to q
        end.data = q;
       // Return the end variable    
       return end;
    }

    // Method for Rem
    public BigInt Rem(BigInt d) 
    {
        // Big integer variable set to the division of input value d
        BigInt remOne = this.Div(d);
        // Second big integer variable to store the initial value plus empty string 
        BigInt remTwo = new BigInt(initialValue + "");
        // return second big integer variable
        return remTwo;  
    }

    //// Extra Functions //////////////////////////////////////////////

    public String toString()
    {
        // Create string variable
        String str;
        // Set the value to empty string 
        str = "";
        // Store the length of data character array
        int len = data.length;
        // Iterate the length of character array 'data'
        for(int i = 0; i < len; i ++)
        {
            // Print the character at index i of the character array
            System.out.print(this.data[i]);
            // Cocatenate the string with the index i of the character array 'data'
            str = str + data[i];
        }
        // Return the string 'str' with the value
        return str;
    }

    // Method for getSelf
    public BigInt getSelf()
    {
        return this;
    }

    public boolean isMore(BigInt a)
    {
        // Store datas length
        int origin = this.data.length;
        // Store inputted numbers length
        int comparedInt = a.data.length;

        // Create a false boolean variable
        boolean bigger = false;

        boolean troo = true;

        boolean folce = false;

        // Conditional if to check if this BigInt is bigger than inputted
        if(origin > comparedInt)
        {
            // If so, set selfBigger to true
            bigger = troo;
            // Return true
            return troo;
        }
        // Else if condition, for if they are equal
        else if(origin == comparedInt)
        {
            // For loop iterating this.data's length times
            for(int i = 0; i < origin; i++)
            {
                // If index of this data is greater than index if i of inputted data array
                if(this.data[i] > a.data[i])
                {
                    // Return true
                    return troo;
                }
                // Else condition
                else
                {
                    // Return false
                    return folce;
                }
            }
        }
        // Return false
        return folce;
    }

    ////////////////////////////////////////////////////////////////////////


    // Main method
    public static void main(String [] args)
    {
       
    }
    



}

