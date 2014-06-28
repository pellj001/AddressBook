import java.util.Date;

public class AddressBook implements Comparable<AddressBook> 
{ 
	private String name;
	private String sex;
	private Date dateOfBirth;

	public AddressBook(String name, String sex, Date dateOfBirth) 
	{
		setName(name);
		setSex(sex);
		setDateOfBirth(dateOfBirth);
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getSex() 
	{
		return sex;
	}
	
	public void setSex(String sex) 
	{
		this.sex = sex.trim().toUpperCase();
	}
	
	public Date getDateOfBirth() 
	{
		return dateOfBirth;
	}
	
	public void setDateOfBirth(Date dateOfBirth) 
	{
		this.dateOfBirth = dateOfBirth;
	}
	
	public boolean isMale()
	{
		if (this.sex.toString().equals("MALE"))			
		{
			return true;
		}	
		else
		{
			return false;
		}
	}
	
	 public int compareTo(AddressBook thisAddressBook)
	 {
		 if (this.dateOfBirth.after(thisAddressBook.dateOfBirth)) 
		 {  
	            return 1;
	     }
	     else 
	     if (this.dateOfBirth.equals(thisAddressBook.dateOfBirth))
	     {
	            return 0;
	     }
	     else 
	     {
	            return -1;
	     }
	 }
}

