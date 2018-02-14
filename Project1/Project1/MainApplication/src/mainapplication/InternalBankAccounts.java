/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainapplication;


/**
 *
 * @author chris
 */
public class InternalBankAccounts {
    
    private DataBaseAccess DB;
    private StringBuilder transactions = new StringBuilder();
    private final int user_id;
    private final String userName;
    
    public InternalBankAccounts(int user_id, String userName, DataBaseAccess DB){
            this.user_id = user_id;
            this.userName = userName;
            this.DB = DB;
    }
    
    private void DisplayUserBalance(){
        DB.DisplayUserBalance(user_id ,userName, transactions);

    }
    
    private void DisplayALLUsersBalance(){
        DB.DisplayALLUsersBalance(userName, transactions);
    }
    
    private void DepositToMembersAccount(){
        DB.DepositToMembersAccount(user_id, transactions, userName);
    }
    
    private void WithDrawFromMembersAccount(){
        DB.WithDrawFromMembersAccount(user_id, transactions, userName);
    }    
    
    private void DepositToCooperativeAccount(){
        DB.DepositToCooperativeAccount(user_id, transactions, userName);
    }  
    
    private void DepositToAllMembersAccount(){
        DB.DepositToAllMembersAccount(user_id, transactions, userName);
    }
    
    public void SimpleMemberActions(int action){
        switch (action) {
            case 1:
                 DisplayUserBalance();
                break;
            case 2:
                DepositToCooperativeAccount();
                break;
            case 3:
                DepositToMembersAccount();
                break;
            case 4:
                FilesAccess.filewriter(transactions, userName);
                break;  
            default:
                break;
        }
    }
    
    public void SuperAdminActions(int action){
        switch (action) {
            case 1:
                 DisplayUserBalance();
                break;
            case 2:
                 DisplayALLUsersBalance();
                break;
            case 3:
                DepositToAllMembersAccount();
                break;
            case 4:
                WithDrawFromMembersAccount();
                break;
            case 5:
                FilesAccess.filewriter(transactions, userName);
                break;   
            default:
                break;              
        }
    }
    
}