package personal.frank.fraud;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/fraud-check")
@RestController
public record FraudController(FraudCheckService fraudCheckService) {

    @GetMapping(params = "{customerId}")
    public FraudCheckResponse isFraud(@PathVariable("customerId") Integer customerId){
        Boolean isFraudCustomer = fraudCheckService.isFraudCustomer(customerId);
        return new FraudCheckResponse(isFraudCustomer);
    }
}
