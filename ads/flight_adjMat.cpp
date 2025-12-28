#include<iostream>
#include<string>
using namespace std ;

class Graph {
    public :

    int cost[10][10];
    string city[10] ;
    int n ;
    
    Graph() {
        n=0;
        for(int i=0;i<10;i++) for(int j=0;j<10;j++) cost[i][j]=0;
    }
    
    void createCities() {
        cout << "Enter Number of Cities : ";
        cin >> n ;
        cout << "Enter CIty Names : \n" ;
        for(int i=0;i<n;i++) {
            cout << "City " << i << ": " ;
            cin >> city[i] ; 
        }
    }
    
    void createFlights() {
        int e; 
        cout << "Enter Number of Flights :" ;
        cin >> e ;
        
        cout << "\nEnter Flights in format : fromt to cost \n" ;
        
    
        for(int i=0;i<e;i++) {
            int v1, v2, c;
            cin >> v1 >> v2 >> c; 
            
            if(v1 < 0 || v1>=n || v2<0 || v2>=n) {
                cout << "Invalid City Index! Skipping..\n";
                continue ;
            }
            cost[v1][v2] = c ;
            cost[v2][v1] = c ;
        }
    }
    
    void displayMatrix() {
        cout << "\n===== Flight Cost ======\n" ;
        cout <<"\t";
        for(int i=0;i<n;i++) 
            cout << city[i] << "\t" ;
        cout << endl ;
        
        for(int i=0;i<n;i++) {
            cout << city[i] << '\t' ;
            for(int j=0;j<n;j++) 
                cout << cost[i][j] << "\t" ;
            cout << endl ;
        }
    }
    
    void checkFlight() {
        string src , dest ;
        cout << "\nENter Source City : " ;
        cin >> src ;
        cout << "Enter Destination City : " ;
        cin >> dest ;
        
        int s=-1 , d=-1 ;
        for(int i=0;i<n;i++) {
            if(city[i] == src) s=i ;
            if(city[i] == dest) d=i;
        }
        
        if(s==-1 || d==-1) {
            cout << "Invalid City names!\n" ; return ;
        }
        
        if(cost[s][d]!=0) 
            cout << "Flight From " << src << " to " << dest << " with cost : " << cost[s][d] << endl ;
        else 
            cout << "No Flight Available FLights \n" ;
    }
};

int main() {
    Graph g;
    g.createCities();
    g.createFlights();
    g.displayMatrix();
    g.checkFlight();
    return 0;
}