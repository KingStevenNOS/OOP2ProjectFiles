/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg1;

/**
 *
 * @author Eve~~
 */
public class YearRange {
    public class YearRange
    {
	int firstYear, secondYear, range;
	
	public YearRange(int a, int b){
		firstYear=a;
		secondYear=b;
	}
	
	public void yearRange(int rnge){
		range=rnge;
	}
	
	public int getFirstYear(){
		return firstYear;
	}
	
	public int getSecondYear(){
		return secondYear;
	}
	
	public int getFirstDivisor(){
		int firstdivisor=1;
		if ( range==1)
			firstdivisor=14;
		if ( range==2)
			firstdivisor=4;
		if ( range==3)
			firstdivisor=3;;
		
		return firstdivisor;
	}
	
	public int getSecondDivisor(){
		int seconddivisior=20;
		return seconddivisior;
	}
	
	public void printYears(){
		if( range==1)
			for(int i=firstYear;i<=secondYear;i++)
				if(i%getFirstDivisor()==0 && i%getSecondDivisor()==0)
					System.out.println(i);
		
		if( range==2){
			for(int i=firstYear;i<=secondYear;i++){
				if(i%getFirstDivisor()==0)
					System.out.print(i+", ");
				// The following makes the output neater
				if((i-firstYear+1)%40==0)
					System.out.println();
			}
			System.out.println();
		}
		if( range==3)
			for(int i=firstYear;i<=secondYear;i++)
				if((i+2)%4==0 && i%getFirstDivisor()==0)
					System.out.println(i);
        }
        
    }
}