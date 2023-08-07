package bank.management.system.Handlers;

import java.util.regex.Matcher;
import javax.swing.JOptionPane;

public class fieldPINHandler<E> extends fieldRegexHandler<E> {
    
    public fieldPINHandler(E[] request){
        super(request,  "[0-9]{6}");
    }
    @Override
    public void setNext(HandlerArray nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public boolean handle(E[] request) {
        Matcher match = this.pattern.matcher(request[this.index].toString()); 
        
        if (!match.matches()) {
            JOptionPane.showMessageDialog(null, "Invalid PIN - Must be 6 Numerical Digits");
            return false;
        }
        if(this.nextHandler != null){
            this.nextHandler.setIndex(++index);
            return nextHandler.handle(request);
        }
        return true; // Si se completo la verificacion.
    }
}