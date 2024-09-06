package JavaMiddle.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class RegPeople {
    @NotBlank
    public String name;
}
