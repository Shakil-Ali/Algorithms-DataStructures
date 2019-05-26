public class ListVisualiserDriver {
    
    static void loopingList(SLList list) {
        list.rest().rest = list.rest;
    }

    public static void main(String args[]) {

        // Empty list
        SLList a2 = SLList.NIL;
        ListVisualiser v2 = new ListVisualiser(a2);
        v2.visualise();

        // Two element list (max value)
        SLList a5 = new SLList(Integer.MAX_VALUE, new SLList(22, SLList.NIL));
        ListVisualiser v5 = new ListVisualiser(a5);
        v5.visualise();

        // Two element list (normal)
        SLList a7 = new SLList(22, new SLList(22, SLList.NIL));
        ListVisualiser v7 = new ListVisualiser(a7);
        v7.visualise();
        
        // 3 element list
        SLList a8 = new SLList(1, new SLList(11, new SLList(23, SLList.NIL)));
        ListVisualiser v8 = new ListVisualiser(a8);
        v8.visualise();

        // 4 element list
        SLList a = new SLList(1, new SLList(11, new SLList(23, new SLList(8, SLList.NIL))));
        ListVisualiser v = new ListVisualiser(a);
        v.visualise();

        // 5 element list
        SLList a10 = new SLList(1, new SLList(11, new SLList(23, new SLList(88, new SLList(69, SLList.NIL)))));
        ListVisualiser v10 = new ListVisualiser(a10);
        v10.visualise();

        // 6 element list
        SLList a1 = new SLList(1, new SLList(11, new SLList(23, new SLList(88, new SLList(69, new SLList(8, SLList.NIL))))));
		ListVisualiser v1 = new ListVisualiser(a1);
        v1.visualise();

        // Mixed 3 element list
        SLList a4 = new SLList(Integer.MAX_VALUE, new SLList("hello49w7947w49w", new SLList(23, SLList.NIL)));
        ListVisualiser v4 = new ListVisualiser(a4);
        v4.visualise();

        // Looped list
        SLList d = new SLList(1, new SLList(11, new SLList(23, SLList.NIL)));
        loopingList(d);
        ListVisualiser z = new ListVisualiser(d);
        z.visualise();

        // 6 element looped list
        SLList a3 = new SLList(400, new SLList(22, new SLList(1, new SLList(1, new SLList(1, new SLList(1,SLList.NIL))))));
        a3 = MakeLoop(a3);
        ListVisualiser v3 = new ListVisualiser(a3);
        v3.visualise();
        System.out.println();

    }

    static SLList MakeLoop(SLList pum)
    {
        SLList l = pum;
        while(l.rest() != SLList.NIL)
        {
            l = l.rest();
        }
        l.setRest(pum);
        return l;
    }

    

}
