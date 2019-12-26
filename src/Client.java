public class Client {
    public static void main(String[] args) {
        int[]a=new int[]{7,8,1,2,9,3,4};
        FenwickTree tree= new FenwickTree(a.length,a);
        //tree.build(a.length,a);
        for (int i = 1; i <=a.length ; i++) {
            tree.maxSumUpdate(i,a[i-1]);
        }
       // tree.maxSumUpdate(3,10);
       // System.out.println(tree.maxSumQuery(5));
        tree.display();
//      /  System.out.println(tree.query(4,7);


    }
}
