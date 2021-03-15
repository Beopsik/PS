#include<iostream>
#include<algorithm>
#include<cstring>
#include <vector>
using namespace std;

long long arr[301];
long long dp[301];

class makeOne{
    
    private:
        int k;
        int n;
        long long sum;
        long long Max=0;
    
    public:
    makeOne()
        : sum(0)
    {
    }
    void setNum()
    {
        cin>>n;
    }
    void solution()
    {
        for(int i=1; i<=n; i++)
        {
            cin>>arr[i];
        }
        
        dp[1]=arr[1];
        if(n>1)
            dp[2]=arr[1]+arr[2];
        for(int i=3; i<=n; i++)
        {
            dp[i]=max(dp[i-2]+arr[i],dp[i]);
            dp[i]=max(dp[i-3]+arr[i-1]+arr[i],dp[i]);
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



















