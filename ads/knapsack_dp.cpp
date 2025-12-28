#include<iostream>
using namespace std ;

int main() {
    int n , cap ;
    cout << "Enter numbers of items and knapsacks capactiy : " ;
    cin >> n >> cap ;
    
    if(n<=0||cap<=0){
        cout << "Invalid Input! Both must be positive" ;
        return 0;
    }
    
    int wt[n+1], profit[n+1] ;
    wt[0] = profit[0] = 0 ; 
    
    cout << "Enter Weights of " << n << " items : \n " ;
    for(int i=1;i<=n;i++) cin >> wt[i] ;
    cout << "Enter profits of " << n << " items:\n";
    for (int i = 1; i <= n; i++) cin >> profit[i];
    
    int K[n + 1][cap + 1];
    
    for(int i=0;i<=n;i++) {
        for(int cw=0;cw<=cap;cw++) {
            if(i==0||cw==0) K[i][cw]=0;
            else if (wt[i] <= cw) 
                K[i][cw]=max(K[i-1][cw],K[i-1][cw-wt[i]]+profit[i]);
            else K[i][cw] = K[i-1][cw] ;
        }
    }
    
    
    int maxP = K[n][cap];
    cout << "\n Max Profit : " << maxP << endl ;
    int res = maxP ;
    int cw = cap ;
    int total = 0 ; 
    
    cout << "\nItems Included :\n" ;
    for(int i=n;i>0 && res>0;i--) {
        if(res == K[i-1][cw]) continue ;
        else  {
            cout << "Item" << i << "->Wt:" << wt[i] << ", pt->" << profit[i] << endl;
            total+=wt[i]; res-=profit[i] ;
            cw-=wt[i];
        }
    }
    cout << "Total weight : " << total << endl;
    cout << "Total Profit : " << maxP << endl ;
    return 0;
}