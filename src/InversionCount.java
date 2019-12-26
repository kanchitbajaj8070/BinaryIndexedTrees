import java.util.*;

public class InversionCount {
    //solves it O(nlogn) time
    public static void main(String[] args) {

       /* int[]a={5,2,1,4,3};//4+1+1
        // we make use of BIT as a cumulative frequency array
        //we call update( a[i],1) for each i;
        //for calculating inversion call query(a[i]-1) and add to inversion count
        int maxelement=a[0];
        for (int i = 1; i < a.length; i++) {
            maxelement=Math.max(maxelement,a[i]);
        }
        FenwickTree tree= new FenwickTree(maxelement,a);
        int inversionCount=0;
        for(int i =a.length-1;i>=0;i--)
        {//check how many elements smaller than i are present
            inversionCount+=tree.query(a[i]-1);
            tree.update(a[i],1);// increment the
            tree.display();
        }*/
      // System.out.println(inversionCount);
        // this technique fails if we have negative numbers i=or if we have very large numbers
        /*
        * we need to use a technique of co-ordinate compression which
        * is basically relative ordering of elements
        * 100,99,82,11,97->[5,4,2,1,3]
        * co_ordinate compression can be done by using a set
        * remove 1 by 1 and give an index to each element*/
        coordinateCompression(new int[]{100,99,82,11,97});

    }

    private static void coordinateCompression(int[] a1) {
        int[] a= new int[a1.length];
        for (int i = 0; i <a1.length ; i++) {
            a[i]=a1[i];
        }
        Arrays.sort(a);
        Map<Integer,Integer> map= new TreeMap<>();
        int c=1;
        for(int e:a)
        {
            map.put(e,c);
            c++;
        }
        for(int i=0;i<a.length;i++)
        {
            a1[i]=map.get(a1[i]);
        }
        for (int i = 0; i <a.length ; i++) {
            System.out.print(a1[i]+"   ");
        }
        System.out.println();


    }
}
