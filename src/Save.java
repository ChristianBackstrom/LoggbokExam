import java.util.Arrays;

public class Save {
    public Body[] save;

    public Save() {
        this.save = new Body[0];
    }

    public void saveBody(Body SaveText) {
        save = Arrays.copyOf(save,save.length + 1);
        save[save.length - 1] = SaveText;
    }

    public Body GetSave(int i) {
        return save[i];
    }
}

