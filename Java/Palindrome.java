/*
*This clas is written to obtain the pallindrome for a
*given string.
*/
class Palindrome
{
  //Main string to be tested for a palindrome pattern
  String checkMeStr;

  //Instantiate the clasws
  Palindrome(String caseStr)
  {
    this.checkMeStr=caseStr;
  }

  //dumb method to check for Palindrome
  public boolean isPalindrome()
  {
    return this.checkMeStr.equals(new StringBuilder(this.checkMeStr).reverse().toString());
  }

  //Main methid to create the object and check for the functionality
  public static void main(String[] args)
  {
    Palindrome myTest=new Palindrome("ajay");
    System.out.println(myTest.isPalindrome());

  }

}
