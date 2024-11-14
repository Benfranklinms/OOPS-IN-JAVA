/* Create an abstract class named vehicle having abstract method calcFuelUsage, a
method display that gives name of the class and some variables wheels, year, etc.
Two subclasses Car and Motorcycle extends Vehicle having final fields maxspeed
and mileage. Values of maxspeed and mileage are given for each subclass. Find fuel
consumed in 1000km and distance travelled in 90 minutes. Write the output to
"vehiclecompare.txt" which is taken as command line argument. */

import java.io.*;
import java.util.*;


abstract class vehicle{
    public abstract double calcFuelUsage(double distance);
    static int wheels;
        static int year;
            
                public vehicle(int wheels, int year){
                    this.wheels = wheels;
                    this.year = year;
                }
                void display(){
                    System.out.println("Name of the class : "+ this.getClass().getName());
                    System.out.println("Wheels : " +wheels);
                    System.out.println("Year : " +year);
                }
            }
            
            
            
            class car extends vehicle{
                final static double maxSpeed;
                final static double mileage;
                
                    public car(int wheels, int year, double maxSpeed, double mileage){
                        super(wheels, year);
                        this.maxSpeed = maxSpeed;
                        this.mileage = mileage;
                    }
                        public static double calcFuelUsage(double distance){
                                    return distance / mileage;
                            }
                    
                            public static double distanceTravelled(double time){
                                        return time / maxSpeed;
                                    }
                            
                            }
                            
                            class motor extends vehicle{
                                final double maxSpeed;
                                final double mileage;
                                public motor(int wheels, int year, double maxSpeed, double mileage){
                                super(wheels, year);
                                this.maxSpeed = maxSpeed;
                                this.mileage = mileage;
                                }
                                public double calcFuelUsage(double distance){
                                    return distance / mileage;
                                }
                            
                                public double distanceTravelled(double time){
                                    return time / maxSpeed;
                                }
                            }
                            public class main{
                                public static void main(String[] args) {
                                    car c = new car(4, 2015, 200, 10);
                                    motor m = new motor(2, 2010, 150, 15);
                            
                                    double distance = 1000;
                                    double time = 10;
                            
                                    File file1 = new File("source.txt");
                            
                                    BufferedWriter bw = null;
                            
                                    try{
                                        bw = new BufferedWriter(new FileWriter(file1));
                                        bw.write(car.wheels);
                                    bw.write(car.year);
                            bw.write((int) car.calcFuelUsage(distance));
                    bw.write((int) car.distanceTravelled(time));
        }
        catch(IOException e){
            System.out.println("Error");
        }
    }
}