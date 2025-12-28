 #include <iostream>
using namespace std ;

int main() {
	
	cout << " Enter the Marks (out of 100) : " ;
	int grd;
	cin >> grd ;
	
	if (grd < 0 || grd > 100){
		cout << " -> Marks out of range" << endl ;
		return 0 ;
	}
	else {
		cout << "-----------------------------------------\n";
		if (grd > 90)
			cout << " -- Grade - O " << endl;
		else if (grd > 80)
			cout << " -- Grade - A " << endl ;
		else if (grd > 70)
			cout << " -- Grade - B " << endl ;
		else if (grd > 60)
			cout << " -- Grade - C " << endl ;
		else if (grd > 50)
			cout << " -- Grade - D " << endl ;
		else if (grd > 40)
			cout << " -- Grade - Pass " << endl ;
		else if (grd <= 40)
			cout << " -- Grade - Fail " << endl ;
		cout << "-----------------------------------------\n";
	}
	return 0;
}


/*
zeo@ZeoLiTe:~/Desktop/practical$ g++ oop_2.cpp
zeo@ZeoLiTe:~/Desktop/practical$ ./a.out 
 Enter the Marks (out of 100) : 92
-----------------------------------------
 -- Grade - O 
-----------------------------------------
zeo@ZeoLiTe:~/Desktop/practical$ ./a.out 
 Enter the Marks (out of 100) : 82
-----------------------------------------
 -- Grade - A 
-----------------------------------------
zeo@ZeoLiTe:~/Desktop/practical$ ./a.out 
 Enter the Marks (out of 100) : 72
-----------------------------------------
 -- Grade - B 
-----------------------------------------
zeo@ZeoLiTe:~/Desktop/practical$ ./a.out 
 Enter the Marks (out of 100) : 62
-----------------------------------------
 -- Grade - C 
-----------------------------------------
zeo@ZeoLiTe:~/Desktop/practical$ ./a.out 
 Enter the Marks (out of 100) : 52
-----------------------------------------
 -- Grade - D 
-----------------------------------------
zeo@ZeoLiTe:~/Desktop/practical$ ./a.out 
 Enter the Marks (out of 100) : 42
-----------------------------------------
 -- Grade - Pass 
-----------------------------------------
zeo@ZeoLiTe:~/Desktop/practical$ ./a.out 
 Enter the Marks (out of 100) : 32
-----------------------------------------
 -- Grade - Fail 
-----------------------------------------
zeo@ZeoLiTe:~/Desktop/practical$ ./a.out 
 Enter the Marks (out of 100) : 102
 -> Marks out of range
zeo@ZeoLiTe:~/Desktop/practical$ ./a.out 
 Enter the Marks (out of 100) : -50
 -> Marks out of range
zeo@ZeoLiTe:~/Desktop/practical$ 

*/
