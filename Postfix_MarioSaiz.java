/*
    Mario Saiz
    Lab 7
    2/21/19
*/
package csc2403s19lab7;
import java.util.Stack;

public class Postfix {
    String expression;
    
    public Postfix(String x) { expression = x; }
    
    public String toString() { return expression; }
    
    public int solve() {
        Stack<Integer> my_stack = new Stack();
        
        for (int i = 0; i < expression.length(); i++)
        {
            char c = expression.charAt(i); // current character
         
            if(Character.isDigit(c))
                my_stack.push(c -'0');
            else {
                
                int a = my_stack.pop();
                int b = my_stack.pop();
                
                switch(c) {
                    
                    case '+':
                        my_stack.push(b+a);
                        break;
                    case '-':
                        my_stack.push(b-a);
                        break;
                    case '*':
                        my_stack.push(b*a);
                        break;
                    case '/':
                        my_stack.push(b/a);
                        break;
                    case '%':
                        my_stack.push(b%a);
                        break;
                    case '^':
                        my_stack.push((int)Math.pow(b,a));
                        break;
                }
            }
        
        }
        return my_stack.peek();  
    }
}

