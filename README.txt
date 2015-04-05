Requirements to run dgonzalez42's Assignment 3 code

==================
Weka Code

Important time-saving notes:
- If preferred, my code (and data) can be cloned from Github:  https://github.com/dgonzalez42/CS7641_Assignment3.git
- My code is long-running.  It runs with all algorithms and all logging options on.  If preferred, I can
     explain how to run section of the code by commenting our the long-running options.


BUILD PATH

My implementation is based on Java 1.8 (1.8.0_31) and Weka 3.7.12.  Both must be in the Build Path.


SET-UP

All data (provided) must reside in the (root)/data directory.


EXECUTION

My code is delivered with an Eclipse .project file, if the graders would like to import into Eclipse.

To run from a command line, assimng the Build Path above, from the root directory:

Compile:
In general:  javac -d bin -sourcepath src -cp ( Location of weka.jar ) src/gatech/cs7641/dgonzalez42/assignment3/Assignment3.java
Example:  javac -d bin -sourcepath src -cp "/Program Files/Weka-3-6/weka.jar" src/gatech/cs7641/dgonzalez42/assignment3/Assignment3.java

Execute:
In general:  java -cp bin;( Location of weka.jar ) gatech/cs7641/dgonzalez42/assignment1/Assignment1
Example:  java -cp bin;"/Program Files/Weka-3-6/weka.jar" gatech/cs7641/dgonzalez42/assignment1/Assignment1

========================

ABAGAIL Code

Important time-saving notes:
- If preferred, my code (and data) can be cloned from Github:  https://github.com/dgonzalez42/ABAGAIL.git
  - Use Branch "Assignment3" (Commit: 7bb57910f748ef5e6b94b776b9b35bbf1b202f5b)
- My code requires some hardcoded parameter changes to perform various tests on parameter changes.  If preferred, I can
     explain how to run sections of the code.


BUILD PATH

My implementation is based on Java 1.8 (1.8.0_31) and ABAGAIL ( https://github.com/pushkar/ABAGAIL ).


SET-UP

All data (provided) must reside in the (root)/data directory.
All code (provided) must reside in the (root)/src/opt/test directory.


EXECUTION

My code is delivered with an Eclipse .project file, if the graders would like to import into Eclipse.

To run from a command line, assimng the Build Path above, from the root directory:

Compile:
In general:  javac -d bin -sourcepath src -cp src/opt/test/(FileName).java
Example:  javac -d bin -sourcepath src -cp src/opt/test/TravelingSalesmanTestDJG.java

Execute:
In general:  java -cp bin shared/test/(FileName)
Example:  java -cp bin ahared/test/AdultICATest


CODE

AdultICATest.java -- Independent Components Analysis on Adult dataset
AdultLDATest.java -- Linear Discriminate Analysis on Adult dataset 
IrisICATest.java -- Independent Components Analysis on Iris dataset
IrisLDATest.java -- Linear Discriminate Analysis on Iris dataset 

=============================

DATA

My data is included on GitHub and in my "code" zip file.  To prevent confusion, I also submitted the same data seperately, as requested in the assignment.


Citation:
Mark Hall, Eibe Frank, Geoffrey Holmes, Bernhard Pfahringer, Peter Reutemann, Ian H. Witten (2009); The WEKA Data Mining Software: An Update; SIGKDD Explorations, Volume 11, Issue 1. 