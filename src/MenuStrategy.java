import java.util.HashMap;

public interface MenuStrategy {
    UserAccountType getAccountType();
    HashMap<String, String> getAccountHolderInformation();
    public void ShowMenuOption();
    String[] getAccountMenuOptions();
    void nextMenuOption();
    void previousMenuOption();
}
