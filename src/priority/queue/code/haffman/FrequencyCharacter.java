package priority.queue.code.haffman;

public class FrequencyCharacter {

    public final Character character;
    private int frequency;

    public FrequencyCharacter(Character character) {
        this.frequency = 1;
        this.character = character;
    }

    public int getFrequency() {
        return frequency;
    }

    public void upGradeFrequency(){
        this.frequency++;
    }

    @Override
    public String toString() {
        return "FrequencyCharacter{" +
                "character=" + character +
                ", frequency=" + frequency +
                '}';
    }
}
