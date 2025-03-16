import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentWithClock implements Learner{
    private Learner learner;

    public StudentWithClock(Learner learner) {
        this.learner = learner;
    }

    @Override
    public void learn() {
        learner.learn();
        String currentTime = getCurrentTime();
        System.out.println("Текущее время: " + currentTime);
    }

    private String getCurrentTime() {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        return format.format(date);
    }
}
