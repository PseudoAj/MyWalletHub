/*
*This class is written to obtain the K-Complimentary pairs for a
*given array of integers. This is task2 towards my assignment for
*the job with wallethub.
*@Author Ajay Krishna Teja Kavuri
*@Since 28 May 2016
*/

//Imports for hashmap stuff
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
//import java.util.*;

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
    this.checkAr=inputArr;
    this.kVal=inputK;
    for(int i=0;i<this.checkAr.length;i++){
      this.myMap.put(i,this.checkAr[i]);
    }
  }

  //method to actually check for the k-complimentary pairs
  //This is a brute force implementation
  //performance: O(n^2); as we are traversing the array twice
  public int isKComplimentary(){
    int pairsCount=0;
    System.out.println("k-complimentary pairs are:");
    for(int i=0; i<this.checkAr.length; i++){
      for(int j=0; j<this.checkAr.length; j++){
        if(i<j){//avoids generating interchanged pairs and same value
          if(this.checkAr[i]+checkAr[j]==kVal && this.checkAr[i]!=checkAr[j]){//checks for the duplicate values
            System.out.println(this.checkAr[i]+","+checkAr[j]);
            pairsCount++;
          }
        }
      }
    }
    return pairsCount;
  }

  //An efficient method to check for the k-complimentary pairs
  //This uses a hashmap to optimize the performance
  //performance: O(n); as we are traversing only once and retriving using bidirectional hashmaps
  public void isKComplimentaryHashMap(){
    BidiMap<Integer, Integer> invMyMap=this.myMap.inverseBidiMap();
    System.out.println("k-complimentary pairs using hashing are:");
    for(int i=0;i<this.checkAr.length;i++){
      int res=this.kVal-this.checkAr[i];
      System.out.println(i+","+res);
      //if(invMyMap.get(res)!=null && res!=this.checkAr[i]){//checks for duplicate values
        //System.out.println(i+","+res);
      //}
    }
  }

  //Main method
  public static void main(String[] args) {
    //assign the values to the array
    int[] testArr = {9,6,2,3,-1,1,7,5,6,6,14};
    int k=12;
    KComplimentary myTest = new KComplimentary(testArr,k);
    myTest.isKComplimentary();
    myTest.isKComplimentaryHashMap();
  }
}
