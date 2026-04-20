import facade.ClientFacade;
public class Main {
    public static void main(String[] args) {
        ClientFacade client = new ClientFacade();
        client.showAllUsers();
        client.showUserCompany(1);
    }
}
