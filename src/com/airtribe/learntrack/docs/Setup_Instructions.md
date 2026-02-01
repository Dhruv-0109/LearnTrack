#Setup Instructions


JDK version used : 
    JDK: Homebrew OpenJDK 22.0.2 (aarch64)
    The JDK was installed using Homebrew and configured as the Project SDK in IntelliJ IDEA.
    The JDK version was verified using the IntelliJ terminal with the following command: "java -version" 


How to Run "Hello World" program:
    1. create a class with name as "HelloWorld.java"
    public class HelloWorld {
        public static void main(String[] args) {
            System.out.println("Hello, World!");
        }
    }
    2. Compile the Program: javac HelloWorld.java
    3. Execute the Program: java HelloWorld
    4. Output: "Hello, World!" would be printed on the console