class DynamicArray {
    // Variable for holding the number of items in array
    private int n_items;
    // Variable to store storage vector
    private int[] storageV;

    // OpCounter function
    public OpCounter counter = new OpCounter();

    // Dynamic array function
    public DynamicArray(int size) {
        n_items = 0;
        storageV = new int[size];
    }

    // Length function
    public int length() {
        return n_items;
    }

    // Select function
    public int select(int k) {
        return storageV[k];
    }

    // Store function
    public void store(int o, int k) {
        storageV[k] = o;
    }

    // Push function
    public void push(int o) {
        if (n_items == storageV.length)
        {
            extend();
        }
        storageV[n_items] = o;
        n_items++;
        counter.add(1);
    }

    // Pop function
    public int pop() {
        n_items--;
        return storageV[n_items];
    }

    // Extend function
    private void extend() {
        int newL = storageV.length + 5;
        int[] newV = new int[newL];
        for (int i = 0; i < storageV.length; i++)
        {
            newV[i] = storageV[i];
            counter.add(1);
        }
        storageV = newV;
    }

    public int wastedSpace() {
        return storageV.length - n_items;
    }



}
