package personal.frank.fraud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("api/v1/fraud-check")
public record FraudController(FraudCheckService fraudCheckService) {
    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraud(@PathVariable("customerId") Integer customerId){
        Boolean isFraudCustomer = fraudCheckService.isFraudCustomer(customerId);
        log.info("Checked customer with id: {} and the result is: {}", customerId, isFraudCustomer);
        return new FraudCheckResponse(isFraudCustomer);
    }
}
