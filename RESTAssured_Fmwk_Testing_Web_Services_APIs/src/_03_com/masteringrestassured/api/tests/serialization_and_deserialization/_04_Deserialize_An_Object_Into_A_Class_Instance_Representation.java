package _03_com.masteringrestassured.api.tests.serialization_and_deserialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/* The objective is to read the Serialized byte stream from the file and 
 * convert it back into the Class instance representation */

public class _04_Deserialize_An_Object_Into_A_Class_Instance_Representation 
{
	public static Object DeSerializeFromFileToObject(String fileName)
	{
		try 
		{
			/* Step 1: Create a file input stream to read the serialized content
			   of rectangle class from the file */
			FileInputStream fileStream = new FileInputStream(new File(fileName));

			/* Step 2: Create an object stream from the file stream. So that the content
			   of the file is converted to the Rectangle Object instance */
			ObjectInputStream objectStream = new ObjectInputStream(fileStream);

			// Step 3: Read the content of the stream and convert it into object
			Object deserializeObject = objectStream.readObject();

			// Step 4: Close all the resources
			objectStream.close();
			fileStream.close();

			return deserializeObject;
		} 
		catch (FileNotFoundException e)  { e.printStackTrace(); } 
		catch (IOException e)            { e.printStackTrace(); } 
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		
		return null;
	}

	public static void main(String[] args)
	{
		_01_Rectangle_Class_Implements_Serializable_Interface rect = 
				new _01_Rectangle_Class_Implements_Serializable_Interface(18, 78);
		
		_03_Serialize_An_Object_To_A_File.SerializeToFile(rect, "rectSerialized");

		_01_Rectangle_Class_Implements_Serializable_Interface deSerializedRect = 
				(_01_Rectangle_Class_Implements_Serializable_Interface) DeSerializeFromFileToObject("rectSerialized");
		
		// Just to verify that the original state of the Rectangle class is restored
		System.out.println("Rect area is " + deSerializedRect.Area());
	}
}
