package bank.management.system.Handlers;

import java.util.regex.Matcher;
import javax.swing.JOptionPane;

public class fieldTextHandler<E> extends fieldRegexHandler<E> {
    
    public fieldTextHandler(E[] request){
        super(request,  "^[\\p{L} .'-]+$");
    }
    @Override
    public void setNext(HandlerArray nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public boolean handle(E[] request) {

        Matcher match = this.pattern.matcher(request[this.index].toString()); 
        
        if (!match.matches()) {
            if(request[this.index].toString().equals("")){
                JOptionPane.showMessageDialog(null, "There are empty fields");
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Field "+request[this.index].toString());
            }
            return false;
        }
        if(this.nextHandler != null){
            this.nextHandler.setIndex(++index);
            return nextHandler.handle(request);
        }
        return true; // Si se completo la verificacion.
    }
}