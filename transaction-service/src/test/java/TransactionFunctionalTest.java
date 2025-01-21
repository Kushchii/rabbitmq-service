import com.pdp.mail.api.request.TransactionsRequest;
import com.pdp.mail.api.response.TransactionsResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransactionFunctionalTest extends BaseFunctionalTest {

    private static final UUID TRANSACTION_ID = UUID.fromString("221dc9a8-81e7-4bee-afc8-3cd83aae580d");
    private static final String USER_ID = "1e0d2473-1396-4d4b-a8b0-9f2c2efef805";
    private static final BigDecimal AMOUNT = new BigDecimal("1.00");
    private static final String CURRENCY = "UAH";
    private static final String DESCRIPTION = "T-shirt";
    private static final String TRANSACTION_STATUS_PENDING = "pending";
    private static final String TRANSACTION_STATUS_SUCCESS = "success";


    private TransactionsRequest createTransactionRequest() {
        var request = new TransactionsRequest();
        request.setId(TRANSACTION_ID);
        request.setStatus(TRANSACTION_STATUS_PENDING);
        request.setUserId(USER_ID);
        request.setAmount(AMOUNT);
        request.setCurrency(CURRENCY);
        request.setDescription(DESCRIPTION);
        return request;
    }

    private TransactionsRequest createTransactionSuccessRequest() {
        var request = new TransactionsRequest();
        request.setId(TRANSACTION_ID);
        request.setStatus(TRANSACTION_STATUS_SUCCESS);
        request.setUserId(USER_ID);
        request.setAmount(AMOUNT);
        request.setCurrency(CURRENCY);
        request.setDescription(DESCRIPTION);
        return request;
    }

    @Test
    @DisplayName("Successful transaction")
    void shouldProcessTransactionSuccessfully() {
        var transactionsRequest = createTransactionRequest();
        var expectedResponse = new TransactionsResponse("Transaction processed successfully");

        var actualResponse = doPost("/api/transactions", transactionsRequest, TransactionsResponse.class);

        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    @DisplayName("Successful transaction and send message")
    void shouldProcessTransactionSuccessfullyAndSendMessage() {
        var transactionsRequest = createTransactionSuccessRequest();
        var expectedResponse = new TransactionsResponse("Transaction processed successfully");

        var actualResponse = doPost("/api/transactions", transactionsRequest, TransactionsResponse.class);

        assertEquals(expectedResponse, actualResponse);
    }
}
