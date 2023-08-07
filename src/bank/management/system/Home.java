
package bank.management.system;



public class Home {
    
    String pinNumber;
    
    Home(String pinNumber){
         BankButtonsFacade bankf = new BankButtonsFacade(pinNumber);
         bankf.showDepositButton();
         bankf.showWithDrawButton();
         bankf.showFashCashButton();
         bankf.showBalanceButton();
         bankf.showMiniStatementButton();
         bankf.showPINChangeButton();
         bankf.showExitButton();
    }
    
    
    public static void main(String[] args){
        new Home("");
    }
    
}
