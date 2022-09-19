public class Prime {
    
 public static void main(String[] args){
        int count = 0;
        for(int i=2; i<20000; i++){
            boolean isPrime =true;
            for(int j=2; j<=(int)Math.sqrt(i); j++){
                if(i%j==0){
                    isPrime=false;
                    break;
                }
            }

            if(isPrime){
                System.out.print(i+" ");
                count++;
                if(count % 5 == 0)
                System.out.println();
            }
        
 }
 }

}
