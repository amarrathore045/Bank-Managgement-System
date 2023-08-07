package bank.management.system.Handlers;

import java.util.regex.Pattern;


public class fieldRegexHandler<E> implements HandlerArray<E> {
    
    protected int index;
    protected HandlerArray nextHandler;
    protected String regex;
    protected Pattern pattern;
    
    
    public fieldRegexHandler(E[] request, String regex){
        this.regex = regex;
        this.pattern = Pattern.compile(regex);
    }
    
    @Override
    public void setNext(HandlerArray nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public boolean handle(E[] request) {
        return true;
    }
    
    @Override
    public void setIndex(int index){
        this.index = index;
    }
}