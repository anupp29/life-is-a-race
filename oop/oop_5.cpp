#include <iostream>
#include <string>
using namespace std ;


int main(){
	cout << " -- Enter Name : " ;
	string full_name;
	getline(cin,full_name);
	
	int first = full_name.find(' ');
	int last = full_name.rfind(' ');
	
	if (first != string::npos && last != string::npos && first != last){
		char first_ch = full_name[0];
		char middle_ch = full_name[first+1];
		string last_name = full_name.substr(last+1);
		
		cout << " --> Fomatted : " << first_ch << "." << middle_ch << ". " << last_name << endl ;
	} else {
		cout << "Invlaid Input : " << endl;
	}
	return 0;
}
