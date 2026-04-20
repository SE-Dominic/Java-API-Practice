package facade;
import java.util.Scanner;
import data.UserRepository;
import model.User;

public class ClientFacade {
    UserRepository repository;
    Scanner scanner;

    public ClientFacade() {
        this.repository = new UserRepository();
        this.scanner = new Scanner(System.in);
        this.repository.populateUserDB();
    }
    public void showAllUsers() {
        if (this.repository.databaseSize() > 0) {
            repository.displayAllUsersInDB();
        }
        return;
    }
    public void showUser(int id_) {
        this.repository.displayUser(id_);
    }
    public void showUserCompany(int key) {
        User tUser = this.repository.getUser(key);
        System.out.println("Company Name: " + tUser.company.name + "\nCatchphrase: " + tUser.company.catchPhrase + "\nDescription: " + tUser.company.bs);
    }
}
