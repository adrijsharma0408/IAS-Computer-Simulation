class IASWorking
{
  static void IASfunction(String[] Memory, int PC)
  {
    IAS ias = new IAS(Memory, PC);
   
    boolean flag = false;
    while(true)
    {
      ias.MAR = String.valueOf(ias.PC);
      ias.MBR = ias.Memory[Integer.valueOf(ias.MAR)];
      System.out.println("PC = " + ias.PC);
      String left = ias.MBR.substring(0, 20), right = ias.MBR.substring(20, 40);
      
      if(flag == true || left.equals("                    "))
      {
        ias.IR = right.substring(0, 8);
        ias.MAR = right.substring(8, 20);
        System.out.print("IR = " + ias.IR + ", MAR = " + ias.MAR);
        if(ias.IR.equals("00000001"))
          ias.LOAD(Convert.BinaryToDecimal(ias.MAR));
        else if(ias.IR.equals("00000010"))
          ias.LOADnegative(Convert.BinaryToDecimal(ias.MAR));
        else if(ias.IR.equals("00000011"))
          ias.LOADabs(Convert.BinaryToDecimal(ias.MAR));
        else if(ias.IR.equals("00000101"))
          ias.ADD(Convert.BinaryToDecimal(ias.MAR));
        else if(ias.IR.equals("00000111"))
          ias.ADDabs(Convert.BinaryToDecimal(ias.MAR));
        else if(ias.IR.equals("00000110"))
          ias.SUB(Convert.BinaryToDecimal(ias.MAR));
        else if(ias.IR.equals("00001000"))
          ias.SUBabs(Convert.BinaryToDecimal(ias.MAR));
        else if(ias.IR.equals("00001100"))
          ias.DIV(Convert.BinaryToDecimal(ias.MAR));
        else if(ias.IR.equals("00001101")){
          ias.JUMPleft(Convert.BinaryToDecimal(ias.MAR));
          System.out.print(", AC = " + ias.AC);
          System.out.println("\n\nJUMP Encountered, New PC = " + ias.PC);
          continue;
        }
        else if(ias.IR.equals("00001110")){
          flag = true;
          ias.JUMPright(Convert.BinaryToDecimal(ias.MAR));
          System.out.print(", AC = " + ias.AC);
          System.out.println("\n\nJUMP Encountered, New PC = " + ias.PC);
          continue;
        }
        else if(ias.IR.equals("00001111")){
          boolean isJump = ias.JUMPcondLeft(Convert.BinaryToDecimal(ias.MAR));
          if(isJump){
            System.out.print(", AC = " + ias.AC);
            System.out.println("\n\nJUMP Encountered, New PC = " + ias.PC);
            continue;
          }
        }
        else if(ias.IR.equals("00010000")){
          boolean isJump = ias.JUMPcondRight(Convert.BinaryToDecimal(ias.MAR));
          flag = isJump;
          if(isJump){
            System.out.print(", AC = " + ias.AC);
            System.out.println("\n\nJUMP Encountered, New PC = " + ias.PC);
            continue;
          }
        }
        else if(ias.IR.equals("00010100"))
          ias.LSH();
        else if(ias.IR.equals("00010101"))
          ias.RSH();
        else if(ias.IR.equals("00100001"))
          ias.STOR(Convert.BinaryToDecimal(ias.MAR));
        else if(ias.IR.equals("00000000")){ 
          System.out.println(", Program Terminated");
          break;
        }
        System.out.print(", AC = " + ias.AC);
      }
      
      else
      {
        ias.IR = left.substring(0, 8);
        ias.MAR = left.substring(8, 20);
        System.out.print("IR = " + ias.IR + ", MAR = " + ias.MAR);
        if(ias.IR.equals("00000001"))
          ias.LOAD(Convert.BinaryToDecimal(ias.MAR));
        else if(ias.IR.equals("00000010"))
          ias.LOADnegative(Convert.BinaryToDecimal(ias.MAR));
        else if(ias.IR.equals("00000011"))
          ias.LOADabs(Convert.BinaryToDecimal(ias.MAR));
        else if(ias.IR.equals("00000101"))
          ias.ADD(Convert.BinaryToDecimal(ias.MAR));
        else if(ias.IR.equals("00000111"))
          ias.ADDabs(Convert.BinaryToDecimal(ias.MAR));
        else if(ias.IR.equals("00000110"))
          ias.SUB(Convert.BinaryToDecimal(ias.MAR));
        else if(ias.IR.equals("00001000"))
          ias.SUBabs(Convert.BinaryToDecimal(ias.MAR));
        else if(ias.IR.equals("00001100"))
          ias.DIV(Convert.BinaryToDecimal(ias.MAR));
        else if(ias.IR.equals("00001101")){
          ias.JUMPleft(Convert.BinaryToDecimal(ias.MAR));
          System.out.print(", AC = " + ias.AC);
          System.out.println("\n\nJUMP Encountered, New PC = " + ias.PC);
          continue;
        }
        else if(ias.IR.equals("00001110")){
          flag = true;
          ias.JUMPright(Convert.BinaryToDecimal(ias.MAR));
          System.out.print(", AC = " + ias.AC);
          System.out.println("\n\nJUMP Encountered, New PC = " + ias.PC);
          continue;
        }
        else if(ias.IR.equals("00001111")){
          boolean isJump = ias.JUMPcondLeft(Convert.BinaryToDecimal(ias.MAR));
          if(isJump){
            System.out.print(", AC = " + ias.AC);
            System.out.println("\n\nJUMP Encountered, New PC = " + ias.PC);
            continue;
          }
        }
        else if(ias.IR.equals("00010000")){
          boolean isJump = ias.JUMPcondRight(Convert.BinaryToDecimal(ias.MAR));
          flag = isJump;
          if(isJump){
            System.out.print(", AC = " + ias.AC);
            System.out.println("\n\nJUMP Encountered, New PC = " + ias.PC);
            continue;
          }
        }
        else if(ias.IR.equals("00010100"))
          ias.LSH();
        else if(ias.IR.equals("00010101"))
          ias.RSH();
        else if(ias.IR.equals("00100001"))
          ias.STOR(Convert.BinaryToDecimal(ias.MAR));
        else if(ias.IR.equals("00000000")){ 
          System.out.println(", Program Terminated");
          break;
        }
        System.out.print(", AC = " + ias.AC);
        
        ias.IR = right.substring(0, 8);
        ias.MAR = right.substring(8, 20);
        System.out.print(" | IR = " + ias.IR + ", MAR = " + ias.MAR);
        if(ias.IR.equals("00000001"))
          ias.LOAD(Convert.BinaryToDecimal(ias.MAR));
        else if(ias.IR.equals("00000010"))
          ias.LOADnegative(Convert.BinaryToDecimal(ias.MAR));
        else if(ias.IR.equals("00000011"))
          ias.LOADabs(Convert.BinaryToDecimal(ias.MAR));
        else if(ias.IR.equals("00000101"))
          ias.ADD(Convert.BinaryToDecimal(ias.MAR));
        else if(ias.IR.equals("00000111"))
          ias.ADDabs(Convert.BinaryToDecimal(ias.MAR));
        else if(ias.IR.equals("00000110"))
          ias.SUB(Convert.BinaryToDecimal(ias.MAR));
        else if(ias.IR.equals("00001000"))
          ias.SUBabs(Convert.BinaryToDecimal(ias.MAR));
        else if(ias.IR.equals("00001100"))
          ias.DIV(Convert.BinaryToDecimal(ias.MAR));
        else if(ias.IR.equals("00001101")){
          ias.JUMPleft(Convert.BinaryToDecimal(ias.MAR));
          System.out.print(", AC = " + ias.AC);
          System.out.println("\n\nJUMP Encountered, New PC = " + ias.PC);
          continue;
        }
        else if(ias.IR.equals("00001110")){
          flag = true;
          ias.JUMPright(Convert.BinaryToDecimal(ias.MAR));
          System.out.print(", AC = " + ias.AC);
          System.out.println("\n\nJUMP Encountered, New PC = " + ias.PC);
          continue;
        }
        else if(ias.IR.equals("00001111")){
          boolean isJump = ias.JUMPcondLeft(Convert.BinaryToDecimal(ias.MAR));
          if(isJump){
            System.out.print(", AC = " + ias.AC);
            System.out.println("\n\nJUMP Encountered, New PC = " + ias.PC);
            continue;
          }
        }
        else if(ias.IR.equals("00010000")){
          boolean isJump = ias.JUMPcondRight(Convert.BinaryToDecimal(ias.MAR));
          flag = isJump;
          if(isJump){
            System.out.print(", AC = " + ias.AC);
            System.out.println("\n\nJUMP Encountered, New PC = " + ias.PC);
            continue;
          }
        }
        else if(ias.IR.equals("00010100"))
          ias.LSH();
        else if(ias.IR.equals("00010101"))
          ias.RSH();
        else if(ias.IR.equals("00100001"))
          ias.STOR(Convert.BinaryToDecimal(ias.MAR));
        else if(ias.IR.equals("00000000")){ 
          System.out.println(", Program Terminated");
          break;
        }
        System.out.print(", AC = " + ias.AC);
      }
      System.out.println("\n");
      ias.PC++;
    }
  }
}
