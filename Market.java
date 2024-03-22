import java.util.ArrayList;
import java.util.List;

public class Market implements MarketBehaviour, QueueBehaviour {

    private List<Actor> queue = new ArrayList<>();
    
    @Override
    public void acceptToMarket(Actor actor) {
        System.out.println(actor.getName() + " пришёл в магазин");
        takeInQueue(actor);
        
    }

    @Override
    public void releaseFromMarket(List<Actor> actors) {
        for (Actor actor : actors) {
            System.out.println(actor.getName() + " вышел из магазина");
            queue.remove(actor);
        }
        
    }

    @Override
    public void update() {
        takeOrders();
        givOrders();
        releaseFromQueue();
        
    }

    @Override
    public void givOrders() {
        for (Actor actor : queue) {
            if (actor.isMakeOrder) {
                actor.setTakeOrder(true);
                System.out.println(actor.getName() + " получил заказ");
            }
        }
        
    }

    @Override
    public void releaseFromQueue() {
        List<Actor> releasedActor = new ArrayList<>();
        for (Actor actor : queue) {
            if (actor.isTakeOrder()) {
                releasedActor.add(actor);
                System.out.println(actor.getName() + " вышел из очереди");
            }
        }
        releaseFromMarket(releasedActor);
    }

    @Override
    public void takeInQueue(Actor actor) {
        System.out.println(actor.getName() + " встал в очередь");
        queue.add(actor);
        
    }

    @Override
    public void takeOrders() {
        for (Actor actor : queue) {
            if (!actor.isMakeOrder) {
                actor.setMakeOrder(true);
            }
            System.out.println(actor.getName() + " сделал заказ");
        }
        
    }
}
