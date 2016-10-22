/**
 * Created by dogan
 */
public class DeadCell implements Cell {

    public static final Cell INSTANCE;

    static {
        INSTANCE = new DeadCell();
    }

    @Override
    public Boolean isAlive() {
        return false;
    }

    @Override
    public Cell evolve(Integer neighbourCount) {
        switch (neighbourCount) {
            case 3:
                return AliveCell.INSTANCE;
            default:
                return INSTANCE;
        }
    }
}
