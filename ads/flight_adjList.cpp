#include<iostream>
#include<string>
using namespace std ;
class Node { 
    public : 
    int vertex ; 
    string city;
    int cost ;
    Node* next ; 
    
    Node(int v, string c, int co=0){
        vertex=v; city=c; cost=co; next=NULL;
    }
};

class Graph {
    private :
    Node* head[20] ;
    string cities[20] ;
    int n ;
    
    public :
    Graph() {
        n=0;
        for(int i=0;i<20;i++) {
            head[i]=NULL ;
        }
    }
    
    void createCities() {
        cout << "Enter Number of Cities : " ; 
        cin >> n ;
        for(int i=0;i<n;i++) { 
            cout << "Enter name of City " << i << ": " ;
            cin >> cities[i] ;
            head[i] = new Node(i,cities[i]);
        }
    }
    
    void createFlights() {
        int edges ;
        cout << "Enter Number of Flights : " ;
        cin >> edges ; 
        
        for(int i=0;i<edges;i++) { 
            int v1,v2,cost ;
            cout << "\nEnter Flight (from  , to , cost ) : " ;
            cin >> v1 >> v2 >> cost ;
            
            if(v1 < 0 || v1 >= n || v2 < 0 || v2>=n ) {
                cout << "Invalid City Index! Skipping ...\n " ;
                continue ;
            }
            
            //v1->v2
            Node* temp = head[v1] ;
            while(temp->next != NULL) {
                temp = temp->next ;
            } temp->next = new Node(v2,cities[v2],cost) ;
            
            //v2->v1 
            temp = head[v2] ; 
            while(temp->next != NULL) {
                temp = temp->next ;
            } temp->next = new Node(v1,cities[v1],cost) ;
        }
    }
    
    void displayFlights() {
        cout << "\n====== Flight Connections ======\n" ;
        for(int i=0;i<n;i++) {
            cout << cities[i] << "->" ;
            Node* temp = head[i]->next ;
            if(!temp) cout << "No Direct Flights" ;
            while(temp!=NULL) {
                cout << temp->city << "(" << temp->cost << ")" ;
                temp = temp->next ;
            } cout << endl ;
        }
        cout << "==================================\n" ;
    }
    
    void checkFlight() { 
        string src, dest ; 
        cout << "\nEnter Source City : " ;
        cin >> src ; 
        cout << "\nEnter Destination City : " ;
        cin >> dest ; 
        
        int s=-1 , d=-1 ;
        for(int i=0;i<n;i++) {
            if (cities[i] == src) s = i ;
            if (cities[i] ==dest) d = i ;
        }
        
        if(s==-1||d==-1) {cout << "Invalid Name\n";return;}
        
        Node* temp = head[s]->next ;
        while(temp != NULL) {
            if(temp->vertex == d) {
                cout << "Direct Found : " << src << "->" << dest << " | cost: " << temp->cost << endl ;
                return ;
            }
            temp = temp->next ;
        }
        cout << "No Direct" ;
    }
};

int main() { 
    Graph g ;
    g.createCities() ;
    g.createFlights() ;
    g.displayFlights() ;
    g.checkFlight();
    // int choice;
    // do {
    //     cout << "\n=========== MENU ===========";
    //     cout << "\n1. Display Flights";
    //     cout << "\n2. Check Flight Availability";
    //     cout << "\n3. Exit";
    //     cout << "\nEnter choice: ";
    //     cin >> choice;

    //     switch (choice) {
    //         case 1:
    //             g.displayFlights();
    //             break;
    //         case 2:
    //             g.checkFlight();
    //             break;
    //         case 3:
    //             cout << "Exiting...\n";
    //             break;
    //         default:
    //             cout << "Invalid choice!\n";
    //     }
    // } while (choice != 3);
    
    return 0 ; 
}
