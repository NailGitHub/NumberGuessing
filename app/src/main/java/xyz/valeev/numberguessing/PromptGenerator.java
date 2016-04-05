package xyz.valeev.numberguessing;

/**
 * Created by HomeUser008 on 2016-03-31.
 */
public class PromptGenerator {
    int leftValue, rightValue, hiddenNumber;

    public PromptGenerator(){

    }

    public void setRandom (int hiddenNumber){
        this.hiddenNumber  = hiddenNumber;
    }

    public void setLeft (int leftValue){
        this.leftValue =leftValue;
    }

    public void setRight (int rightValue){
        this.rightValue =rightValue;
    }


    public String generatePrompt(int userNumber){

        if (userNumber == hiddenNumber) {
            String winMessage = "YOU WIN !!! "+ userNumber + " IS THE RIGHT CHOICE !!! ";
            return winMessage;
        }

        else if (userNumber <hiddenNumber) {
            setLeft( userNumber);
        }else {
            setRight (userNumber);
        }

        String promptMessage = " "+ leftValue + " < ? < " + rightValue + " ";

        return promptMessage;
    }
}
