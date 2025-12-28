#include <iostream> 
#include <string>
using namespace std ;

class AgeException {
	public :
		string message = "Error : Age must be between 18 to 55 " ;
};
class IncomeException {
	public : 
		string message = "Error : Income must be between 50k to 100k " ;
};
class CityException {
	public :
		string message = "Error : City must be : Pune/Mumbai/Bangalore,Chennai";
};
class VehicleException {
	public :
		string message = "Error : User Must own a 4-Wheeler";
};


void validateAge(int age){
	if (age < 18 || age > 55) throw AgeException();
}
void validateIncome(int income){
	if (income < 50000 || income > 100000) throw IncomeException();
}
void validateCity(const string& city){
	if(city!="Pune" && city!="Mumbai" && city!="Bangalore" && city!="Chennai") throw CityException();
}
void validateVehicle(const string& has4wheeler){
	if(has4wheeler!="y") throw VehicleException();
}

int main() {
	int age,income;
	string city,has4wheeler;
	
	cout << "--------------------------------" << endl ;
	cout << "      User Detial Validation    " << endl ;
	cout << "--------------------------------" << endl ;
	
	
	cout << " -- Age : " ;
	cin >> age ;
	try{
		validateAge(age);
	} catch (const AgeException& e){
		cout << "--------------------------------" << endl ;
		cout << e.message << endl;
		cout << "--------------------------------" << endl ; 
		return 1 ;
	}
	
	cout << " -- Income (in $) : " ;
	cin >> income ;
	try{
		validateIncome(income);
	} catch (const IncomeException& e){
		cout << "--------------------------------" << endl ;
		cout << e.message << endl;
		cout << "--------------------------------" << endl ; 
		return 1 ;
	}
	
	 
	cout << " -- City : " ;
	cin >> city ;
	try{
		validateCity(city);
	} catch (const CityException& e){
		cout << "--------------------------------" << endl ;
		cout << e.message << endl;
		cout << "--------------------------------" << endl ; 
		return 1 ;
	}
	
	
	cout << " -- 4 Wheeler (y/n) :" ;
	cin >> has4wheeler ;
	try{
		validateVehicle(has4wheeler);
	} catch (const VehicleException& e){
		cout << "--------------------------------" << endl ;
		cout << e.message << endl;
		cout << "--------------------------------" << endl ; 
		return 1 ;
	}

	cout << "--------------------------------" << endl ;
	cout << "       User Detials Valid!!     " << endl ;
	cout << "--------------------------------" << endl ;
	
	return 0;
}


/*
zeo@ZeoLiTe:~/Desktop/practical$ g++ oop_7.cpp 
zeo@ZeoLiTe:~/Desktop/practical$ ./a.out 
--------------------------------
      User Detial Validation    
--------------------------------
 -- Age : 10
--------------------------------
Error : Age must be between 18 to 55 
--------------------------------
zeo@ZeoLiTe:~/Desktop/practical$ ./a.out 
--------------------------------
      User Detial Validation    
--------------------------------
 -- Age : 25
 -- Income (in $) : 40000
--------------------------------
Error : Income must be between 50k to 100k 
--------------------------------
zeo@ZeoLiTe:~/Desktop/practical$ ./a.out 
--------------------------------
      User Detial Validation    
--------------------------------
 -- Age : 25
 -- Income (in $) : 52000
 -- City : nashik
--------------------------------
Error : City must be : Pune/Mumbai/Bangalore,Chennai
--------------------------------
zeo@ZeoLiTe:~/Desktop/practical$ ./a.out 
--------------------------------
      User Detial Validation    
--------------------------------
 -- Age : 25 
 -- Income (in $) : 52000 
 -- City : Pune
 -- 4 Wheeler (y/n) :n
--------------------------------
Error : User Must own a 4-Wheeler
--------------------------------
zeo@ZeoLiTe:~/Desktop/practical$ ./a.out 
--------------------------------
      User Detial Validation    
--------------------------------
 -- Age : 25
 -- Income (in $) : 52000
 -- City : Pune
 -- 4 Wheeler (y/n) :y
--------------------------------
       User Detials Valid!!     
--------------------------------
zeo@ZeoLiTe:~/Desktop/practical$ 


*/
