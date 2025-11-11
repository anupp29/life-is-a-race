#include<iostream>
using namespace std ;

int main() {
    int n , cap ; 
    cout << "Enter Number of Items and Capacity : " ;
    cin >> n >> cap ;
    
    if(n<=0 || cap<=0) {cout << "invalid Input\n"; return 0;}
    
    int wt[n],val[n],id[n];
    double ratio[n];
    
    cout << "Enter weight and value for each item:\n";
    for(int i=0;i<n;i++) {
        cin >> wt[i] >> val[i];
        id[i]=i+1;
        ratio[i] = (double)val[i]/wt[i] ;
    }
    for(int i=0;i<n-1;i++) { 
        for(int j=0;j<n-i-1;j++) {
            if(ratio[j] < ratio[j+1]) {
                swap(ratio[j],ratio[j+1]);
                swap(wt[j],wt[j+1]);
                swap(val[j],val[j+1]);
                swap(id[j],id[j+1]);
            }
        }    
    }
    double maxP = 0.0 ;
    int cwt = 0 ;
    
    cout << "Items Taken:\n";
    for(int i=0;i<n;i++) { 
        if(cwt+wt[i] <= cap) {
            cwt += wt[i] ;
            maxP += val[i];
            cout << "item "<<id[i]<<" fully (Wt=:"<<wt[i]<<",val="<<val[i]<<")\n";
        } else {
            int remain = cap - cwt ;
            maxP += ratio[i] * remain;
            cout << "Item "<<id[i]<<" paritial("<<remain<<"/"<<wt[i] << ")\n" ;
            cwt += remain;
            break;
        }
    }
     cout << "\nTotal Profit = " << maxP << "\nTotal Weight Used = " << cwt << endl;
    return 0;
}