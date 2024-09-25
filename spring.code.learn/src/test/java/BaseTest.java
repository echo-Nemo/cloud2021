import com.echo.AopMain;
import com.echo.service.FinanceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AopMain.class)
public class BaseTest {

    @Resource
    FinanceService financeService;


    @Test
    public void testAopAnotation(){
        financeService.addMoney(100);
    }
}
