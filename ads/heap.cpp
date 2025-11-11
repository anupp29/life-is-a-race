#include <iostream>
using namespace std;

void heapify(int arr[], int n, int i, bool asc) {
    int ext = i;    // index of largest (asc) or smallest (!asc)
    int l = 2*i + 1, r = 2*i + 2;

    if (l < n) {
        if (asc) { if (arr[l] > arr[ext]) ext = l; }
        else     { if (arr[l] < arr[ext]) ext = l; }
    }
    if (r < n) {
        if (asc) { if (arr[r] > arr[ext]) ext = r; }
        else     { if (arr[r] < arr[ext]) ext = r; }
    }

    if (ext != i) {
        swap(arr[i], arr[ext]);
        heapify(arr, n, ext, asc);
    }
}

void heapSort(int arr[], int n, bool asc) {
    // Build heap: max-heap if asc==true, min-heap if asc==false
    for (int i = n/2 - 1; i >= 0; --i)
        heapify(arr, n, i, asc);

    // Extract one by one
    for (int i = n - 1; i > 0; --i) {
        swap(arr[0], arr[i]);          // move root to end
        heapify(arr, i, 0, asc);       // restore heap on reduced size
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
    heapSort(arr, n, asc);

    cout << "\nSorted Array: ";
    for (int i = 0; i < n; ++i) cout << arr[i] << ' ';
    cout << '\n';

    delete[] arr;
    return 0;
}
