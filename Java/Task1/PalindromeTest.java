/*
*This class is written to test the palindrome class
*This is task1 towards my assignment for
*the job with wallethub.
*@Author Ajay Krishna Teja Kavuri
*@Since 27 May 2016
*/
//Import the Palindrome
import org.junit.Test;
import static org.junit.Assert.*;//why static? just to have static elements of this interface in scope

//Test class
public class PalindromeTest{
  @Test
  //1. Tests to make sure the class handles the case sensitive strings
  public void evalCseSens(){
    Palindrome caseTest1=new Palindrome("AaBabaa");
    assertTrue(caseTest1.isPalindrome());
    Palindrome caseTest2=new Palindrome("AbAbAbbbAA");
    assertFalse(caseTest2.isPalindrome());
    Palindrome caseTest3=new Palindrome("Sore was I ere I saw Eros");
    assertTrue(caseTest3.isPalindrome());
  }

  @Test
  //2. Check for the null and empty strings
  public void evalEmptNull(){
    Palindrome enTest1=new Palindrome(null);
    assertFalse(enTest1.isPalindrome());
    Palindrome enTest2=new Palindrome("");
    assertFalse(enTest2.isPalindrome());
  }

  @Test
  //3. Check for the special characters, palindrome strings should ignore the special characters if any
  public void evalSplChrs(){
    Palindrome spTest1=new Palindrome("#a@@bbbbb&*()a");
    assertTrue(spTest1.isPalindrome());
    Palindrome spTest2=new Palindrome("%%%^#@abhjbsajlkdblkj#6584^bkjbsaf59676oi)((7y6ibkb))");
    assertFalse(spTest2.isPalindrome());
  }

}
