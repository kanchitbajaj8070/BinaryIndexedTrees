public class FenwickTree {
    // why fenwick tree if we have segmant trees?
    // faster to code
    // requires less memory->O(n)
    //not all segement tree questions can be done by fenwick trees
    //BIT- FOR ODD STORES-(i,i)
    // FOR even stores-{1,2^k)
    //BIT[i]-> stores the answer for [l,r] where r=i
    // l= i-2^re+1(re-rightmost set bit pos in binary)
    // bit(1)=> r=1; l=1-1+1=1;so sum of [1,1]
    //bit(2) ; r=2; l=2-2^1+1=1;
    // for odd indexes answers always from [i,i]
    // bit ( 4 ) =4-2^2+1=1,r=4; so sum from[1,4] . so for i in powers of 2 answer is
    // [1,i] if i is power of 2. bit(6) ,r=6,l=6-2^1+1=5 so [5,6]
    // bit(i)=[i-2^r+1,i]
    // to build we use update and initialize all of BIT array with 0
    //(i&-i) always gives last set bit of i
    // update at i will take place at i , i+=(i&-i) .. so on till n
    int n;
    int[]bit;
    public void display()
    {
        System.out.println("**********************");
        for (int i = 0; i <=n ; i++) {
            System.out.print(bit[i]+" ");
        }
        System.out.println("\n*********************");
    }
    FenwickTree(int n, int []arr)
    {this.n=n;
        this.bit=new int[ n+1];
//build( n, arr)

    }
    //{7,8,1,2,9,3,4}
 public void build(int n, int[] a) {

        for (int i = 1; i <=n ; i++) {
            update(i,a[i-1]);// build takes place in nlogn
        }
        System.out.println("_----------------_");
        for (int i = 0; i <=n ; i++) {
            System.out.print(bit[i]+"   ");
        }
        System.out.println("\n_-----------_");
    }

    public void update( int i , int increment)
    {
        while(i<=this.n)
        {
            bit[i]+=increment;
            i+=(i&-i);//log n complexity as it has a jump of 2^powers
        }
    }
    public int query( int start,int end)
    {
        return query(end)-query(start-1);
    }
    //sum for 1..i
    //e g for [1..7]=>[1,4]+[5,6]+[7,7] => 111(7)=>110(6)=>100(4)==>000(0)
public int query( int i)
    {int sum=0;
        while(i>0)
        {
            sum+=this.bit[i];
            i=i-(i&-i); }
        return sum;
    }
//Range Max update
    public void maxSumUpdate( int i,int newValue)//max in[1..i]
    {
        while(i<=n)
        {
            bit[i]=Math.max(bit[i],newValue);
            i+=(i&-i);//log n complexity as it has a jump of 2^powers
        }

    }

    public int maxSumQuery( int i)
    {
        int maxe=Integer.MIN_VALUE;
        while(i>0)
        {
            maxe=Math.max(maxe,bit[i]);
            i=i-(i&-i);
        }
        return maxe;
    }

}
