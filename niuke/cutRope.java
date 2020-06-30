package niuke;

public class cutRope {
    public int CutRope(int target) {
        if (target<2) {
            return 0;
        }

        if (target==2) {
            return 1;
        }

        if (target==3) {
            return 2;
        }

        int[] products = new int[target+1];
        products[0]=0;
        products[1]=1;
        products[2]=2;
        products[3]=3;

        int max = 0;
        for (int i = 4; i <products.length; i++) {
            max=0;
            for (int j = 1; j <=i/2; j++) {
                int product = products[j]*products[i-j];
                if (max<product) {
                    max=product;
                }
                products[i]=max;
            }
        }
        return products[target];
    }
    public static void main(String[] args) {
        cutRope c = new cutRope();
        System.out.println(c.CutRope(8));
    }
}