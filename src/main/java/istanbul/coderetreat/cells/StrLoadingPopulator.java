package istanbul.coderetreat.cells;

/**
 * Created by dogan
 */
public class StrLoadingPopulator implements Populator {

    private final String strRep;

    public StrLoadingPopulator(final String strRep) {
        this.strRep = strRep;
    }

    @Override
    public Cell[][] populate() {
        return CellFactory.cellsFromString(strRep);
    }

}
