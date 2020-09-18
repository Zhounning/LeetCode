package nowcoder;

public class Add {
    public int add(int num1,int num2) {
        int sum,carry;
        do {
            sum=num1^num2;
            carry=(num1&num2)<<1;//得到进位
            num1=sum;
            num2=carry;
        } while (num2!=0);
        return num1;
    }
}