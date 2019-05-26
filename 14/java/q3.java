// moodle id digit sum = 2+8+4+9+6 = 29
// student id digit sum =  3+3+5+0+8+4+0+2 = 25

Graph g = new Graph();

g.addVertex("A");
g.addVertex("B");
g.addVertex("C");
g.addVertex("D");

// MST edge
g.addEdge("A", "D", 10);
g.addEdge("D", "B", 25);
g.addEdge("B", "C", 4);

// other edges
g.addEdge("A", "B", 40);
g.addEdge("A", "C", 30);
g.addEdge("D", "C", 30);