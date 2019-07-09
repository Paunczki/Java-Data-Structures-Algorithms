// Before the class begins you can import packages you want to use
// in this case I am calling the Math package which allows for many cool math tools
// https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html
import java.lang.Math;
// If you want to pull an entire package 
// (for example the entire lang class instead of just the math language)
// You put a '*' where Math is to indicate the entire package
import java.lang.*;

// This notation will most likely be used with our data structures
// Java has built in data structures which can be found in java.util
import java.util.*;
// It is safe to pull the whole util package because usually you are 
// using more than one data structure
// if you want a certain data structure from the util package visit 
// this link and find the structure you want
// https://docs.oracle.com/javase/8/docs/api/java/util/package-summary.html
// Example:
import java.util.ArrayList;

public class basics{
    // Naming Convention
    //  Class names should start with capital letters and every new word in 
    //     the name is also initially capitalized. → e.g. TestClass
    //  Variable names always start with small-case letter and every new 
    //     word initially capitalized.
    //  For example, if we want to create a String variable to describe what 
    //     it is, say it is your First Name, we would write it as
    //          firstName
    //  And say we want to name it "the sky is blue" it would be 
    //          theSkyIsBlue


    // Visibility Modifiers
    //     Public - Any class can access
                public int alpha = 7;
    //     Private - Only visible within the class
                private int beta = 8;
    //     Protected - Visible to the class
                protected int gamma = 9;
    //     Default - Package visibility - all files in the folder can access
                // default int delta = 10;
                // commented out to eliminate possibility of error message


    // Local Variables / Stack Variables
    //     Static variables - class variable
            public static int epsilon = 1;
            // static means it will be held constant throughout any iteration
            // of this class
            // so if you were to make an object, this variable would be the same
            // for every object that builds from that class
    //     Non static variables - instance variables
            public int zeta = 2;
            // non static means each object built from this class can be different
    // For object methods (non-static, instance) you must use an object prefix 
    //    for invocation of the method. 
    // For static method (class method), no need to use an object prefix for 
    //    calling the method.
    
    
    // Scope of a variable - controls the naming (this would be the curly braces)
    // The scope is to know the extent of a function, method, class, etc.
    // by default java recognizes the end of a function with the semicolon (;)
    //   but for a statement (such as this class), it uses the curly braces 
    //   to know when it has ended


    // String S  = new String(“cat”); s is a reference to a string object
    // String p = “cat”; p is the string literal
    // Every time you use the new, you carve out out more memory to use
    // This can be bad as it will take up more memory and slow down your process
    

    // To Check equality between ...
    // References       use...              ==
    // Objects 	        use...       .equals() method


    // Type conversion includes different things:
    // Straight up conversion of int to string etc.
    // Casting using(...)
        Integer eta = new Integer(7); // note this is an Integer object!
        String theta = eta.toString();
        // Casting is forcing or coaxing an operand to a different related type
        // FullTimeEmployee class
        // HourlyEmployee is a subclass of FullTimeEmployee
        // FullTimeEmployee fte = new FullTimeEmployee();
        // HourlyEmployee he = new HourlyEmployee();
        // FullTimeEmployee g = he;
        //      here compilation will succeed and runtime will be fine as well
        //      Also polymorphism
        // HourlyEmployee h = (HourlyEmployee) fte;
        //      compile time ok, but runtime will fail

    // Boxing and unboxing (making or unmaking an object)
                int iota = eta; 
        // taking an Integer object and saving it as an int
        // this is unboxing
        // Unboxing goes from an object type to a primitive type
                Integer kappa = iota;
        // taking an int and saving it as an Integer object
        // this is boxing
        // Boxing is a way to upgrade a primitive type to an object type

    // Interface → implements
    // Subclassing → extends
    // Subclass inherits variables and method from the parent (super) class
    // super(); calls the initial constructors from parent class
    // overriding is associated with subclasses.
    //  Whereas overloading can occur in any class.
    //  In the same class, you can two different methods with the same name but different say parameters.

}