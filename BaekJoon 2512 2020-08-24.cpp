#include <iostream>
#include <cstdio>
#include <algorithm>
#include <ctime>

using namespace std;
int area[10000];
int l;
int r;

int bianry(int left, int right, int n, int m)
{
	int mid;
	int answer=1;
	int result=0;
	
	srand((int)time(NULL));
	
	while (left <= right){
		int sum=0;
        mid=left+rand()%(right-left+1);
		for(int i=0; i<n; i++){
			if(area[i]<=mid)
				sum+=area[i];
			else
				sum+=mid;
		}
        if (sum<m){
			answer=mid;
            left=mid + 1;
		}
        else if(sum>m){
			right=mid - 1;
		}
        else{
            result=mid;
            break;
        }
    }
	
	if(left>right){
		result=answer;
	}
	else{
		result=mid;
	}
	return result;
}

int main(void){
 
	int n, m;
	int sum=0;
    int result=0;
	
	scanf("%d", &n);
	for(int i=0; i<n; i++)
	{
		scanf("%d", &area[i]);
		sum+=area[i];
	}
	sort(area, area+n);
	scanf("%d", &m);
	
	if(sum<=m)
		printf("%d\n", area[n-1]);
	else{
		result=bianry(0, area[n-1], n, m);
		printf("%d\n", result);
	}
	
    return 0;
}

