import java.io.*;

class TestClass
{
  public static void main(String[] args)
  {
    /*Sign magnitude form has been used for the representation of numbers and differentiating between negative and positive numbers.
      => If the 1st bit is 0, then the number is positive
      => If the 1st bit is 1, then the number is negative. 
      The remaining bits of the number represent the magnitude. */
           
    //Test Program 1: Contains one jump statement and several other mathematical operations. 
    String[] Memory1 = new String[1000];
        
    Memory1[0] = "0100";     // 4
    Memory1[1] = "010010";   // 18
    Memory1[2] = "01010000"; // 80
    Memory1[3] = "01100100"; // 100
    Memory1[4] = "01111000"; // 120
    Memory1[5] = "111110";   // -30
    Memory1[6] = "1101";     // -5
    Memory1[7] = "1100001";  // -33
    Memory1[8] =  "0000000100000000000100000101000000000000"; // Load M(1), Add M(0)
    Memory1[9] =  "                    00100001000000010100"; // NULL, Stor M(20)
    Memory1[10] = "0000011000000000011100001011000000000011"; // Sub M(7), Div M(3)
    Memory1[11] = "                    00010100000000000000"; // NULL, Left Shift accumulator
    Memory1[12] = "0010000100000001010100001100000000000000"; // Store M(21), Div M(0)
    Memory1[13] = "0000011100000000011100001101000000010000"; // Add abs M(7), Jump left M(16)
    Memory1[14] = "                    00010101000000000000"; // NULL, Right Shift Accumulator. 
    Memory1[15] = "                    00010100000000000000"; // NULL, Left Shift accumulator               
    Memory1[16] = "0000100000000000011000100001000000000110"; // Sub Mod M(6), Stor M(24)
    Memory1[17] = "0001010100000000000000100001000000010110"; // Right Shift Accumulator, Stor M(22)
    Memory1[18] = "0000000000000000000000000000000000000000"; // Halt             
                    
    System.out.println("Test Program 1: \n");                             
    int pc1 = 8;
    IASWorking.IASfunction(Memory1, pc1);
    
    System.out.println("\n\n\nTest Program 2: \n");
    
    //Test Program 2: Contains 2 conditional jump statements and several other mathematical operations (the absolute and negative ones). 
    String[] Memory2 = new String[1000];
    
    Memory2[0] = "0101";     // 5   
    Memory2[1] = "010011";   // 19  
    Memory2[2] = "01010001"; // 81 
    Memory2[3] = "01100101"; // 101 
    Memory2[4] = "01111001"; // 121 
    Memory2[5] = "111111";   // -31
    Memory2[6] = "1110";     // -6
    Memory2[7] = "1100010";  // -34
    Memory2[8] =  "0000001000000000000100000111000000000000"; // Load Negative M(1), Add abs M(0)
    Memory2[9] =  "                    00100001000000011001"; // NULL, Stor M(25)
    Memory2[10] = "                    00010000000000001100"; // NULL, JUMP Conditional Right M(12)
    Memory2[11] = "                    00010100000000000000"; // NULL, Left Shift accumulator
    Memory2[12] = "0010000100000001010100001100000000000000"; // Store M(21), Div M(0)
    Memory2[13] = "0000011100000000011100001111000000001111"; // Add abs M(7), Jump Conditional left M(15)
    Memory2[14] = "                    00010101000000000000"; // NULL, Right Shift Accumulator
    Memory2[15] = "                    00010100000000000000"; // NULL, Left Shift accumulator               
    Memory2[16] = "0000100000000000011000100001000000011000"; // Sub abs M(6), Stor M(24)
    Memory2[17] = "0001010100000000000000100001000000010110"; // Right Shift Accumulator, Stor M(22)
    Memory2[18] = "                    00001000000000000111"; // NULL, Sub abs M(7)
    Memory2[19] = "                    00010101000000000000"; // NULL, Jump Conditional Right M(20)*/
    Memory2[20] = "0000000000000000000000000000000000000000"; // Halt
    Memory2[21] = "0001010100000000000000100001000000100000"; // Right Shift Accumulator, Stor M(32)
    
    int pc2 = 8;
    IASWorking.IASfunction(Memory2, pc2);
  }
}
