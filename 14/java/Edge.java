// Public class
public class Edge 
{
	// Initialise the variables
    public Vertex from, to;
    public int weight;

    // Edge constructor
    public Edge(Vertex _from, Vertex _to, int _weight) 
    {
    	this.from= _from;
    	this.weight = _weight;
    	this.to = _to;
    }

}
