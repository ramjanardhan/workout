/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author janardhan
 */
public class call {
    
    int data=50;  
  
 void change(int data){  
 data=data+100;//changes will be in the local variable only  
   System.out.println(data);  
 }  
     
 public static void main(String args[]){  
   call op=new call();  
  
   System.out.println("before change "+op.data);  
   op.change(500);  
   System.out.println("after change "+op.data);  
   
  
 }  
}  
    
