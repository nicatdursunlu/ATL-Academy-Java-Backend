package az.academy.atl;

//import az.academy.atl.config.AccountConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
//        ApplicationContext applicationContext  = new AnnotationConfigApplicationContext(AccountConfig.class);
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

//        AccountService accountService = applicationContext.getBean(AccountService.class);
//        accountService.printStatus();
//        accountService.getAccountRepository().printStatus();

        App1 app1 = applicationContext.getBean(App1.class);
        app1.printStatus();

        App2 app2 = applicationContext.getBean(App2.class);
        app2.printStatus();

//        AccountRepository accountRepository = applicationContext.getBean(AccountRepository.class);
//        accountRepository.printStatus();

    }
}
