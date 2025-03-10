https://leetcode.com/problems/k-th-symbol-in-grammar/
//problem no : 779


//Correct but  TLE 
//Similar approach like count ans say
//We will recursively call previous state
//and replace "0" with "01" and "1" with "10"

class Solution {
    public int kthGrammar(int N, int K) {
        String ans=helper(N);
        return ans.charAt(K-1)-48;
    }
    
    String helper(int n)
    {
        if(n==1)
            return "0";
        String temp=helper(n-1);
        StringBuilder curr=new StringBuilder();
        for(int i=0;i<temp.length();i++)
        {
            if(temp.charAt(i)=='0')
                curr.append("01");
            else
                curr.append("10");
        }
        return curr.toString();
    }
}

/*

                       0
                0              1   
            0      1       1        0
         0   1    1   0   1  0     0  1           

Consider indexing 1
Now one think we observe that kth elemnt from row N
is coming from k/2th element of row N-1
Observation:
0 should replaced with "01" 
1 should replaced with "10"
first character is same (i.e character at odd is same)
second character is reverse( even character reverse)

so while calling k/2 we should call according to above condition
*/


class Solution {
    public int kthGrammar(int N, int K) {
        if(N==1)
            return 0;
        if(K%2==0)
            return (kthGrammar(N-1,K/2)==1)?0:1;
        return (kthGrammar(N-1,(K+1)/2));
    }
    
}


/*
the Kth value is generated by K / 2 in Row N - 1,
if K is even, Kth value equals K/2th value in Row N - 1,
otherwise Kth value equals reverse K/2th in Row N - 1,
*/


public int kthGrammar(int N, int K) {
        return kth(K - 1);
    }
    
    public int kth(int K){
        if(K == 0)      
		  return 0;        
        if(K % 2 == 0)  
		  return kth(K / 2);
        else            
		  return reverse(kth(K / 2));
    }
    
    private int reverse(int val){
        return val == 0 ? 1 : 0;
    }
