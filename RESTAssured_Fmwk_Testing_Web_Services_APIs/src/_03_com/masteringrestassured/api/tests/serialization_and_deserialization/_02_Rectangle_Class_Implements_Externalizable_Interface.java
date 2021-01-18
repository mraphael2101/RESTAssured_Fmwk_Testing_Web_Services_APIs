package _03_com.masteringrestassured.api.tests.serialization_and_deserialization;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/* We should inherit from Externalizable interface only when we want to overtake 
   the Java’s default serialization mechanism. If you derive from the Externalizable 
   interface you must implement the below two methods:
    - readExternal(ObjectInput input)
    - writeExternal(ObjectOutput output)                                          */


public class _02_Rectangle_Class_Implements_Externalizable_Interface implements Externalizable
{
	public void readExternal(ObjectInput input)
	{
		
	}
	
	public void writeExternal(ObjectOutput output)
	{
		
	}
}
