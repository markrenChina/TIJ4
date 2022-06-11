package enumerated;

import java.util.EnumMap;

enum RoShamBo5 implements Competitor<RoShamBo5>{
    PAPER,SCISSORS,ROCK;
    static EnumMap<RoShamBo5,EnumMap<RoShamBo5,Outcome>> table
            = new EnumMap<>(RoShamBo5.class);
    static {
        for (RoShamBo5 it : RoShamBo5.values()){
            table.put(it,new EnumMap<>(RoShamBo5.class));
        }
        initRow(PAPER,Outcome.DRAW,Outcome.LOSE,Outcome.WIN);
        initRow(SCISSORS,Outcome.WIN,Outcome.DRAW,Outcome.LOSE);
        initRow(ROCK,Outcome.LOSE,Outcome.WIN,Outcome.DRAW);
    }

    static void initRow(RoShamBo5 it,Outcome vPAPER, Outcome vSCISSORS,Outcome vROCK){
        EnumMap<RoShamBo5,Outcome> row = RoShamBo5.table.get(it);
        row.put(RoShamBo5.PAPER,vPAPER);
        row.put(SCISSORS,vSCISSORS);
        row.put(ROCK,vROCK);
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo5.class,20);
    }

    @Override
    public Outcome compete(RoShamBo5 competitor) {
        return table.get(this).get(competitor);
    }
}
