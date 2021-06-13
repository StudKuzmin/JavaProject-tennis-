

class ColorBall implements IColorBall_BLUE, IColorBall_RED {
 
 public String setRED() {
   System.out.println("RED BALL");	 
   return "RED";
 }

 public String setBLUE() {
   System.out.println("BLUE BALL");	
   return "BLUE";
 } 

 
}