/*
write a java program to initailzie and refer instancwe of a class having
 paramterize constructorr using this key word make use of static key word
*/

class Demo {
	static int len,bred ;
	
	Demo(int len , int bred) {
		this.len = len ;
		this.bred = bred ;
	}
	
	public static void calc(){
		System.out.println("Area : " + len*bred);
	}
}

class PracJava2 {
	public static void main(String[] args) {
		Demo d = new Demo(10,5);
		d.calc();
	}
}