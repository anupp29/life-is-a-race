#include <iostream>
using namespace std ;

int main() {
	
	cout << " Enter the Number : " ;
	int num,num2;
	cin >> num ;
	cout << endl ;
	
	cout << "	List of operations\n1. Sqaure\n2. Cube\n3. Square Root\n4. Factorial\n5. Sum\n6. Product\n0. Exit\n";
	
	while(1){
		cout << "\n-----------------------------------------\n";
		cout << " Enter Your Choice -->> ";
		int ch ;
		cin >> ch ;
		cout << endl;
		cout << " -->  " ;
		switch(ch){
			case 1:{
				cout << "Square : " << num*num ;
				break;
				}
			case 2:{
				cout << "Cube : " << num*num*num ;
				break;
				}
			case 3:{
				double error,sqrt1,sqrt2,temp ; 
				sqrt1 = num/2 ;
				temp = 1;
				error = 0.001;
				
				while(temp>error){
					sqrt2 = ((num/sqrt1) + sqrt1) / 2 ;
					temp = sqrt1 - sqrt2 ;
					sqrt1 = sqrt2 ;
				}
				cout << "Square Root : " << sqrt2 ;
				break;
				}
			case 4:{
				int fact = 1 ;
				for(int i=1 ; i <=num ; i++){
					fact=fact*i;
				}
				cout << "Factorial : " << fact ;
				break;
				}
			case 5:{
				cout << "Enter Second Number : ";
				cin >> num2 ;
				
				cout << "Sum : " << num+num2;
				break ;
				}
			case 6:{
				cout << "Enter Second Number : ";
				cin >> num2 ;
				
				cout << "Product : " << num*num2;
				break ;
				}
			case 0:{
				cout << "Thank You " ;
				cout << "\n-----------------------------------------\n";
				return 0;
				break;
				}
			default:{
				cout << "Invalid Choice";
				break;
				}
		}
	}	
	cout << "\n-----------------------------------------\n";	
	return 0; 
}



/*
zeo@ZeoLiTe:~/Desktop/practical$ g++ oop_1.cpp
zeo@ZeoLiTe:~/Desktop/practical$ ./a.out 
 Enter the Number : 6

	List of operations
1. Sqaure
2. Cube
3. Square Root
4. Factorial
5. Sum
6. Product
0. Exit

-----------------------------------------
 Enter Your Choice -->> 1

 -->  Square : 36
-----------------------------------------
 Enter Your Choice -->> 2

 -->  Cube : 216
-----------------------------------------
 Enter Your Choice -->> 3

 -->  Square Root : 2.44949
-----------------------------------------
 Enter Your Choice -->> 4

 -->  Factorial : 720
-----------------------------------------
 Enter Your Choice -->> 5

 -->  Enter Second Number : 5
Sum : 11
-----------------------------------------
 Enter Your Choice -->> 6

 -->  Enter Second Number : 3
Product : 18
-----------------------------------------
 Enter Your Choice -->> 0

 -->  Thank You 
-----------------------------------------
zeo@ZeoLiTe:~/Desktop/practical$ 
*/
