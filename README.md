
# FTC Robot Coding Tutorial
## Welcome
This repository/repo (fancy word for a code project on GitHub) serves to teach you everything you need to know about how to code an FTC robot. There are two main parts: a Java Crash course, and the FTC programming guide. FTC robots are written in Java, so you can't code robots without knowing some basic Java. Luckily, robot code isn't complicated. You don't need to worry about complex inheritance trees or pointer arithmetic--90% of the code is basic if-statements and function calls. So, the Java crash course only covers the parts of Java that are necessary in coding a functional robot. The second part of this repo is to teach how to actually write FTC robots, not just generic Java. FTC provides a code *library* which allows for easy control of every component of a robot (motors, sensors, controller, etc). Finally, I have included some very helpful resources at the end, which you shold definitely consult frequently. [This GitHub organization](https://github.com/mastersnyengineering) also has all of the robot code we've written since we started with FTC. So, if you're ever stuck, look through the past code on the org.

## Table of Contents
- [FTC Robot Coding Tutorial](#ftc-robot-coding-tutorial)
  * [Welcome](#welcome)
  * [Table of Contents](#table-of-contents)
  * [Getting Started](#getting-started)
    + [Coding - a high-level overview](#coding---a-high-level-overview)
  * [Java Crash Course](#java-crash-course)
    + [Variables](#variables)
      - [Using Variables](#using-variables)
  * [Printing and Comments](#printing-and-comments)
  * [Control Flow](#control-flow)
    + [If statements and Boolean Expressions](#if-statements-and-boolean-expressions)
    + [If statements](#if-statements)
    + [For and While loops](#for-and-while-loops)
    + [Functions, methods, and classes](#functions--methods--and-classes)
  * [Resources](#resources)
- [Note to self: tinker with](#note-to-self--tinker-with)

## Getting Started
First, you're going to need a code editor, a program that makes it easy to edit source code files. The best code editor is [Visual Studio Code](https://code.visualstudio.com/). It is very easy to download, and will be your best friend for all your coding adventures. Another really great editor is [Sublime Text](https://www.sublimetext.com/), which is more lightweight. If you want to easily run the code you write, you can use [repl.it](https://repl.it) for now.

Usually, we use OnBotJava, which is FTC's way of writing code for robots. The robot controller phone (the one on the robot) hosts a web server on it. You connect your laptop to that web server (through wifi), and then you edit code in the browser. This is good because it makes it super easy to compile all the Java code and run it on the robot with the click of a button. However, it is bad because it means that we can't use it right now, because we only have two phones and many people on the robotics team.

So, when we are learning how to code robots right now, we aren't going to have the nice features of OnBotJava, such as error messages. Unfortunately, there's no *simple* way for you to *run* your code without OnBotJava. Don't fret; you'll still learn how to code robots with just a plain text editor.

### Coding - a high-level overview

/* TODO: talk about how to write code: the philosophy of copy and paste and a note on memorizing syntax.*/

## Java Crash Course
Really, the code for robots isn't very complicated. You are not going to need to use any advanced programming skills. All you need to know to code a great robot is the basics: variables, inputs/outputs, control flow, and classes/objects.

### Variables
There are two parts to a program: the data, and the logic. Variables allow you to store any kind of data, modify that data, use that data in different parts of your program, and much more.

There is a very important concept in Java (and every other lang) that is very important to understand: data types (also called types). Every variable in Java has a *type* attached to it. What is a type? Simply put, a type describes *what kind of data* is being stored in a variable. It will make more sense with some examples. So, here are some of the most common types that you will be using when coding your robot:

| Type    | What is it                         | Examples                                | Not examples                 |
|---------|------------------------------------|-----------------------------------------|------------------------------|
| int     | An integer                         | `4` `-2` `-9` `32497` `69420`           | `3.141` `2.71` `69.420`      |
| boolean | A true or false value              | `true` `false`                          | `23` Literally anything else |
| float   | A decimal value                    | `23.12` `-3.00000123`                   | `false`                      |
| String  | A piece of text (within quotes "") | `"Hello world"` `"I am awesome"` `"14"` | `54`                         |

Now that you know what a type is, what is a variable? A variable is a thing that holds a piece of data of a certain type. Every variable also has a name that you refer to the variable by. Examples:

Let's say you want to create a variable that holds the text "Whats up?!". This is how you do that:
```java
String my_variable = "Whats up?!";
```

First, we declare the variable's type. In this case, because we want to store a piece of text, the type of our variable is going to be a `String`. You need to specify the type of every single variable you create, or else Java won't know what type of data should be stored in the variable.
Next, we declared the variable's name: `my_variable`. This is the name that you use in your code to refer to this variable. You can name your variable almost anything you want, but there are some rules about naming variables.
1. No spaces in variable names. Use underscores instead.
2. No special characters like `!@#$%^&*(` etc...
3. A variable name cannot start with a number. Example: `1motor` is invalid.
4. A variable cannot be a [reserved keyword](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/_keywords.html)

Also, most lines of code in Java end with a semicolon (`;`). More on that later.

Here are some examples of creating variables:

```java
String school = "Masters";
int pi = 3;
float actual_pi = 3.14159;
boolean covid_free = true;
```

If the type you supply does not match the value you give, then Java will throw an error.
Examples:

``` java
int g = 9.8;
```
The Java "compiler" will say something like:
```
error: incompatible types: float cannot be converted to int.
```

#### Using Variables
This will become much more clear once we start actually doing stuff. To change the value of a variable after declaring it, you don't need to specify the type again.

``` java
// Declare the variable here
String note = "hi how are you";

// Then there could be hundreds of lines of code here

// Then you can change your variable whenever you want
note = "are you doing well?";

note = "how is your day?";

note = "i am awesome :D";
```
Java is also a nice calculator.
 - `+` adds
 - `-` subtracts
 - `*` multiplies
 - `/` divides
 
Example:

``` java
float x = 10 * 12 / (3 + 4);

float y = 12 + 100 - (23/4);

float z = x + 2*y - 16 + 3/y;

```

## Printing and Comments
To print something to the screen:

``` java
System.out.println("hello world");
System.out.println(4);
```
This will just print text to the screen. It isn't too important here, because this won't work when programming an FTC robot (more on that later).

To write a comment, simply use `//`. A comment allows you to write a note in your code. Comments don't have any effect on anything. They don't change how your code functions. But it is a good idea to put comments in your code whenever you want to note something.
Examples:

``` java
// I am a comment! I don't do anything!

int x = 3; // Set x to 3

/*
    I am a multi-line comment!
    You can write many lines of comments in here without needing
    to type // at the start of every line
    
    Nice.
*/
```


<hr />

## Control Flow
Your code reads from top to bottom. However, control flow statements allow you to control the flow of your program. You are able to repeat code until something is true, run different code based on the value of a variable, jump around in your program, and so much more.

### If statements and Boolean Expressions
The most basic way to "control the flow" of a program is with `if` statements. An `if` statement allows you to branch off based on whether something is true or false. That "something" is called a "boolean expression," a statement that is reduced to `true` or `false`. Usually, a boolean expression *compares* the values of two variables. These are also often called *conditions*.

Examples:

| Operation                | Operator                   | Examples                                                | Value               |
|--------------------------|----------------------------|---------------------------------------------------------|---------------------|
| Numerical Equality       | `==`                       | `4 == 4` <br> `2 == 3`                                  | `true` <br> `false` |
| Greater than             | `>`                        | `1.9 > 1.12` <br> `100 > 112`                           | `true` <br> `false` |
| Less than                | `<`                        | `1.12 < 1.16` <br> `4 < 2`                              | `true` <br> `false` |
| Greater than or equal to | `>=`                       | `4 >= 4` <br> `4 >= 5`                                  | `true` <br> `false` |
| Less than or equal to    | `<=`                       | You get it                                              |                     |
| String equality          | `string1.equals(string2);` | `"apple".equals("apple")` <br> `"apple".equals("orange` | `true` <br> `false` |

### If statements
Now, we can make an if statement. Here is the general format for an if statement:

``` java
if (expression) {
    // Do something (if the expression is true)
} else {
    // Do something else (if the expression is false)
}
```

First, the expression is evaluated. If the expression is `true`, then the code in the first set of `{}` will run. If the expression is `false`, then the code in the second set of `{}` will run. Note that you can put any code in the `{}`.

Here is an example:
``` java
if (3 > 2) {
    System.out.println("this code will run");
} else {
    System.out.println("this code will never run because the expression 3 > 2 is always true");
}
```
Output:

```
this code will run
```

First, Java will evaluate `3 > 2`. Since three is greater than two, this expression is `true`. Because the expression is true, the code "in the if" (the first set of `{}`) will run. The code "in the else" (the second set of `{}`) will not run.

Here is another example:

``` java
String my_name = "Mario";

String my_friends_name = "Peach";

if (my_name.equals(my_friends_name)) {
    System.out.println("Mario is Peach? that's not possible...");
} else {
    System.out.println("Why would Mario be Peach?");
}
```
In this example, we first create two strings. One is called `my_name` and it stores the value `"Mario"`. One is called `my_friends_name` and it stores the value `"Peach"`.

Then, we compare if the two are equal. Because the strings are obviously *not* equal, the code in the `else` will run, printing `"Why would Mario be Peach?"`.

What if we want to test two things? That is why `else if` exists:
```java
String my_name = "Alice";

String my_friends_name = "Bob";

String your_name = "Eve"; // Change this for a different result

if (my_name.equals(my_friends_name)) {
    System.out.println("I have the same name as my friend");
} else if (my_name.equals(your_name)) {
    System.out.println("I guess we have the same name"); // This will run with your_name = "Alice"
} else {
    System.out.println("Looks like my name (Alice) is unique");
}
```

First, the if statement will check the first condition: `my_name.equals(my_friends_name)`. If this statement is true, then it will print "I have the same name as my friend", and the if statement will end (meaning, none of the other branches of the if statement will even be considered (the `else if` and the `else`)).

If the first condition is false, meaning if `my_name` is NOT equal to `my_friends_name`, then Java will check the second condition: `my_name.equals(your_name)`. The process repeats. If this condition is true, then "I guess we have the same name" will print, and the `else` will not run.

If the second condition is false, then the code in the `else` will run, printing "Looks like my name (Alice) is unique".

You can chain an infinite number of `else if`s together:
```java
if (my_name.equals(my_friends_name)) {
    System.out.println("I have the same name as my friend");
} else if (my_name.equals(your_name)) {
    System.out.println("I guess we have the same name"); // This will run with your_name = "Alice"
} else {
    System.out.println("Looks like my name (Alice) is unique");
}
```


### For and While loops
These aren't too important, and you shouldn't use them unless you have a very good reason to use them in FTC.

Briefly, a while loop runs the code within it until a given condition is false. Example:
```java
while (condition) {
    // This code will run only when the condition is true.
}

while (10+5 == 15) {
    // This code will run FOREVER, because 10+5 is always equal to 15.
}
```

<u>**Exercise**</u><br>
How many times will this loop run until it stops?
<details>
    <summary>See answer</summary>
    Correct answer: 5. First, we set an integer `i` to equal `0`. Then, inside a while loop, we increment `i` until `i` equals `5`. When `i` equals `5`, then the loop will stop, because the condition `i != 5` will be false.
</details>

For loops are very similar to while loops. In fact, every for loop *could* be written with a while loop, but for loops are often more convenient for certain jobs. One instance where for loops are often used is when you want to do something a fixed number of times. There is a lot to digest in the syntax, so let's take a look:
```java
for (int i = 0; i < 10; i++) {
    // Code inside
}
```

This creates a for loop that will run exactly 10 times. So, whatever code you put inside the for loop will run 10 times. Many/most of the for loops you write will look something like this.

However, there is one more thing going on here: `i`. First, the for loop creates an integer `i`, and sets `i` initially equal to `0`. Know that `i` exists only in the scope of the for loop, meaning you will not be able to use `i` outside of the for loop. Next, you give the for loop a *condition*, just like the conditions [talked about earlier](#if-statements-and-boolean-expressions). This condition is exactly like the condition in a while loop: when the condition is false, the loop stops. So, as long as the condition is true, the loop will continue to run. But you may ask, "Why doesn't the loop run forever if we just set `i=0`? Obviously `0 < 10`, and that condition is always true." This is where the third part of the loop comes in: `i++` (note: `i++` is the same as saying `i = i + 1`, which just increments the value of `i` by `1`). The third part of the loop specifies the code to be run on each iteration of the loop. This is the key difference with for loops. After one full iteration of the loop (so, one time of the code running inside), this `i++` code will run, adding `1` to `i`.

So, `i` is essentially a counter, keeping track of the number of times that the for loop has been run so far. Note that `i` often starts at `0`, but it doesn't have to. `i` is just like a regular integer, except every time the for loop runs, `i` increases by `1`. That is what the `i++` describes.

<u>**Exercise**</u><br>
What will the following code print?
```java
for (int i = 0; i < 6; i++) {
    System.out.println(i * 2);
}
```
<details>
    <summary>See answer</summary>
    Correct answer: this loop will print
```java
0
2
4
6
8
10
```
This is because `i` will be `0`, then `1`, then `2`, then `3`, then `4`, then `5`. The loop prints out `i * 2`.
</details>

### Functions, methods, and classes
TODO

## Resources
Here are some good FTC resources:

[OctoBot code](https://github.com/mastersnyengineering/Tutorial/tree/main/code/OctoBot.java). This is a heavily-commented version of last year's OctoBot. There are comments describing what every line does. If you understand this file, then you understand (almost) everything you need to know about coding FTC robots.

[FTC Wiki](https://github.com/FIRST-Tech-Challenge/FtcRobotController/wiki)
We wouldn't be able to write this guide if it weren't for the Wiki. It has information on literally everything, not just programming. This is also how you learn how to use the phones. Use it.

[FTC Java Docs](http://ftctechnh.github.io/ftc_app/doc/javadoc/index.html)
Everything you need to know about everything. The documentation is actually pretty nice. If there is something to know, it is in here. Use it.

[FTC Java GitHub Repo](https://github.com/FIRST-Tech-Challenge/FtcRobotController)
All the FTC Java code, and some more resources are there in the readme.

[Great example code](https://github.com/trc492/FtcSamples/tree/master/FtcSampleCode/src/main/java/samples) Great sample code for everything you'll ever need to do (well, almost).

[More example code](https://github.com/trc492/FtcSamples/tree/master/FtcRobotController/src/main/java/org/firstinspires/ftc/robotcontroller/external/samples) More sample code (from the same repo).

The OnBotJava environment is also equipped with an example code folder. That is another great resource.

These are two simulators which try to simulate the FTC robotics environment. While we are online, these might be helpful.
[FTC Simulator App 1](https://github.com/MatiasGoldfeld/Team4654-Robot-Simulator)

[FTC Simulator App 2](https://github.com/Beta8397/virtual_robot)

