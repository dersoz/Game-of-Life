package dersoz.coderetreat.istanbul.gol.domain;

final class TestRepository {

    static final String cells3x3Str = "[D A D]\n[D D D]\n[A A A]";
    static final String cells3x3Gen1Str = "[D D D]\n[A D A]\n[D A D]";
    static final String cells3x3Gen2Str = "[D D D]\n[D A D]\n[D A D]";
    static final String cells3x3Gen3Str = "[D D D]\n[D D D]\n[D D D]";

    /**
     * Neighbours
     * 2 0 2 0
     * 3 4 5 3
     * 3 4 3 1
     * 3 4 5 3
     * 2 2 2 0
     */
    static final String cells5x4Str = "[D A D A]\n[D D D D]\n[A A A A]\n[A A D D]\n[D D D A]";
    /**
     * Next Gen
     * D D D D
     * A D D A
     * A D A D
     * A D D A
     * D D D D
     */
    static final String cells5x4Gen1Str = "[D D D D]\n[A D D A]\n[A D A D]\n[A D D A]\n[D D D D]";

    // Neighbour count
    static final Integer[][] cells3x3Neighbours = new Integer[][]{
            {1, 0, 1},
            {3, 4, 3},
            {1, 2, 1}
    };    // Neighbour count

    private TestRepository() {
    }

}
