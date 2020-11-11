# FTC Robot Coding Tutorial
## Hi
This repository (fancy word for a code project on GitHub) serves to teach you everything you need to know about how to code an FTC robot. [This GitHub organization](https://github.com/mastersnyengineering) also has all of the robot code we've written for the past three years. So, if you're ever stuck, look through the past code on the org (warning: it's very spaghetti).

## Table of Contents
Intro: talk about how to write code: the philosophy of copy and paste and a note on memorizing syntax.

[Java Crash Course](#Java Crash Course)
 * [Variables](#Variables)
 * [Printing & Comments](#Printing and Comments)
 * [Control flow](#Control Flow)
 * Arrays
 * Functions, Methods, and Classes
 
Actually coding the robots:
 * Intro
 * Explanation of the basic boilerplate
 * How to do common stuff
 * More useful boilerplate and explanation
 * How to do more common (slightly more advanced) stuff
 
Phones:
 * How to use the phones
 * How to set the name (id) of different components

[Resources](#Resources)

### Getting Started
First, you're going to need a code editor, a program that makes it easy to edit source code files. The best code editor is [Visual Studio Code](https://code.visualstudio.com/). It is very easy to download, and will be your best friend for all your coding adventures. Another really great editor is [Sublime Text](https://www.sublimetext.com/), which is more lightweight. If you want to easily run the code you write, you can use [repl.it](https://repl.it) for now.

Usually, we use OnBotJava, which is FTC's way of writing code for robots. The robot controller phone (the one on the robot) hosts a web server on it. You connect your laptop to that web server (through wifi), and then you edit code in the browser. This is good because it makes it super easy to compile all the Java code and run it on the robot with the click of a button. However, it is bad because it means that we can't use it right now, because we only have two phones and many people on the robotics team.

So, when we are learning how to code robots right now, we aren't going to have the nice features of OnBotJava, such as error messages. Unfortunately, there's no *simple* way for you to *run* your code without OnBotJava. Don't fret; you'll still learn how to code robots with just a plain text editor.

<hr />

### Java Crash Course
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
2. A variable name cannot start with a number. Example: `1motor` is invalid.
3. A variable cannot be a [reserved keyword](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/_keywords.html)

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

<hr />

### Printing and Comments
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

### Control Flow
Your code reads from top to bottom. However, control flow statements allow you to control the flow of your program. You are able to repeat code until something is true, run different code based on the value of a variable, jump around in your program, and so much more.

#### Boolean Expressions
The most basic way to "control the flow" of a program is with `if` statements. An `if` statement allows you to branch off based on whether something is true or false. That "something" is called a "boolean expression," something that is reduced to `true` or `false`. Usually, a boolean expression compares the values of two variables.

Examples:

| Operation                | Operator                   | Examples                                                | Value               |
|--------------------------|----------------------------|---------------------------------------------------------|---------------------|
| Equality                 | `==`                       | `4 == 4` <br> `2 == 3`                                  | `true` <br> `false` |
| Greater than             | `>`                        | `1.9 > 1.12` <br> `100 > 112`                           | `true` <br> `false` |
| Less than                | `<`                        | `1.12 < 1.16` <br> `4 < 2`                              | `true` <br> `false` |
| Greater than or equal to | `>=`                       | `4 >= 4` <br> `4 >= 5`                                  | `true` <br> `false` |
| Less than or equal to    | `<=`                       | You get it                                              |                     |
| String equality          | `string1.equals(string2);` | `"apple".equals("apple")` <br> `"apple".equals("orange` | `true` <br> `false` |

#### If statements
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

What if we want to test two things? That is why `else if` exists.

#### While loops

#### For loops

<hr />

### Resources
Here are some good FTC resources:

[FTC Wiki](https://github.com/FIRST-Tech-Challenge/FtcRobotController/wiki)
We wouldn't be able to write this guide if it weren't for the Wiki. It has information on literally everything, not just programming. This is also how you learn how to use the phones. Use it.

[FTC Java Docs](http://ftctechnh.github.io/ftc_app/doc/javadoc/index.html)
Everything you need to know about everything. The documentation is actually pretty nice. If there is something to know, it is in here. Use it.

[FTC Java GitHub Repo](https://github.com/FIRST-Tech-Challenge/FtcRobotController)
All the FTC Java code, and some more resources are there in the readme.
