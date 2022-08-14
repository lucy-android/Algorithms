package priority.queue.code.haffman;

public class FrequencyCharacter {

    public final Character character;
    private int frequency;
    private StringBuilder haffmanCode = new StringBuilder("");

    public FrequencyCharacter(Character character) {
        this.frequency = 1;
        this.character = character;
    }

    public int getFrequency() {
        return frequency;
    }

    public void upGradeFrequency() {
        this.frequency++;
    }

    public StringBuilder getHaffmanCode() {
        return haffmanCode;
    }

    public void setHaffmanCode(StringBuilder haffmanCode) {
        this.haffmanCode = haffmanCode;
    }

    public void updateHaffmanCode(boolean isFirst) {
        if (haffmanCode.toString().toCharArray()[haffmanCode.toString().toCharArray().length - 1] == '0') {
            return;
        }
        if (isFirst) {
            haffmanCode.append('0');
        } else {
            haffmanCode.append('1');
        }
    }

    @Override
    public String toString() {
        return "FrequencyCharacter{" +
                "character=" + character +
                ", frequency=" + frequency +
                ", haffmanCode=" + haffmanCode;
    }
}
