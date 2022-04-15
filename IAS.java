class IAS
{
  String[] Memory;
  String MAR = "", MBR = "", IBR = "", IR = "", AC = "", MQ = "";
  int PC;
  
  IAS(String[] Memory, int PC){
    this.Memory = Memory;
    this.PC = PC;
  }
  
  void LOAD(int address){ //Load the contect of M(X) into the accumulator.
    AC = Memory[address];
  }
  
  void LOADabs(int address){
    AC = "0" + Memory[address].substring(1, Memory[address].length());
  }
  
  void LOADnegative(int address){
    if(Memory[address].charAt(0) == '1')
      AC = "0" + Memory[address].substring(1, Memory[address].length());
    else
      AC = "1" + Memory[address].substring(1, Memory[address].length());
  }
  
  void JUMPright(int address){
    PC = address;
  }
     
  void JUMPleft(int address){
    PC = address; 
  } 
  
  boolean JUMPcondRight(int address){
    if(AC.charAt(0) == '0'){
      PC = address;
      return true;
    }
    else
      return false;
  }
     
  boolean JUMPcondLeft(int address){
    if(AC.charAt(0) == '0'){
      PC = address;
      return true;
    }
    else 
      return false;
  } 
    
  void ADD(int address){
    int signAC = 1, signX = 1;
    if(AC.charAt(0) == '1')
      signAC = -1;
    if(Memory[address].charAt(0) == '1')
      signX = -1;
    int ac = Convert.BinaryToDecimal(AC.substring(1, AC.length()));
    int mx = Convert.BinaryToDecimal(Memory[address].substring(1, Memory[address].length()));
    ac = signAC * ac + signX * mx;
    if(ac < 0)
      AC = "1" + Convert.DecimalToBinary(Math.abs(ac));
    else
      AC = "0" + Convert.DecimalToBinary(ac); 
  }
  
  void ADDabs(int address){
    int signAC = 1;
    if(AC.charAt(0) == '1')
      signAC = -1;
    int ac = Convert.BinaryToDecimal(AC.substring(1, AC.length()));
    int mx = Convert.BinaryToDecimal(Memory[address].substring(1, Memory[address].length()));
    ac = signAC * ac + mx;
    if(ac < 0)
      AC = "1" + Convert.DecimalToBinary(Math.abs(ac));
    else
      AC = "0" + Convert.DecimalToBinary(ac); 
  }
  
  void SUB(int address){
    int signAC = 1, signX = 1;
    if(AC.charAt(0) == '1')
      signAC = -1;
    if(Memory[address].charAt(0) == '1')
      signX = -1;
    int ac = Convert.BinaryToDecimal(AC.substring(1, AC.length()));
    int mx = Convert.BinaryToDecimal(Memory[address].substring(1, Memory[address].length()));
    ac = signAC * ac - signX * mx;
    if(ac < 0)
      AC = "1" + Convert.DecimalToBinary(Math.abs(ac));
    else
      AC = "0" + Convert.DecimalToBinary(ac);
  }
  
  void SUBabs(int address){
    int signAC = 1;
    if(AC.charAt(0) == '1')
      signAC = -1;
    int ac = Convert.BinaryToDecimal(AC.substring(1, AC.length()));
    int mx = Convert.BinaryToDecimal(Memory[address].substring(1, Memory[address].length()));
    ac = signAC * ac - mx;
    if(ac < 0)
      AC = "1" + Convert.DecimalToBinary(Math.abs(ac));
    else
      AC = "0" + Convert.DecimalToBinary(ac);
  }
  
  void DIV(int address){
    int signAC = 1, signX = 1;
    if(AC.charAt(0) == '1')
      signAC = -1;
    if(Memory[address].charAt(0) == '1')
      signX = -1;
    int ac = Convert.BinaryToDecimal(AC.substring(1, AC.length()));
    int mx = Convert.BinaryToDecimal(Memory[address].substring(1, Memory[address].length()));
    ac = (signAC * ac) % (signX * mx);
    int mq = (signAC * ac) % (signX * mx);
    if(ac < 0)
      AC = "1" + Convert.DecimalToBinary(Math.abs(ac));
    else
      AC = "0" + Convert.DecimalToBinary(ac);
    if(mq < 0)
      MQ = "1" + Convert.DecimalToBinary(Math.abs(mq));
    else
      MQ = "0" + Convert.DecimalToBinary(mq);
  }
  
  void LSH(){
    int signAC = 1;
    if(AC.charAt(0) == '1')
      signAC = -1;
    int ac = Convert.BinaryToDecimal(AC.substring(1, AC.length()));
    ac = signAC * ac * 2;
    if(ac < 0)
      AC = "1" + Convert.DecimalToBinary(Math.abs(ac));
    else
      AC = "0" + Convert.DecimalToBinary(ac);
  }
  
  void RSH(){
    int signAC = 1;
    if(AC.charAt(0) == '1')
      signAC = -1;
    int ac = Convert.BinaryToDecimal(AC.substring(1, AC.length()));
    ac = signAC * (ac / 2);
    if(ac < 0)
      AC = "1" + Convert.DecimalToBinary(Math.abs(ac));
    else
      AC = "0" + Convert.DecimalToBinary(ac);
  }
  
  void STOR(int address){
    Memory[address] = AC;
    System.out.print(", Memory(" + address + ") = " + Memory[address]);
  }
}
