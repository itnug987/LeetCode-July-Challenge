/**
	Problem: There are 8 prison cells in a row, and each cell is either occupied or vacant.

Each day, whether the cell is occupied or vacant changes according to the following rules:

If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
Otherwise, it becomes vacant.
(Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.)

We describe the current state of the prison in the following way: cells[i] == 1 if the i-th cell is occupied, else cells[i] == 0.

Given the initial state of the prison, return the state of the prison after N days (and N such changes described above.)
*/

class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
                
        int cycle =1;
        int first[] = new int[8];

        for(int i=1; i<7; i++)
        {
            first[i] = (cells[i-1] == cells[i+1] ? 1 :0);
        }
        N-=1;
        
        for(int i=0; i<8; i++)
        cells[i] = first[i];
        
    
        while(N-- >0)
        {
        
            int temp [] = new int [8];    
     
        for(int i=1; i<7; i++)
        {
            temp[i] = (cells[i-1] == cells[i+1] ? 1 :0);
        }
      
            if(Arrays.equals(temp, first)) N%=cycle;
     
               for(int i=0; i<8; i++)
               cells[i] = temp[i];   
       
            cycle++;
        }
        
        return cells;
        
        
    }
    
}
