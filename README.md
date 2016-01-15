#filter-duplicates
Provides multiple implementations to filter the duplicates from the given interger array.

**Submitted by**
Raju

**Tech Stack**
```
Java 1.7
Maven
```

**Steps to build and run tests*
```
mvn clean install
```

```
1. Given the following class, write 3 methods that can be used to return an array that has no duplicates.
   Provided 3 implementation methods for the given problem statement.
2. You should define a method signature that you feel is appropriate to the problem.
    a.removeDuplicates
    b.removeDuplicatesAndRetainOrder
    c.removeDuplicatesAndSort
3. We would prefer to see three implementations (one that should take into consideration #4 below) and an explanation of what use-cases are suitable to each implementation 
    a.removeDuplicates -Removes duplicates using set implementation.
    b.removeDuplicatesAndRetainOrder -Removes duplicates using set implementation and retains the insertion order.
    c.removeDuplicatesAndSort -Removes duplicates and sorts the elements using set implementation.
4. What if we need to retain the original order?
    removeDuplicatesAndRetainOrder method provides the implementation of this usecase.
5. What are the positives and negatives of your solution?
    Positives - Used collections Set API implementation for the given problem statement.
            - Implemented log4j console appender to log the responses.
            - Created maven project with JUnits to test the solution.
    Negatives - Problem statement is not provided whether if we have to use existing collection API implementation or not.
a. Can you implement it another way so as to avoid the negatives?
    Yes, provided implementation using quicksort and filtered duplicates.
    removeDuplicatesUsingSortAndFilter method has this usecase implementation.
6. Your solution should be testable and “production ready.”
    It is a maven project and when you ran mvn clean install the deployable artifact(production ready) will be generated in the target dir after running the JUnit tests.
```
