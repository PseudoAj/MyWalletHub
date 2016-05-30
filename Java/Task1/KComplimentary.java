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
          if(this.checkAr[i]+checkAr[j]==kVal && this.checkAr[i]!=checkAr[j]){//checks for the repeated values that sum up
            //System.out.println(this.checkAr[i]+","+checkAr[j]);
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
  public int isKComplimentaryHashMap(){
    int pairsCount=0;
    System.out.println("k-complimentary pairs using hashing are:");
    for(int i=0;i<this.checkAr.length;i++){
      int res=this.kVal-this.checkAr[i];
      if(myMap.getKey(res)!=null && res!=this.checkAr[i]){//checks for duplicate values
        //System.out.println(this.checkAr[i]+","+this.checkAr[myMap.getKey(res)]);
        pairsCount++;
      }
    }
    return pairsCount/2;//removing count for interchanged pairs
  }

  //Main method
  public static void main(String[] args) {
    //assign the values to the array
    int[] testArr = {54,52,-62,-60,-40,-85,15,92,61,-91};
    //int[] testArr = {-12,-88,45,43,81,22,-47,23,89,-41,88,70,-8,-38,-50,-3,-21,67,63,-6,-66,-92,38,7,-17,-5,-79,26,-71,75,12,68,70,-82,-32,-22,-20,-15,37,5,-93,33,9,-33,15,-83,-38,-95,6,-16,-53,-37,61,-81,-28,8,-67,-19,-31,-11,33,36,-96,-86,-59,-35,-90,-99,-32,-93,52,82,-39,14,31,90,-66,-39,76,-13,34,-79,11,-19,-10,-67,49,-33,-25,-58,51,-90,36,-79,-25,74,36,89,97,-33};
    //int[] testArr = {-47,-32,-67,-43,-91,88,27,-88,0,-91,-78,-60,-44,89,-37,-37,-76,2,-53,33,96,-10,-89,78,11,67,60,3,54,-52,-41,-29,-53,-58,21,45,-17,-18,-35,-74,68,-71,-57,-19,-100,-60,-3,18,-38,-34,-7,-6,0,-78,-27,4,-87,-8,60,29,-60,75,-54,-82,-34,-84,-35,-95,79,59,-40,-100,7,-87,-77,-72,98,87,69,28,9,-79,-21,-73,-20,-6,46,77,-67,20,-43,-46,-36,-44,35,-96,-78,-25,-36,71,58,-84,-90,-34,-24,-83,-84,-41,39,48,-4,44,82,-55,14,-72,-33,50,10,99,-73,97,-24,11,-84,76,-88,-54,-94,-61,-8,-8,99,-99,-1,-90,-91,3,40,-35,53,9,83,-8,-38,-4,-57,84,75,-89,21,20,75,5,-65,-86,79,49,-62,-40,-74,-51,-19,-75,54,-47,93,-70,-4,31,-42,-45,99,-27,97,1,-94,88,53,-2,-9,86,60,52,77,91,13,-34,87,19,17,68,81,-52,47,8,-6,-2,-43,-12,49,-40,-71,20,84,86,14,-47,-43,86,-80,28,92,36,50,-100,-99,-88,86,75,17,86,-81,-62,-99,14,-93,34,55,-5,-6,15,74,-45,87,89,-89,70,-58,35,85,69,-18,-65,40,28,52,98,-70,-91,40,-42,-70,-36,-15,36,-8,92,-29,68,-93,-68,-66,50,-85,0,11,99,26,74,30,-57,20,67,-35,61,39,77,-96,-96,93,-32,38,-57,-50,-83,91,-39,51,93,-99,-13,-45,5,-24,-46,4,-42,4,-85,5,64,14,-65,-22,-17,4,-51,4,8,-9,-94,21,0,82,-44,80,-78,94,58,-52,2,-75,68,-81,-93,-73,-30,31,-53,-78,50,1,-36,38,77,-7,-14,-96,-17,-17,-11,9,14,-21,-59,-99,20,88,69,37,-21,9,20,81,-51,54,-77,-97,56,-42,-75,-17,-38,75,2,-33,-34,-57,-10,6,-27,92,-75,-69,87,-63,-78,35,-97,-64,14,35,98,-34,-70,-81,25,41,-60,44,-35,-85,78,-88,58,-24,-50,-64,-41,0,-99,-59,-64,10,-21,-34,-83,-72,65,-86,-96,-9,99,30,9,-56,-45,-79,77,6,89,72,-12,-80,26,-64,-73,73,41,-69,-36,4,40,-81,-6,67,-37,41,48,89,34,-58,-12,-13,84,12,77,35,-5,-37,-20,23,15,53,-38,84,67,-99,-23,54,-73,-69,14,73,20,-20,84,61,-4,47,-8,23,63,-46,-13,73,-12,-99,96,-82,-48,33,89,-94,28,88,-93,67,-72,-13,11,-27,-81,-75,89,46,77,-38,46,48,14,-67,98,1,92,-19,-63,90,-89,43,-59,-95,-61,84,-83,93,2,-90,33,86,-32,-50,71,91,-57,17,-63,46,-7,63,-70,25,-12,87,23,-9,51,59,-45,-45,30,-4,39,-30,59,0,81,10,40,60,7,-6,-70,-62,60,-56,-40,10,39,11,94,31,51,32,40,68,60,-80,-64,61,-100,-32,-32,-37,-81,-5,46,-65,75,-76,40,-88,18,34,1,-8,60,-1,-35,-94,-60,-44,15,-27,81,68,-82,-16,-77,83,4,13,98,2,69,54,-64,51,-71,37,-18,40,-38,71,-47,15,-23,-65,67,29,66,-61,87,26,3,96,50,-57,57,-80,87,3,10,-92,59,61,-85,88,-21,82,43,32,-4,-16,25,48,86,57,-53,83,98,-83,-100,34,-32,-24,99,64,79,15,-82,97,-100,80,-12,-34,-30,27,-60,-80,-74,-96,-57,-94,0,-79,13,45,8,45,43,-17,-57,73,34,90,20,98,94,-96,-97,73,10,92,12,72,-24,43,1,-16,-75,55,-53,51,-1,-8,-67,20,2,-5,53,-44,37,-75,-83,30,11,3,7,64,-76,74,36,-7,21,23,-99,-61,-95,-68,33,-75,83,-36,47,51,-34,93,-69,40,-56,-83,-80,-96,17,17,-20,-74,30,-70,-34,-31,-33,27,-97,-14,-5,-51,75,-82,69,-37,-53,37,66,-21,99,65,14,98,38,70,-31,-25,6,56,-13,41,-98,22,-73,-77,91,-23,-55,-29,-74,59,43,-57,35,21,32,26,-77,95,-68,-97,53,2,-53,-25,95,8,31,-42,-64,63,-13,-30,-44,0,-63,-69,89,99,85,81,-86,84,14,43,-15,72,-87,-95,99,-97,-29,-95,41,21,-37,41,-100,89,-59,78,28,-4,26,72,69,23,-45,-79,-80,38,86,67,2,-72,26,-38,-13,27,-87,13,-50,-22,82,-39,-9,-36,88,19,-81,-81,46,84,50,42,35,-37,27,-44,-17,-27,73,50,-9,0,41,-82,19,95,-89,-58,34,-14,-8,-27,8,85,51,-21,11,58,-5,-11,86,-90,40,-36,13,-84,-71,30,-27,19,-37,-58,-40,-4,62,39,68,4,-69,-36,37,-14,25,96,65,-27,-98,-77,-60,-24,67,-43,-64,-88,-3,85,52,95,3,1,-61,-9,-31,83,-95,4,-31,70,60,10,1,53,-42,60,34,-10,77,-91,53,70,4,99,84,10,-15,45,21,-20,37,-85,70,-56,11,-31,-13,45,-28,-29,-34,-19,-31,56,40,74,-36,90,33,58,22,-71,70,94,15,-2,38,82,-58,67,80};
    int k=10;
    KComplimentary myTest = new KComplimentary(testArr,k);
    //Task1: run with a brute force algorithm
    long startTime = System.nanoTime();
    int pCount=myTest.isKComplimentary();
    long endTime = System.nanoTime();
    long duration = (endTime - startTime);
    System.out.println("pairs\t"+pCount+"Brute force method time:\t"+duration);
    //Task2: Hash map implementation
    long startTimeH = System.nanoTime();
    int pCountH=myTest.isKComplimentaryHashMap();
    long endTimeH = System.nanoTime();
    long durationH = (endTimeH - startTimeH);
    System.out.println("pairs\t"+pCountH+"Hash method time:"+durationH);
  }
}
