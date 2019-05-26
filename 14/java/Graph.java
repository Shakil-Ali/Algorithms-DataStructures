import java.util.ArrayList;

public class Graph
{
    public ArrayList<Vertex> vlist;

    public Graph() 
    {
        this.vlist = new ArrayList<Vertex>();
    }

    public void addVertex(String name) 
    {
        Vertex vNew = new Vertex(name);
        vlist.add(vNew);
    }

    public Vertex getVertex(String name) 
    {
        return null;
    }

    public void addEdge(String from, String to, int weight) 
    {
            getVertex(from).adjlist.add(new Edge(getVertex(from), getVertex(to), weight));
    }

    public Edge getEdge(String from, String to) 
    {
        for(int i = 0; i < vlist.adjlist.size() ; i++)
        {
            if(from == to)
            {
                return vlist.adjlist.get(i);
            }
        }
        return null;   
    }
    
    public int MSTCost() 
    {
        return 0;
    } 


    public Graph MST() 
    {
	  return null;
    }

    public int SPCost(String from, String to) 
    {
      return 0;
    }

    public Graph SP(String from, String to) 
    {
      return null;
    }

    public static void main(String [] args)
    {

    }

}
