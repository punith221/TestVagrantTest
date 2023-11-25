import java.util.Scanner;

class Basket {
    String product;
    float price;
    float gst;
    int qnty;

    public void input(String product, float price, float gst, int qnty) {
        this.product = product;
        this.price = price;
        this.gst = gst;
        this.qnty = qnty;
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] list = new String[10];
        float[] proPrice = new float[10];
        float[] proGst = new float[10];
        int[] proQnty = new int[10];
        float discount = (float) 0.05;
        float disPrice = 500;

        for (int i = 0; i < 4; i++) {
            System.out.println("enter the Input");
            list[i] = sc.next();
            proPrice[i] = sc.nextFloat();
            proGst[i] = sc.nextFloat();
            proQnty[i] = sc.nextInt();
        }

        Basket[] arrObj = new Basket[10];
        for (int i = 0; i < 4; i++) {
            arrObj[i] = new Basket();
        }

        for (int i = 0; i < 4; i++) {
            arrObj[i].input(list[i], proPrice[i], proGst[i], proQnty[i]);
        }

        float[] priceArr = new float[4];

        for (int i = 0; i < 4; i++) {
            if (proPrice[i] >= disPrice) {
                arrObj[i].price *= discount;
            }
        }

        for (int i = 0; i < 4; i++) {
            priceArr[i] = (arrObj[i].gst) + (arrObj[i].qnty * arrObj[i].price);
        }

        float max = priceArr[0];
        int ind = 0;

        for (int i = 1; i < priceArr.length; i++) {
            if (max < priceArr[i]) {
                max = priceArr[i];
                ind = i;
            }
        }

        String maxProduct = arrObj[ind].product;

        float totalPrice = 0;

        // for (int i = 0; i < priceArr.length; i++) {
        // totalPrice += priceArr[i];
        // }

        System.out.println("Maximum gst paid for the product " + maxProduct);
        for (int i = 0; i < 4; i++) {
            float indPrice = (arrObj[i].gst) + (arrObj[i].qnty * arrObj[i].price);
            ;
            System.out.println("Total Price for " + arrObj[i].product + " is = " + indPrice);
            totalPrice += indPrice;
        }
        System.out.println("Total amount paid for the shop-keeper for all products including Gst " + totalPrice);

        sc.close();
    }
}
