// C++ program to count buildings that can 
// see sunlight. 
#include <iostream> 
using namespace std; 
typedef struct {
   double h,v;
} Point;
// Returns count buildings that can see sunlight 
int countBuildings(Point arr[], int n) 
{ 
	// Initialuze result (Note that first building 
	// always sees sunlight) 
	int count = 1; 

	// Start traversing element 
	Point curr_max = arr[0]; 
	for (int i=1; i<n; i++) 
	{ 
		// If curr_element is maximum, 
		// update maximum and increment count 
		if (arr[i] > curr_max) 
		{ 
			count++; 
			curr_max=arr[i]; 
		} 
	} 

	return count; 
} 

// Driver code 
int main() 
{ 
	Point arr[] = {{-3,2},{-2,0.8},{0,1.2},{2.2,0},{2,4.5}};
	int n = sizeof(arr) / sizeof(arr[0]); 
	cout << countBuildings(arr, n); 
	return 0; 
} 

