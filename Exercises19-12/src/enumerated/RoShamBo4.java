package enumerated;

public enum RoShamBo4 implements Competitor<RoShamBo4>{
    PAPER {
        @Override
        public Outcome compete(RoShamBo4 competitor) {
            return compete(SCISSORS, competitor);
        }
    },
    SCISSORS{
        @Override
        public Outcome compete(RoShamBo4 competitor) {
            return compete(PAPER, competitor);
        }
    },
    ROCK{
        @Override
        public Outcome compete(RoShamBo4 competitor) {
            return compete(ROCK, competitor);
        }
    };
    public static void main(String[] args) {
        RoShamBo.play(RoShamBo4.class, 20);
    }

    public Outcome compete(RoShamBo4 competitor,RoShamBo4 opponent) {
        return ((opponent == this) ? Outcome.DRAW:
                ((opponent == competitor) ? Outcome.WIN : Outcome.LOSE));
    }
}
