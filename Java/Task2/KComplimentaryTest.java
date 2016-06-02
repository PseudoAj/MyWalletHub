/*
*This class is written to test the KComplimentary class
*This is task2 towards my assignment for
*the job with wallethub.
*@Author Ajay Krishna Teja Kavuri
*@Since 29 May 2016
*/
//Import the JUnit
import org.junit.Test;
import static org.junit.Assert.*;//why static? just to have static elements of this interface in scope

//Test Implementation
public class KComplimentaryTest{
  @Test
  //1. Tests to make sure the null and empty arrays are handled efficiently
  public void testNullEmpty(){
    //test for null array
    int[] testArr1 = null;
    int k1=14;
    KComplimentary testNullEmptyCase1 = new KComplimentary(testArr1,k1);
    assertEquals(0,testNullEmptyCase1.isKComplimentaryHashMap());
    //empty array
    int[] testArr2 = new int[0];
    int k2=14;
    KComplimentary testNullEmptyCase2 = new KComplimentary(testArr2,k2);
    assertEquals(0,testNullEmptyCase2.isKComplimentaryHashMap());
  }

  @Test
  //2. Tests for the k-value to be zero and negetive
  public void testKVal(){
    //test for zero k-value
    int[] testArr1 = {54,52,-62,-60,-40,-85,15,92,61,-91,91};
    int k1=0;
    KComplimentary testKVal1 = new KComplimentary(testArr1,k1);
    assertEquals(1,testKVal1.isKComplimentaryHashMap());
    //negetive value
    int[] testArr2 = {54,52,-62,-60,-40,-85,15,92,61,-91,-91};
    int k2=-10;
    KComplimentary testKVal2 = new KComplimentary(testArr2,k2);
    assertEquals(1,testKVal2.isKComplimentaryHashMap());

  }

  @Test
  //3. Tests for the duplicates and the repeated pairs
  public void testRep(){
    //test for repeated sequence; here 91 occurs twice but only once we need the pair counted
    //expecting 2 pairs: (-81,91),(95,-85)
    int[] testArr1 = {54,95,-81,-60,-40,-85,15,92,61,91,91};
    int k1=10;
    KComplimentary testRep1 = new KComplimentary(testArr1,k1);
    assertEquals(2,testRep1.isKComplimentaryHashMap());
    //Several repeating arrays
    int[] testArr2 = {101,-91,-91,-91,-91,-91,-91};
    int k2=10;
    KComplimentary testRep2 = new KComplimentary(testArr2,k2);
    assertEquals(1,testRep2.isKComplimentaryHashMap());
  }
}
