import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class AddressBookReader 
{
	public static void main (String[] args) throws IOException 
	{
		int maleCount;
		ArrayList<AddressBook> addressBookList = new ArrayList<AddressBook>();
		
		addressBookList = readAddressBook();
		
		// get the male count
		maleCount = getMaleCount(addressBookList);
		System.out.println("Male count is " + Integer.toString(maleCount));

		// sort by date of birth and get the first element
		if (addressBookList.size() == 0)
		{
			System.out.print("No persons found! ");
		}
		else
		{
			Collections.sort(addressBookList);
			AddressBook oldestAddressBook = addressBookList.get(0);
			System.out.println("Oldest person is " + oldestAddressBook.getName());
		}
		
		// get the 2 persons and calculate age difference
		AddressBook addressBookObj1 = searchAddressBookByName(addressBookList, "Bill McKnight");
		AddressBook addressBookObj2 = searchAddressBookByName(addressBookList, "Paul Robinson");
		
		if ((addressBookObj1 != null) && (addressBookObj2 != null))
		{
			Date dateOfBirth1 = addressBookObj1.getDateOfBirth();
			Date dateOfBirth2 = addressBookObj2.getDateOfBirth();
			long days = daysBetween(dateOfBirth1, dateOfBirth2);
			System.out.println("Days between " + addressBookObj1.getName().toString() + " and " +
					addressBookObj2.getName().toString() + " is " + Long.toString(days));
		}
		else
		{
			System.out.println("Person/s not found!");
		}
	}
	
	public static ArrayList<AddressBook> readAddressBook() throws IOException
	{
		ArrayList<AddressBook> addressBookList;

		try
		{
			addressBookList =  new ArrayList <AddressBook>();
			
			BufferedReader buffReader = new BufferedReader(new FileReader("data/AddressBook"));
			{
			    String line = buffReader.readLine();
			
			    while (line != null) 
			    {
			    	// assume no commas used in address book
			    	String [] addressBookLine = line.split(",");
                    String personName = addressBookLine[0];
                    String personSex = addressBookLine[1];
                    String personDOB = addressBookLine[2];
                    
                    Date personDateOfBirth = null;
					try 
					{
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						personDateOfBirth = sdf.parse(personDOB);
					} 
					catch (ParseException e) 
					{
						System.out.println("Error while reading file.  Unable to read date of birth. " + e.getMessage().toString());
					}
                    
                    addressBookList.add(new AddressBook(personName, personSex, personDateOfBirth));
                    
			        line = buffReader.readLine();
			    }
			}
			buffReader.close();
			return addressBookList;
		}
		finally
		{
		}
	}
	
	public static int getMaleCount(ArrayList<AddressBook> addressBookList)
	{
		int returnResult;
		AddressBook thisAddressBook;
		
		returnResult = 0;
	    for(int i=0; i < addressBookList.size(); i++)
	    {
	    	thisAddressBook = addressBookList.get(i);
	    	if (thisAddressBook.getGender().equals(Gender.MALE))
	    	{
	    		returnResult++;
	    	}
	    }
	    return returnResult;
	}
	
	public static AddressBook searchAddressBookByName(ArrayList<AddressBook> addressBookList, String AddressBookName)
	{
		for(int i =0; i<addressBookList.size(); i++)
		{
            AddressBook thisAddressBook = addressBookList.get(i);
            if (thisAddressBook.getName().equals(AddressBookName.toString()))
            {
            	return thisAddressBook;
            }		
		}
		return null;
	}
	
    public static long daysBetween(Date d1, Date d2)
    {
    	long msDiff = d2.getTime() - d1.getTime();
    	long daysDiff = msDiff / (1000 * 60 * 60 * 24);
    	return daysDiff;
     }	
}
