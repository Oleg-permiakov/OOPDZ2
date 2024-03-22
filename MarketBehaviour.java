import java.util.List;

public interface MarketBehaviour {
    public void acceptToMarket(Actor actor);
    public void releaseFromMarket(List<Actor> actor);
    public void update();
}
