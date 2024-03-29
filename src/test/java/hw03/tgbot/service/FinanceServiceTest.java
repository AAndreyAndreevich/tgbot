package hw03.tgbot.service;

import hw03.tgbot.repository.IncomeRepository;
import hw03.tgbot.repository.SpendRepository;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

class FinanceServiceTest {

    @InjectMocks
    private FinanceService financeService;

    @Mock
    private SpendRepository spendRepository;

    @Mock
    private IncomeRepository incomeRepository;

    @BeforeEach
    public void beforeAll() {
        System.out.println(System.currentTimeMillis());
    }

    @AfterEach
    public void afterEach() {
        System.out.println(System.currentTimeMillis());
    }

    @DisplayName("ADD_INCOME_test")
    @Test
    public void addFinanceOperationAddIncomeTest() {
        String price = "200.0";
        String message = financeService.addFinanceOperation("/addincome", price, 500L);
        assertEquals("Доход в размере " + price + " был успешно добавлен", message);
    }

    @DisplayName("non_ADD_INCOME_test")
    @Test
    public void addFinanceOperationElseBranchTest() {
        String price = "200";
        String message = financeService.addFinanceOperation("/nan", price, 250L);
        assertEquals("Расход в размере " + price + " был успешно добавлен", message);
    }
}