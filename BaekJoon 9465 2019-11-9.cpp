#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;

int arr[2][100001];
int d[2][100001];

int main(void)
{
    int T;
    int n;

    cin>>T;

    long long sum[T]={0};
    
    for(int j=0; j<T; j++)
    {
        cin>>n;
        for(int i=0; i<2; i++)
        {
            for(int t=1; t<=n; t++)
            {
                cin>>arr[i][t];
            }
        }
        d[0][1]=arr[0][1];
        d[1][1]=arr[1][1];
        
        for(int i=2; i<=n; i++)
        {
            d[0][i]=max(d[1][i-2], d[1][i-1])+arr[0][i];
            d[1][i]=max(d[0][i-2], d[0][i-1])+arr[1][i];
        }
        
        sum[j]=max(d[0][n],d[1][n]);
    }
    
    for(int i=0; i<T; i++)
    {
        cout<<sum[i]<<endl;
    }
    
    return 0;
    
}
















