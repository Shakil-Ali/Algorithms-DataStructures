// Public class xorshift
public class Xorshift 
{
    // Initialise variables for the constructor
    long a;
    long b;
    long c;
    long seed;
    // Longest number that can be represented in 32 bits
    long biggest32 = 4294967296L;

	// Constructor 
    public Xorshift(long _a, long _b, long _c, long _seed) 
    { 
        // Setting all the variables to the arguments passed
        this.a = _a;
        this.b = _b;
        this.c = _c;
        this.seed = _seed;    	
    }

    // Method next 
    public long next() 
    {
        // Bitwise exclusive OR and assignment operator: C ^= 2 is same as C = C ^ 2
        // << is left shift and >> is right shift
        seed = seed ^ ((seed << a) % biggest32);
        seed = seed ^ ((seed >> b) % biggest32);
        seed = seed ^ ((seed << c) % biggest32);
        // Return statement 
        return seed;
    }

    // Method seed 
    public void seed(long _seed) 
    { 
        // Set variable seed to see
        this.seed = _seed;
    }

    public static void main(String [] args)
    {

        // 226718940

        for(long i = 0; i < 1000000000; i++)
        {
            Xorshift test = new Xorshift(13,17,5,i);
            long next = test.next();
            if (next == 28496)
            {
                System.out.println(i);
            }
        }
    }


}

