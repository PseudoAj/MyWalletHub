/*
*This class is written to obtain the K-Complimentary pairs for a
*given array of integers. This is task2 towards my assignment for
*the job with wallethub.
*@Author Ajay Krishna Teja Kavuri
*@Since 28 May 2016
*/

//Imports for bidirectional hashmap
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import java.lang.*;

//Implementation
class KComplimentary{
  //Declare variables
  int[] checkAr;
  int kVal;
  int[][] kcPairs;
  BidiMap<Integer, Integer> myMap = new DualHashBidiMap<>();
  //HashMap<Integer, Integer> myMap = new HashMap<>();

  //Intialize the variables
  public KComplimentary(int[] inputArr,int inputK){
    if(inputArr==null){
      inputArr=new int[0];//convert null into empty
    }
    this.checkAr=inputArr;
    this.kVal=inputK;
    for(int i=0;i<this.checkAr.length;i++){
      this.myMap.put(i,this.checkAr[i]);
    }
  }

  //An efficient method to check for the k-complimentary pairs
  //This uses a hashmap to optimize the performance
  //performance: O(n); as we are traversing only once and retriving using bidirectional hashmaps
  public int isKComplimentaryHashMap(){
    int pairsCount=0;
    for(int i=0;i<this.checkAr.length;i++){
      int res=this.kVal-this.checkAr[i];
      if(myMap.getKey(res)!=null && res!=this.checkAr[i]){//checks for duplicate values
        pairsCount++;
      }
    }
    return pairsCount/2;
  }

  //Main method
  public static void main(String[] args) {
    //assign the values to the array
    int[] testArr = {54,52,-62,-60,-40,-85,15,92,61,-91};
    int k=14;
    KComplimentary myTest = new KComplimentary(testArr,k);
    //Hash map implementation
    int pCountH=myTest.isKComplimentaryHashMap();
    System.out.println("pairs\t"+pCountH);
  }
}
