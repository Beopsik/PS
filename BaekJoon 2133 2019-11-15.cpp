#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;

long long arr[31];
long long dp[31];
    
class makeOne{
    
    private:
        int n;
        
    public:
    void setNum()
    {
        cin>>n;
    }
    void solution()
    {
        if(n%2==0)
        {
            dp[0]=1;
            dp[2]=3;
            
            for(int i=4; i<=n; i+=2)
            {
                dp[i]=dp[i-2]*3;
                for(int j=4; i-j>=0; j+=2)
                {
                    dp[i]+=dp[i-j]*2;
                }
            }
        }
    }
    void printMin()
    {
        cout<<dp[n];
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








