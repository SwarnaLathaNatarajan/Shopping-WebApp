package Bean;

public class Account{
	String name,password,email,address;
	
	public void setDetails(String n,String e,String p,String a){
		name=n;
		password=p;
		email=e;
		address=a;
	}
	public void setNamePass(String n,String p){
		name=n;
		password=p;
	}
	public String getName(){
		return name;
	}
	public String getPass(){
		return password;
	}
	public String getEmail(){
		return email;
	}
	public String getAdd(){
		return address;
	}
}