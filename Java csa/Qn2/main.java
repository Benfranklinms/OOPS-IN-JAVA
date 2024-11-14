/* Create an abstract class named vehicle having abstract method calcFuelUsage, a
method display that gives name of the class and some variables wheels, year, etc.
Two subclasses Car and Motorcycle extends Vehicle having final fields maxspeed
and mileage. Values of maxspeed and mileage are given for each subclass. Find fuel
consumed in 1000km and distance travelled in 90 minutes. Write the output to
"vehiclecompare.txt" which is taken as command line argument. */

import java.io.*;
import java.util.*;

abstract class vehicle{
    abstract void calcFuelUsage()
}