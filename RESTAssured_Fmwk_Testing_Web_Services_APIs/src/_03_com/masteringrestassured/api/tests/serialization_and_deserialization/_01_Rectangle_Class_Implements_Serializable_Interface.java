package _03_com.masteringrestassured.api.tests.serialization_and_deserialization;

import java.io.Serializable;

/* Serialization is a process where you convert an Object instance of a class into a 
   Byte Stream. This Byte Stream can then be stored as a file on the disk or can also 
   be sent to another computer via the network. Serialization can also be used to save 
   the sate of Object when the program shuts down or hibernates. Once the state is 
   saved on disk using Serialization, we can restore the state by DeSerializing the 
   class from disk 
   If you want to use the default Java’s serialization mechanism than you should inherit 
   from Serializable functional interface only i.e. you do not need to provide an 
   implementation for the method */


public class _01_Rectangle_Class_Implements_Serializable_Interface implements Serializable
{ 
	private double height;
	private double width;
 
	public _01_Rectangle_Class_Implements_Serializable_Interface(double height, double width)
	{
		this.height = height;
		this.width = width;
	}
 
	public double Area()
	{
		return height * width;
	}
 
	public double Perimeter()
	{
		return 2 * (height + width);
	}
}