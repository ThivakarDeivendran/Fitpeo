package testPackage;

public class TestFitpeo {

	
	public static void main(String[] args) {
			System.out.println("Testing");
			String s = "Object Oriented Programming Strcture";
			String[] st = s.split(" ");
			String n="";
			for(int i=0;i< st.length -1;i++) {
				char c = st[i].charAt(0); 
				n=n+c;
			}
			System.out.println("Coding completed   :  " + n);
	}
}
