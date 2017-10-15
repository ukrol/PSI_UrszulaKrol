import java.util.Random;

public class ArtificialNeuron {
	
	public double weights[];//wagi
	public double x[][] = {{2,-3}, {4,6}, {0,-1}, {5,-8}, {3,9}, {-1,8}, {4,-3}, {6, -7}, {0, 0}, {8, -2}};//tablica danych wejscia x do uczenia
	public int w = 10; //wiersze tablicy
	public int k = 2; //kolumny tablicy
	public double target_result[] = {0,1,0,0,1,1,1,0,0,1}; //1 lub 0
	public double out_data=0; //dane wyjsciowe
	public double error;
	public double test_data[][];
	public int number_of_testing_data = 10;
	
    private void random_weights() {
    	int n = 2;
    	weights=new double[n];
    	Random random = new Random();
    	for(int i=0; i<n; i++){
        weights[i] = random.nextDouble() * 2 - 1;
    	}
    	System.out.println("Weights: ");
    	for (int i = 0; i < n; i++) {
        System.out.println(weights[i]);

        }
    }
	
    public void learn(double learning_rate){ 
    	int iteration = 0;
    	random_weights();
    	do {
    		iteration++;
    		System.out.println("*****" + iteration + "*****");
			for (int i = 0; i < w; i++){
    			out_data = check(x[i][0],x[i][1]);
    			error = target_result[i]-out_data;
    			weights[0] += learning_rate * error * x[i][0]; //obliczanie wag
    			weights[1] += learning_rate * error * x[i][1];

    			System.out.println(x[i][0] + " " + x[i][1] + " " + target_result[i] + "    Result: "+ out_data );
    		}
    	} while(error>0.01);
   }

   private double check(double x1,double x2){
	   
	   double sum = 0;
	   sum = x1 * weights[0] + x2 * weights[1];

        if(sum>0) { //czy suma jest dodatnia
        	sum = 1;
        }
        else {
        	sum = 0;
        }
        return sum;
    }
   
   public void test(){
	   Random rand = new Random();
	   test_data = new double[number_of_testing_data][k];
       for(int i=0; i<number_of_testing_data; i++){
           test_data[i][0]=rand.nextInt(20)-10;
           test_data[i][1]=rand.nextInt(20)-10;
       }
       System.out.println("Checking if the sum of this two numbers is a positive number: ");
       System.out.println("Testing...");
       for(int i=0; i<number_of_testing_data; i++){
    	   System.out.println(test_data[i][0] + " " + test_data[i][1] + "    Test result: " + check(test_data[i][0], test_data[i][1]));
       }
   }
}