package bank.management.system.Handlers;

import java.util.regex.Matcher;
import javax.swing.JOptionPane;

public class fieldEmailHandler<E> extends fieldRegexHandler<E> {
    
    public fieldEmailHandler(E[] request){
        super(request,  "^(.+)@(.+)$");
    }
    @Override
    public void setNext(HandlerArray nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public boolean handle(E[] request) {
        if (index >= request.length) {
            System.out.println("Formulario válido. Guardando los datos...");
            return true;
        }
        Matcher match = this.pattern.matcher(request[this.index].toString()); 
        
        if (!match.matches()) {
            JOptionPane.showMessageDialog(null, "Invalid Email");
            return false;
        }
        if(this.nextHandler != null){
            this.nextHandler.setIndex(++index);
            return nextHandler.handle(request);
        }
        return true; // Si se completo la verificacion.
    }
}