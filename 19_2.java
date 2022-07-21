package test;

class Business implements Cloneable{
	private String company;
	private String work;
	public Business (String company,String work) {
		this.company = company;
		this.work = work;
	}
	public void changeBusiness(String company,String work) {
		this.company = company;
		this.work = work;
	}
	
	public void showBusinessInfo() {
		System.out.println(company);
		System.out.println(work);
	}
	
	@Override
	public Business clone() throws CloneNotSupportedException{
		return (Business)super.clone();
		
	}
}
class PersonalInfo implements Cloneable{
	private String name;
	private int age;
	private Business bz;
	public PersonalInfo (String name,int age, String company,String work) {
		this.name = name;
		this.age =age;
		bz = new Business(company,work);
	}
	public void showPersonalInfo() {
		System.out.println(name);
		System.out.println(age);
		bz.showBusinessInfo();
	}
	public void changePersonalInfo (String name,int age, String company,String work) {
		this.name = name;
		this.age =age;
		bz.changeBusiness(company,work);
	}
	@Override
	public PersonalInfo clone() throws CloneNotSupportedException{
		PersonalInfo copy = (PersonalInfo)super.clone();
		copy.bz = bz.clone(); // 깊은 복사 얕은복사
		
		return copy;
	}
	
}
public class Hello2 {	
	public static void main(String[] args){     
		PersonalInfo p1 = new PersonalInfo("HS",25,"A","d");
		PersonalInfo p2 ;
		try{
			p2 = p1.clone();
			p1.changePersonalInfo("SH", 52, "B", "c");
			p1.showPersonalInfo();
			System.out.println();
			p2.showPersonalInfo();
		}
		catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}	
	
}
