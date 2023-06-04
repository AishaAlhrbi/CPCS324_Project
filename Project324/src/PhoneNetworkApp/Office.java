/*
 *  @authors Reem, Aisha, Sara, Hanady
 * CPCS-324
 * Project Code
 * 4 June. 2023
 */
package PhoneNetworkApp;

import GraphFramework.Vertex;
 
public class Office extends Vertex{
     
	private final String officeNo;

	public Office (int label) {
		super(label);
		this.officeNo = String.valueOf((char)(label+65));
	}
 
	
	@Override
    public void displayInfo() { 
		System.out.print("Office No. " + officeNo);
    }  

}  
  
    
    
    
    
    
