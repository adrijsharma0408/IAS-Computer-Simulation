class Convert
{
  static int BinaryToDecimal(String content) {
    int decimal = 0;
    for(int i = 0; i < content.length(); i++)
      decimal += (int)Math.pow(2, content.length() - 1 - i) * Integer.valueOf(Character.toString(content.charAt(i)));
    return decimal;
  }
  
  static String DecimalToBinary(int content) {
    StringBuilder binary = new StringBuilder(); 
    while(content != 0){
      binary.append(String.valueOf(content % 2));
      content /= 2;
    }
    return binary.reverse().toString();
  }
}
