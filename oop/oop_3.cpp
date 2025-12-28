#include <iostream>
using namespace std ;


class Employee{
	int salary ;
	int hours ;
	
	public :
	
	void getinfo(){
		cout << " --> Salary : " ;
		cin >> salary ;
		
		cout << " --> Hours : " ;
		cin >> hours;
	}
	
	void addSal() {
		if (salary<50000) salary+=10000 ;
	}
	
	void addWork(){
		if (hours>6) salary+=1000;
	}
	
	void display(){
		cout << " -----------------------------------\n";
		cout << " - Salary : " << salary ;
		cout << " - Hours  : " << hours ;
		cout << "\n----------------------------------\n";
	}
};
int main () {
	
	Employee e ;
	
	cout << "Enter Employees : " ;
	int n ;
	cin >> n ;
	
	for (int i=1;i<=n;i++){
		e.getinfo();
		e.addSal();
		e.addWork();
		e.display();
	}
	
	return 0 ;
}



/*
zeo@ZeoLiTe:~/Desktop/practical$ g++ oop_3.cpp
zeo@ZeoLiTe:~/Desktop/practical$ ./a.out 
Enter Employees : 2
 --> Salary : 40000
 --> Hours : 10
 -----------------------------------
 - Salary : 51000 - Hours  : 10
----------------------------------
 --> Salary : 64000
 --> Hours : 8
 -----------------------------------
 - Salary : 65000 - Hours  : 8
----------------------------------

*/
