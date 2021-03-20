package com.strut;

import org.springframework.beans.factory.annotation.Autowired;

import com.hibernate.LoginEntity;
import com.opensymphony.xwork2.ActionSupport;
import com.spring.beans.ProfileBean;

public class MathAction  extends ActionSupport{
	public String num1;
 

	public void setNum1(String num1) {
		this.num1 = num1;
	}

	 

	public void setNum2(String num2) {
		this.num2 = num2;
	}

	public String num2;
	
	public String calculate() {
		int a=Integer.parseInt(num1);
		int b=Integer.parseInt(num2);
		sum=a+b;
		sub=a-b;
		mul=a*b;
		div=a/b;
		return "success";
	}
	
	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getSub() {
		return sub;
	}

	public void setSub(int sub) {
		this.sub = sub;
	}

	public int getMul() {
		return mul;
	}

	public void setMul(int mul) {
		this.mul = mul;
	}

	public int getDiv() {
		return div;
	}

	public void setDiv(int div) {
		this.div = div;
	}

	public int sum;
	public int sub;
	public int mul;
	public int div;
	
}
