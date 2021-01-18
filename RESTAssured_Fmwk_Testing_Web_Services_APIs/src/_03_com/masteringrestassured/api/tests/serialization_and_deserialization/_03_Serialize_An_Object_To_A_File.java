package _03_com.masteringrestassured.api.tests.serialization_and_deserialization;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/* The standard serialization process which Serialization converts a class instance 
into a byte stream which is then stored in a file on disk */

public class _03_Serialize_An_Object_To_A_File 
{
	public static void SerializeToFile(Object classObject, String fileName)
	{
		try 
		{
			/* Step 1: Open a file output stream to create a file object on disk. This 
			   file object will be used to write the serialized bytes of an object */
			FileOutputStream fileStream = new FileOutputStream(fileName);

			/* Step 2: Create a ObjectOutputStream, this class takes a files stream.
			   This class is responsible for converting the Object of any type into
			   a byte stream */
			ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);

			/* Step 3: ObjectOutputStream.writeObject method takes an Object and 
			   converts it into a ByteStream. Then it writes the Byte stream into
			   the file using the File stream that we created in step 1 */
			objectStream.writeObject(classObject);

			// Step 4: Gracefully close the streams
			objectStream.close();	fileStream.close();								} 
		
		catch (FileNotFoundException e) { e.printStackTrace(); } 
		catch (IOException e)           { e.printStackTrace(); }
	}

	public static void main(String[] args){
		_01_Rectangle_Class_Implements_Serializable_Interface rect = 
				new _01_Rectangle_Class_Implements_Serializable_Interface(18, 78);
		SerializeToFile(rect, "rectSerialized");
	}
}