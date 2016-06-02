# My WalletHub   
![Logo](./Images/logo.jpg)

## "Hello World"
I am Ajay Kavuri ([pseudoaj](www.pseudoaj.com)), I am a graduate student here at West Virginia University. The solutions for the programming assignment are presented here.

## Talk is cheap show me the code
All the code is hosted on github and here is the **link: [https://github.com/PseudoAj/MyWalletHub](https://github.com/PseudoAj/MyWalletHub).** Further, following section presents the important aspects of code, the snippets reflect my thought process and output for the respective problems is also presented.

## Tools I have used for the assignment
1. **Operating system:** Ubuntu 14.04
1. **Editor:** Atom
1. **Java:** 1.8.0_91
1. Vagrant(for MySQL)
1. Scotch box(Lamp Stack)
1. Junit4
1. White board and caffine


## Solutions
### 1. Java
#### 1.1 Palindrome
**Solution snippet:**
```java
//method to check for Palindrome
public boolean isPalindrome(){
  //if it is null string it is false
  if (this.checkMeStr.length()>0){//handles null(replaced as empty) and empty strings
    return this.checkMeStr.equals(new StringBuilder(this.checkMeStr).reverse().toString());
  }
  return false;
}
```

**Tests:**

1. Case sensitive strings have been verified; ignores character attributes
1. Null and empty strings have been checked, doesn't return them as a palindrome
1. Special characters are handled; they are replaced from the character sequence

**How to run:**

1. Change directory to `java/Task1/`
2. Compile(assuming junit is installed) and run:
```java
 javac -cp .:/usr/share/java/junit4.jar PalindromeTest.java
```
```java
java -cp .:/usr/share/java/junit4.jar org.junit.runner.JUnitCore PalindromeTest
```

**Performance:**
The solution works in a linear time i.e. `O(n)` and depends on the native calls

**Notes:**

1. All the tests have been verified
1. The null string is replaced with the empty string while initialization

#### 1.2 K-Complimentary
**Solution snippet:**
Two different solutions have been tested:

Iterative:
```java
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
```

Bidirectional HashMap:
```java
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
```

**How to run:**

Compiling and run:
```java
javac -cp /home/pseudoaj/Downloads/commons-collections4-4.1/commons-collections4-4.1.jar KComplimentary.java
```

```java
java -cp /home/pseudoaj/Downloads/commons-collections4-4.1/commons-collections4-4.1.jar:. KComplimentary
```


**Performance:**
Following image depicts a simple analytics for varying size of array; clearly the Bi-directional HashMap outperforms the Iterative logic(implementation is in `other/KComplimentary.java`):

![Logo](./Images/plotTask2.png)

**Notes:**

1. use of apache commons bi-directional HashMap
1. clean code is presented under java/taks2
1. Full implementation is included in Other too
