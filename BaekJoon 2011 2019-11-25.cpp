#include<iostream>
#include<algorithm>
#include<cstring>
#include <stdlib.h>
using namespace std;

char arr[5001];
long long dp[5001];
    
class makeOne{
    
    private:
        int n;
        int Max=0;
    public:
    void setNum()
    {
        cin>>arr;
        n=strlen(arr);
    }
    void solution()
    {
        if(arr[0]-'0'>0)
            dp[1]=1;
        
        if(arr[1]-'0'>0&&arr[1]-'0'<=6)
        {
            if(arr[0]-'0'>2)
                dp[2]=1;
            else if(arr[0]-'0'<=2&&arr[0]-'0'>0)
                dp[2]=2;
        }
        else if(arr[1]-'0'==0){
            if(arr[0]-'0'>2)
                dp[n]=0;
            else if(arr[0]-'0'<=2&&arr[0]-'0'>0)
                dp[2]=1;
            
        }
        else{
            if(arr[0]-'0'>=2)
                dp[2]=1;
            else if(arr[0]-'0'<2&&arr[0]-'0'>0)
                dp[2]=2;
        }
        
        for(int i=3; i<=n; i++)
        {
            if(arr[i-1]-'0'>0&&arr[i-1]-'0'<=6)
            {
                if(arr[i-2]-'0'>2)
                    dp[i]=dp[i-1]%1000000;
                else if(arr[i-2]-'0'<=2&&arr[i-2]-'0'>0)
                    dp[i]=(dp[i-1]+dp[i-2])%1000000;
                else{
                    if(dp[i-1]!=0)
                        dp[i]=dp[i-1]%1000000;
                }
            }
            else if(arr[i-1]-'0'==0){
                if(arr[i-2]-'0'<=2&&arr[i-2]-'0'>0)
                    dp[i]=dp[i-2]%1000000; 
                else{    
                    dp[n]=0;
                    break;
                }
            }
            else{
                if(arr[i-2]-'0'>=2)
                    dp[i]=dp[i-1]%1000000;
                else if(arr[i-2]-'0'<2&&arr[i-2]-'0'>0)
                    dp[i]=(dp[i-1]+dp[i-2])%1000000;
                else
                    dp[i]=dp[i-1]%1000000;
                    
            }
        }
        
    }
    void printMin()
    {
        cout<<dp[n]%1000000<<endl;
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













