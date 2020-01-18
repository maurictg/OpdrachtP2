package netflix.controllers;

import com.maurict.orm.Database;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import netflix.app.AccountManager;
import netflix.app.Cache;
import netflix.models.Account;


public class HomeController extends Controller {

    @FXML
    private ComboBox cbAccounts;

    @FXML
    private Button btnEditAccount;

    @FXML
    private Button btnManageProfiles;

    @FXML
    public void btnAbout_Click() {
        this.show("About");
    }

    @FXML
    public void btnExit_Click(ActionEvent e){
        System.exit(0);
    }

    @FXML
    public void btnNewAccount_Click() {
        AccountManager.isEdit = false;
        this.show("Account");
    }

    @FXML
    public void btnEditAccount_Click(){
        this.show("Account");
    }

    @FXML
    public void btnViews_Click() {
        this.show("Views");
    }

    @FXML
    public void btnManageProfiles_Click(){
        this.show("Profile");
    }

    @FXML
    public void cbAccounts_Change() {
        for (Account a : Cache.accounts) {
            if(a.accountName.equals((String)cbAccounts.getValue())){
                AccountManager.selected = a;
                AccountManager.isEdit = true;
                btnEditAccount.setVisible(true);
                btnManageProfiles.setVisible(true);
            }
        }
    }

    @Override
    void onLoad() {
        btnEditAccount.setVisible(false);
        btnManageProfiles.setVisible(false);
        try{
            for (Account o: Cache.accounts) {
                cbAccounts.getItems().add(o.accountName);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        AccountManager.isEdit = false;
    }
}
