package personal.frank.customer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public record Customer(
        Integer id,
        String firstName,
        String lastName,
        String email) {
}
