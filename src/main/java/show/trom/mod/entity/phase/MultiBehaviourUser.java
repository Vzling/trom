package show.trom.mod.entity.phase;

public interface MultiBehaviourUser {
    int getBehaviourState();

    void setBehaviourState(int state);

    int getBehaviourTicks();

    void setBehaviourTicks(int ticks);
}