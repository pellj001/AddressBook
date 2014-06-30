import java.util.Date;

public class AddressBook implements Comparable<AddressBook> 
{ 	

	private String name;
	private String sex;
	private Date dateOfBirth;
    private Gender gender;
	
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
		if (this.sex.toString().equals("MALE"))
		{
			this.gender = Gender.MALE;
		}
		else 
		{
			this.gender = Gender.FEMALE;
		}
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
	
	public Gender getGender()
	{
		return this.gender;
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
	 
	 @Override
	 public String toString()
	 {
		 return this.name.toString();
	 }
}

