package userapp;

public class User {
	private int birthyear ;
	private int birthmonth;
	private int birthday;
	private String sex;

	public User(){
		this.birthyear = 0;
		this.birthmonth = 0;
		this.birthday = 0;
		this.sex = "";
	}

	public void setAge(String _age){
		this.birthyear = Integer.parseInt(_age.substring(0,4));
		this.birthmonth = Integer.parseInt(_age.substring(5,7));
		this.birthday = Integer.parseInt(_age.substring(8,10));
	}

	public void setSex(String _sex){
		int div = Integer.parseInt(_sex);
		if(div == 1){
			this.sex = "男";
		}else{
			this.sex = "女";
		}
	}

	public int getBirthyear(){
		return this.birthyear;
	}

	public int getBirthmonth(){
		return this.birthmonth;
	}

	public int getBirthday(){
		return this.birthday;
	}

	public String getSex(){
		return this.sex;
	}
}
