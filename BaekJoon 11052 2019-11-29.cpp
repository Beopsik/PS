#include<iostream>
#include<algorithm>
#include<cstring>
#include <stdlib.h>
using namespace std;

long long arr[10001];
long long dp[10001];
    
class makeOne{
    
    private:
        int n;
        int t=0;
        long double Max=0;
    public:
    void setNum()
    {
        cin>>n;
        for(int i=1; i<=n; i++)
        {
            cin>>arr[i];
            dp[i]=arr[i];
        }
    }
    void solution()
    {
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=i; j++)
            {
                dp[i]=max(dp[i],dp[j]+dp[i-j]);
            }
        }
        
    }
    void printMin()
    {
        cout<<dp[n]<<endl;
    }
};

int main(void)
{
    makeOne one;
    one.setNum();
    one.solution();
    one.printMin();
    
    return 0;
    
}















