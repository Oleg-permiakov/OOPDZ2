public interface QueueBehaviour {
    public void takeInQueue(Actor actor);
    public void takeOrders(); 
    public void givOrders(); 
    public void releaseFromQueue(); 

}