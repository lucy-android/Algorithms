package priority.queue.code.haffman;

public class FrequencyCharacter {

    public final Character character;
    private int frequency;

    public FrequencyCharacter(Character character) {
        this.character = character;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getFrequency() {
        return frequency;
    }
}
