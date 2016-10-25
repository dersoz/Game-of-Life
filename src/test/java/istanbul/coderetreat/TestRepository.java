package istanbul.coderetreat;

/**
 * Created by dogan
 */
public class TestRepository {

    public static final String cells3x3Str = "[D A D]\n[D D D]\n[A A A]";

    public static final String cells3x3Gen1Str = "[D D D]\n[A D A]\n[D A D]";

    public static final String cells3x3Gen2Str = "[D D D]\n[D A D]\n[D A D]";

    public static final String cells3x3Gen3Str = "[D D D]\n[D D D]\n[D D D]";

    // Neighbour count
    public static final Integer[][] cells3x3Neighbours = new Integer[][]{
            {1, 0, 1},
            {3, 4, 3},
            {1, 2, 1}
    };

    private TestRepository() {
    }

}
