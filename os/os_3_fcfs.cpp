#include <iostream>
#include <string>
#include <algorithm>
using namespace std ;

struct pro {
	string pid ;
	int at ;
	int bt ;
	int ct ;
	int tat;
	int wt;
};

bool compareArrival(pro a , pro b ){
	return a.at < b.at ;
}


int main() {
	int n=0 ;
	cout << " --> Number of Processes : " ;
	cin >> n;
	
	pro* pros = new pro[n];
	
	for (int i=0;i<n;i++){
		pros[i].pid = "P" + to_string(i+1);
		
		cout << " - Arrival Time - " << pros[i].pid << " : " ;
		cin >> pros[i].at;
		
		cout << " - Burst Time - " << pros[i].pid << " : " ;
		cin >> pros[i].bt ;
	}
	
	sort(pros,pros+n,compareArrival);
	
	int tbt=pros[0].bt +pros[0].at;
	pros[0].ct=pros[0].bt + pros[0].at;
	
	for (int i=1;i<n;i++){
		if(pros[i].at<=tbt){
			tbt=tbt+pros[i].bt;
		} else {
			tbt=pros[i].at+pros[i].bt;
		}
		pros[i].ct=tbt;
	}
	int totTat=0, totWt=0 ;
	for (int i=0;i<n;i++){
		pros[i].tat = pros[i].ct - pros[i].at;
		pros[i].wt  = pros[i].tat - pros[i].bt ;
		
		totTat+= pros[i].tat;
		totWt += pros[i].wt;
	}
	
	cout << endl << "PID\tAT\tBT\tCT\tTAT\tWT" << endl;
	for (int i = 0; i < n; i++) {
		cout << pros[i].pid << '\t' << pros[i].at << '\t' << pros[i].bt << '\t' << pros[i].ct << '\t' << pros[i].tat << '\t' << pros[i].wt << endl;
    }

	cout << "\nAverage Turnaround Time: " << (float) totTat / n << endl;
	cout << "Average Waiting Time: " << (float) totWt / n << endl;

	delete[] pros;
	return 0;
}
