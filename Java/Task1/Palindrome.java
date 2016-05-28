/*
*
*This class is written to obtain the pallindrome for a
*given string. This is task1 towards my assignment for
*the job with wallethub.
*@Author Ajay Krishna Teja Kavuri
*@Since 27 May 2016
*/

//Implementation
public class Palindrome{
  //Main string to be tested for a palindrome pattern
  public String checkMeStr;

  //Instantiate the clasws
  Palindrome(String caseStr){
    if (caseStr!=null){//check for the null string
      this.checkMeStr=caseStr.replaceAll("[^a-zA-Z ]", "").toLowerCase();//Handles case sensitivity and replaces the punctuation
    }
    else{
      this.checkMeStr="";//assign as empty if null
    }
  }

  //method to check for Palindrome
  public boolean isPalindrome(){
    //if it is null string it is false
    if (this.checkMeStr.length()>0){//handles null and empty strings
      return this.checkMeStr.equals(new StringBuilder(this.checkMeStr).reverse().toString());
    }
    return false;
  }

  //Main methid to create the object and check for the functionality
  public static void main(String[] args){
    //For n arguments check if it is a palindrome
    for (String s: args){
      Palindrome myTest=new Palindrome(s);
      System.out.println(myTest.isPalindrome());
    }

  }

}
