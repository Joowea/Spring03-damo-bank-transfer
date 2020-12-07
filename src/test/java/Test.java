
import com.joo.domain.Account;
import com.joo.service.IAccountService;
import config.SpringConfiguration;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class Test {

    @Autowired
    private IAccountService as;

    @org.junit.Test
    public void testTransfer(){

        //1.获取容器
        //ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.得到业务层对象
        //as = ac.getBean("accountService",IAccountService.class);
        //3.执行方法
        System.out.println(as.findAllAccount());

        as.transfer("aaa","bbb",200f);

    }

    @org.junit.Test
    public void testFindAll(){

        //3.执行方法
        System.out.println(as.findAllAccount());
    }

    @org.junit.Test
    public void testFindById(){

        System.out.println(as.findAccountById(2));
    }

    @org.junit.Test
    public void testSave(){

        Account a1 = new Account();
        a1.setName("ggg");
        a1.setMoney(10000f);
        as.saveAccount(a1);
    }

    @org.junit.Test
    public void testDelete(){

        as.deleteAccount(4);
        as.deleteAccount(7);
    }

    /*@org.junit.Test
    public void testQueryRunner(){

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        QueryRunner runner1 = ac.getBean("runner",QueryRunner.class);
        QueryRunner runner2 = (QueryRunner) ac.getBean("runner");

        System.out.println(runner1==runner2);
    }
*/
    @org.junit.Test
    public void testUpdate(){

        Account account = as.findAccountById(3);

        account.setMoney(10000f);

        as.updateAccount(account);
    }
}
