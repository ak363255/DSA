package dsa.string;

public class RotateString {
    public boolean rotateString(String s, String goal) {
           if(s.length() != goal.length())return false;
            int rotatedBy = 0;
            boolean found = false;
            for(int i = 0;i<s.length();i++){
                found = true;
                for(int j = 0;j<s.length();j++){
                    if(s.charAt((j+i)%s.length()) != goal.charAt(j)){
                        found = false;
                        break;
                    }
                }
                if(found){
                    break;
                }
            }
            return found;
    }
}
