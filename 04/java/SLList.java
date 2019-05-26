// Class SSList
class SLList {
    // Object created and given name first
    Object first;
    // SLList created and named rest
    SLList rest;

    // Method for setting values in SSList
    public SLList(Object f, SLList r) { 
        // Making first equal the object f
        first = f;
        // Making the rest equal the SLList r
        rest = r;
    }

    // Method for making NIL equal null
    public static final SLList NIL = new SLList(0, null);

    // Method returning the Object first
    public Object first() {
        // returning first Object
        return first;
    }

    public SLList rest() {
        // Returning the rest SLList
        return rest;
    }

    // Method for setting the first variable to Object f
    public void setFirst(Object f) {
        // first assigned to Object f
        first = f;
    }

    // Method for setting the rest variable to SLList r
    public void setRest(SLList r) {
        // set rest to r
        rest = r;
    }

    // Method for finding nth value
    public Object nth(int i) {
        // If to check if value i is 0
        if (i == 0)
        {
            return first;
        }
        // Else-if to check if the rest is empty
        else if( rest == NIL)
        {
            return null;
        }
        // Else to return the rest of one element less than nth
        else
        {
            return rest.nth(i-1);
        }
    }

    // Method to return SSlist at nthRest
    public SLList nthRest(int i) {
        if (i == 0)
        {
            // Returns 'this' SLList
            return this;
        }
        else
        {
            // Return 
            return rest.nthRest(i-1);
        }
    }

    // Method for returing length of a list
    public int length() {
        // Checks if list empty
        if (this == NIL)
        {
            // Return 0
            return 0;
        }
        // Else conditional
        else 
        {
            // 1 plus the length
            return 1 + rest.length();
        }
    }

    // Method for removing Object from SLList
    public SLList remove(Object o) {
        // If NIL , returns NIL
        if (NIL == this)
        {
            // Returns NIL
            return NIL;
        }
        // Else-if o is the first
        else if(o == first)
        {
            // Return the rest, with o removed
            return rest().remove(o);
        }
        else
        {
            // Return new SLList with first element to rest with o removed
            return new SLList(first, rest().remove(o));
        }
    }

    // Method reverses SLList
    public SLList reverse() {
        // If statement to check if this is empty
        if (NIL == this)
        {
            // Returning NIL value
            return NIL;
        }
        // Else statement
        else
        {
            // x is the rest of the SLList reversed
            SLList x = rest().reverse();
        
            // If statement to check if x is empty
            if (x == NIL)
            {
                // Returns new SLList  with first value and NIL as last
                return new SLList(first, NIL);
            }

            // Get rest of x.last rest and make new SLListy with first and NIL
            x.lastRest().rest = new SLList(first, NIL);

            // Returns x
            return x;
        }
    }

    // Method of lastRest
    SLList lastRest() {
        // Cechks if rest is NIL
        if (rest() == NIL)
        {
            // Returns this
            return this;
        }
        // Else statement
        else
        {
            // Return statement to get lastRest of the rest
            return rest().lastRest();
        }
    }

    // Method for sum
    public Integer sum() {
        // Checks if empty 
        if (NIL == this)
        {
            // returns 0 as list empty
            return 0;
        }
        // Else statement
        else 
        {
            // variable i made to get the first element in a list, then returns the value i and using recursion, checks and gets the next value in list
            Integer i = (int) first;
            // Return i and the sum of the rest
            return i + rest().sum();
        }

    }

    // Method for sublist 
    public SLList sublist(int start, int end) {
        // If to check if empty
        if (start == end) {
            return NIL;
        }
        // Else statement
        else 
        {
            // Return new SLList 
            return new SLList(nth(start), sublist(start+1, end));
        }
    }

    // Method Merge 
    public SLList merge(SLList b) {
        // Checks if empty
        if (this == NIL) 
        {
            // Return b
            return b;
        }

        else if (b == NIL) 
        {
            // Return this
            return this;
        }
        // Else if to check if this first is <= to b first
        else if ((Integer) this.first <= (Integer) b.first) 
        {
            // Returns SLList with this first and b merged with this rest
            return new SLList(this.first, b.merge(this.rest));
        }
        // Else statement
        else 
        {
            // Return statement for b first and this merged with b rest
            return new SLList(b.first, this.merge(b.rest));
        }
    }


    // Method for mergesort, takes no arguments
    public SLList mergesort() {
        // Assign n with this length
        int sl = this.length();
        // Conditional if to check if sl is 1 or lower
        if (sl <= 1)
        {
            // Return this
            return this;
        }
        // Else statement 
        else
        {
            // Set mid
            int mid = sl/2;
            // Set left and right
            SLList lft = this.sublist(0, mid).mergesort();
            SLList rgt = this.sublist(mid,sl).mergesort();
            // Return the left merged with right
            return lft.merge(rgt);
        }
    }
    

}
