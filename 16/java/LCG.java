// Public class LCG
public class LCG 
{
    // Initialise variables for the constructors
    long a;
    long c;
    long m;
    long seed;
    long shift;
    long biggest32 = 4294967296L;

	// Constructor
    public LCG(long _a, long _c, long _m, long _seed) 
    { 
        // Setting all the variables to the constructors values
        this.a = _a;
        this.c = _c;
        this.m = _m;
        this.seed = _seed;
    }

    public LCG(long _a, long _c, long _m, long _seed, long _shift) 
    { 
        // Setting all the variables to the constructors values
        this.a = _a;
        this.c = _c;
        this.m = _m;
        this.seed = _seed;
        this.shift = _shift;
    }

    // Next method
    public long next() 
    {   
        seed = (a * seed + c) % m;
        long calc = seed >> shift;
        if (seed < 0)
        {
            return (calc) + biggest32;
        }
        else
        {
            return calc;
        }
    }

    // Method seed
    public void seed(long seed) 
    { 
        // Set seed to the value argument seed
        this.seed = seed;
    }

    public static void main(String [] args)
    {
        //a = 1664525;
        //c = 1013904223;
        //m = 4294967296L;

       //LCG test = new LCG(1664525, 1013904223, 4294967296L, -609);
       //System.out.println(test.next());

        // 309278837

       for(long i = 0; i < 1000000000; i++)
        {
            long next = (1664525* i + 1013904223 ) % 4294967296L;
            if (next == 28496)
            {
                System.out.println(i);
            }
        }


    }


}
