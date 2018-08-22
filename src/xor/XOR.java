/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xor;

import java.util.Scanner;

/**
 *
 * @author zhuan
 */
public class XOR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        for (int i=0;i<n;i++) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            System.out.println(calculate(a,b));
        }
    }

    private static int calculate(int a, int b) {
        int ret=0;
        int pos=1;
        int diff=b-a+1;
        for (int i=1;i<32;i++) {
            int r;
            int cycle=pos<<1;
            if (pos==1) {
                if (diff%2==1)
                    r=(diff/2+b%2)%2;
                else {
                    r=(diff/2)%2;
                }
            } else {
                int r1=a%cycle;
                if (r1>=pos) r1=r1%2;
                else r1=0;
                int r2=(b+1)%cycle;
                if (r2>=pos) r2=r2%2;
                else r2=0;
                r=(r1+r2)%2;
            }
            if (r==1)
                ret|=pos;
            pos<<=1;
        }
        return ret;
    }
    
}
