package models;

public class RegistrationDTO
{
    private String FirstName;
    private String LastName;
    private String Username;
    private String Password;
    private String Email;

    public void setFirstName(String firstName)
    {
        this.FirstName = firstName;
    }

    public void setLastName(String lastName)
    {
        this.LastName = lastName;
    }

    public void setUserName(String userName)
    {
        this.Username = userName;
    }

    public void setPassword(String password)
    {
        this.Password = password;
    }

    public void setEmail(String email)
    {
        this.Email = email;
    }

    public RegistrationDTO newInstance()
    {
        setFirstName("Virender");
        setLastName("Singh");
        setUserName("63userf2d3d2011");
        setPassword("password1");
        setEmail("ed26dff39@gmail.com");
        return this;
    }
}
