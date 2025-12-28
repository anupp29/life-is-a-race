#include <iostream>
#include <cstring>
using namespace std ;

class Person {
	private : 
		char name[50];
		char address[100];
		char telPhone[15];
		char mobPhone[11];
		bool isHead ;
	public :
		Person(const char* n,const char* addr,const char* tel,const char* mob,bool head){
			strncpy(name,n,50);
			strncpy(address,addr,100);
			strncpy(telPhone,tel,15);
			strncpy(mobPhone,mob,11);
			isHead = head ;
		}
		
		void display() const{
			cout << name << "\t\t" << address << "\t\t" ;
			if (telPhone[0] != '\0'){
				cout << telPhone ;
			} else {
				cout << "Not Available" ;
			}
			cout << "\t\t";
			if (mobPhone[0] != '\0') {
				cout << mobPhone;
			} else {
				cout << "Not Available";
			}
			cout << "\t\t" << (isHead ? "Yes" : "No") << endl;
		}
};

class Directory {
	private :
		Person* persons[10];
		int personCount ;
	public : 
		Directory() {
			personCount=0;
		}
		
		void addPerson(Person* person){
			if (personCount < 10){
				persons[personCount++]=person;
			} else {
				cout << "Directory is Full" << endl ;
			}
		}
		
		void displayAll() const{
			cout << "Name\t\t\tAddress\t\t\tTelephone\t\tMobile\t\t\tHead of Family" << endl;
			cout << "----------------------------------------------------------------------------------------------------------------------------------------" << endl;
			for (int i=0;i<personCount;i++){
				persons[i]->display();
			}
		}	
};

int main(){
	Directory directory ;
	Person person1("John Doe","123 Elms","022-84959766","9122455668",true);
	Person person2("Alice Max","321 Chemms","022-8863966","5854888868",false);
	
	directory.addPerson(&person1);
	directory.addPerson(&person2);
	
	cout << "Directory Contents" << endl ;
	directory.displayAll();
	return 0 ;
}


/*
zeo@ZeoLiTe:~/Desktop/practical$ g++ oop_4.cpp
zeo@ZeoLiTe:~/Desktop/practical$ ./a.out 
Directory Contents
Name			Address			Telephone		Mobile			Head of Family
----------------------------------------------------------------------------------------------------------------------------------------
John Doe		123 Elms		022-84959766		9122455668		Yes
Alice Max		321 Chemms		022-8863966		5854888868		No
zeo@ZeoLiTe:~/Desktop/practical$ 



*/
