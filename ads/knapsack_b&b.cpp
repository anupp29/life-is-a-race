#include<iostream>
using namespace std ;

int bound(int i, int n, int cap, int wt[], int profit[], int cw, int cp) {
    int b = cp , tw = cw ; 
    
    while(i<n && tw+wt[i]<=cap) {
        tw += wt[i];
        b += profit[i];
        i++;
    }
    //add fractional 
    if(i<n && wt[i]>0)
        b += (profit[i] * (cap-tw))/wt[i] ; 
    return b ; //upper bound profit
}

void knapsack(int i, int n, int cap, int wt[], int profit[],int cw, int cp,int &maxProfit, int curr[], int best[] ) {
    //stop if wieght exceeds
    if (cw > cap) return ;
    
    // Print current state and bound
    int b = bound(i, n, cap, wt, profit, cw, cp);
    cout << "At item " << i << " -> "
         << "Current Profit: " << cp
         << ", Current Weight: " << cw
         << ", Bound: " << b << "\n";
         
    //base case 
    if (i==n) {
        //if best is best than best so far
        if(cp > maxProfit) {
            maxProfit = cp ; 
            for (int k=0;k<n;k++) best[k] = curr[k] ;
        }
        return ;
    }
    
    //include current item 
    curr[i] = 1;
    knapsack(i+1,n,cap,wt,profit,cw+wt[i],cp+profit[i],maxProfit,curr,best);
    //exclude curr only if branch looks promising 
    curr[i]=0;
    if(bound(i+1,n,cap,wt,profit,cw,cp)>maxProfit)
        knapsack(i+1,n,cap,wt,profit,cw,cp,maxProfit,curr,best);
}

int main() { 
    int n , cap ;
    cout << "Enter Number of items and knapsack capacity : " ;
    cin >> n >> cap ;
    
    //invalid 
    if(n<=0||cap<=0) {
        cout << "Invalid input! Items and capactiy must be positive\n";
        return 0 ;
    }
    
    int wt[n],profit[n];
    cout << "Enter weights and profits of each:\n";
    for(int i=0;i<n;i++) {
        cin >> wt[i] >> profit[i] ;
        if (wt[i] <= 0 || profit[i] < 0) {
            cout << "Invalid input! Weight must be > 0 and profit >= 0.\n";
            return 0;
        }
    }
    int maxProfit=0;
    int curr[n] = {0};
    int best[n] = {0} ;
    
    knapsack(0,n,cap,wt,profit,0,0,maxProfit,curr,best);
    
    int total = 0 ;
    for(int i=0;i<n;i++) {
        if(best[i]) {
            cout <<"Item"<<i+1<<" (wt="<<wt[i]<<" ,profit="<<profit[i]<<")\n";
            total+=wt[i];
        }
    }
    cout << "Total Weight Used = " << total << "\n";
    cout << "Maximum Profit = " << maxProfit << "\n";
    return 0;
}