#include <iostream>
#include <string>

using namespace std ;

class Fruit{
	public : 
		int totalFruits ;
		Fruit(){
			totalFruits=0;
		}
		void addFruits(int num){
			totalFruits+=num;
		}
};

class Apples : public Fruit {
	public :
		int numApples ;
		Apples(int num,Fruit& fruit){
			numApples = num ;
			fruit.addFruits(num);
		}
};

class Mangoes : public Fruit {
	public :
		int numMangoes ;
		Mangoes(int num,Fruit& fruit){
			numMangoes = num ;
			fruit.addFruits(num);
		}
};

		
int main () {
	int numApp,numMang;
	cout << " --> Apples  : " ;
	cin  >> numApp ;
	cout << " --> Mangoes : " ;
	cin >> numMang;
	
	Fruit fruitObj;
	Apples appObj(numApp,fruitObj);
	Mangoes mangObj(numMang,fruitObj);
	
	cout << endl;
	cout << " --->> Total Apples  : " << appObj.numApples << endl ;
	cout << " --->> Total Mangoes : " << mangObj.numMangoes << endl ;
	cout << " --->> Total Fruits  : " << fruitObj.totalFruits << endl ;
	
	return 0 ;
}


/*
zeo@ZeoLiTe:~/Desktop/practical$ g++ oop_6.cpp 
zeo@ZeoLiTe:~/Desktop/practical$ ./a.out 
 --> Apples  : 5
 --> Mangoes : 8

 --->> Total Apples  : 5
 --->> Total Mangoes : 8
 --->> Total Fruits  : 13
zeo@ZeoLiTe:~/Desktop/practical$ 
*/
