package shashi.java.core;

import java.util.*;

class ChocolateStation {
 public static void main(String args[] ) throws Exception {
    
     Scanner s = new Scanner(System.in);
     int T = s.nextInt();
     
     for(int i=0; i<T; i++){
         s.nextLine();
         int N = s.nextInt();
         int P = s.nextInt();
         long[] choc = new long[N+1];
         choc[0]=0;
         long totBuy = 0;
         long curChoc = 0;
         for(int j=1; j<=N; j++){
             choc[j] = s.nextInt();
             long update = choc[j-1] - choc[j];
             long buy=0;
             if(update>-1)
                 curChoc+=update;
             else{
                 curChoc+=update;
                 if(curChoc<0){
                     buy+=(curChoc*-1);
                     curChoc=0;
                 }
             }
             totBuy += buy;
         }
         System.out.println(totBuy*P);
     }
     s.close();
 }
}
