/**
 * Created by dogan
 */
public class AliveCell implements Cell {

    public static final Cell INSTANCE;

    static {
        INSTANCE = new AliveCell();
    }

    @Override
    public Boolean isAlive() {
        return true;
    }

    @Override
    public Cell evolve(Integer neighbourCount) {
        switch (neighbourCount) {
            case 2:
            case 3:
                return INSTANCE;
            default:
                return DeadCell.INSTANCE;
        }
    }
}
