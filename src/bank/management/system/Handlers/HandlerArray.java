package bank.management.system.Handlers;

public interface HandlerArray<E> {
    public void setNext(HandlerArray nextHandler);
    public boolean handle(E[] request);
    public void setIndex(int index);
}
