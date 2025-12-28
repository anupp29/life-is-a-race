#include<iostream>
using namespace std ;

void heapifyMax( int arr[] , int n, int i ) { 
    int ext = i ;
    int l = 2*i + 1 ;
    int r = 2*i + 2 ; 
    
    if(l < n && arr[l] > arr[ext]) ext = l ;
    if(r < n && arr[r] > arr[ext]) ext = r ;

    if( ext != i ) {
        swap(arr[i],arr[ext]) ;
        heapifyMax(arr,n,ext) ;
    }
}

void heapifyMin( int arr[] , int n, int i ) { 
    int ext = i ;
    int l = 2*i + 1 ;
    int r = 2*i + 2 ;
    
    if(l < n && arr[l] < arr[ext]) ext = l ;
    if(r < n && arr[r] < arr[ext]) ext = r ;

    if( ext != i ) {
        swap(arr[i],arr[ext]) ;
        heapifyMin(arr,n,ext) ;
    }
}

void heapsort(int arr[],int n,bool asc) {
    if(asc)
    {
        for(int i=(n/2)-1;i>=0;i--)
        {
            heapifyMax(arr,n,i);
        }
        for(int i=n-1;i>0;i--)
        {
            swap(arr[0],arr[i]);
            heapifyMax(arr,i,0);
        }
    }
    else
    {
        for(int i=(n/2)-1;i>=0;i--)
        {
            heapifyMin(arr,n,i);
        }
        for(int i=n-1;i>0;i--)
        {
            swap(arr[0],arr[i]);
            heapifyMin(arr,i,0);
        }
    }
}

int main() {
    int n;
    cout << "Enter number of elements: ";
    cin >> n;
    if (n <= 0) { cout << "Invalid input!\n"; return 0; }

    int* arr = new int[n];
    cout << "Enter " << n << " elements:\n";
    for (int i = 0; i < n; ++i) cin >> arr[i];

    cout << "1. Ascending Order (Max Heap)\n2. Descending Order (Min Heap)\nEnter choice: ";
    int choice; cin >> choice;

    bool asc = (choice == 1);          // true => max-heap => ascending
    heapsort(arr, n, asc);

    cout << "\nSorted Array: ";
    for (int i = 0; i < n; ++i) cout << arr[i] << ' ';
    cout << '\n';

    delete[] arr;
    return 0;
}
