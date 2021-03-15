#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;

long long arr[101];
long long dp[101];
int T[101];
    
class makeOne{
    
    private:
        int n;
        int Max=0;
    public:
    void setNum()
    {
        cin>>n;
    }
    void solution()
    {
        dp[1]=1;
        dp[2]=1;
        dp[3]=1;
        dp[4]=2;
        dp[5]=2;
        dp[6]=3;
        
        for(int i=0; i<n; i++)
        {
            cin>>T[i];
            Max=max(Max, T[i]);
        }
        
        for(int t=7; t<=Max; t++)
        {
            dp[t]=dp[t-1]+dp[t-5];
        }
        
    }
    void printMin()
    {
        for(int i=0; i<n; i++)
        {
            cout<<dp[T[i]]<<endl;;
        }
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









